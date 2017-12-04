package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public abstract class Enemy extends Entity {
	
    protected Image currentImage;
    protected Direction dir;
    protected Player target;
    protected int bounty;
	public Enemy(int health,int attack, int bounty,Cell startCell, Player target){
		super(health, attack);
		timeBetweenMove = 350;
		currentImage = null;
		this.currentCell = startCell;
		this.target = target;
		this.bounty = bounty;
	}
	@Override
	public Image getImg() {
		
		return currentImage;
	}
	public void setTarget(Player target) {
		
		this.target = target;
	}
	public Entity getTarget() {
		return target;
	}
	public boolean moveToTarget() {
		
		Cell targetCell = target.getCurrentCell();
		Location targetLoc = targetCell.getLocation();
		Location currentLoc = currentCell.getLocation();
		int currentX = currentLoc.getX();
		int currentY = currentLoc.getY();
		int targetX = targetLoc.getX();
		int targetY = targetLoc.getY();
		if(targetX == currentX) {
			moveDownOrUp(targetY, currentY);
		}
		else if(targetY == currentY) {
			return moveRightOrLeft(targetX, currentX);
		}
		else {
			return moveUpOrRight( targetY,  currentY,  targetX,  currentX);
		}
		return false;
				
	}
	
	private Boolean moveDownOrUp(int targetY, int currentY) {
		if(((targetY - 1) == currentY) || ((targetY + 1) == currentY)) {
			return false;
		}
		else if(targetY > currentY) {
			return moveDown(); //false = find alt path

		}
		else if(targetY < currentY) {
			return moveUp();
		}
		return false;
	}
	
	private Boolean moveRightOrLeft(int targetX, int currentX) {
		if(targetX > currentX) {
			return moveRight();
		}
		else {
			return moveLeft();
		}
	}
	
	private Boolean moveUpOrRight(int targetY, int currentY, int targetX, int currentX ) {
		if(targetY > currentY) {
			if(moveDown()) {
				return true;
			}
			
			if(targetX > currentX) {
				return moveRight();
			}
		}
		else{
			if(moveUp()) {
				return true;
			}
			if(targetX > currentX) {
				return moveRight();
			}
		}
		return false;
	}
	
	public List<Entity> getNearby(){
		ArrayList<Cell> nearby =(ArrayList<Cell>) range.getNearby();
		ArrayList<Entity> entities = new ArrayList<>();
		for(Cell c : nearby){
			Entity ent = c.getEntityInCell();
			if(ent.getClass().getSuperclass().equals(Tower.class) ||
					c.getEntityInCell().getClass().equals(Player.class)){
				entities.add(ent);
			}
			
		}
		return entities;
	}
	public List<Entity> attack(){
		long newTime = new Date().getTime();
		long temp = newTime - lastAttacked;
		if(temp < timeBetweenAttack){
			return  new ArrayList<>();
		}
		lastAttacked = newTime;
		ArrayList<Entity> entities = (ArrayList<Entity>) getNearby();
		ArrayList<Entity> deadEntities = new ArrayList<>();
		if(!entities.isEmpty()){
			
			PriorityQueue<Entity> queue = new PriorityQueue<>(entities.size(), new ComparatorAttack());
			
			for(Entity e : entities){
				queue.add(e);
			}
			if(queue.peek().getHealth() <= attackDamage){
				Entity ent = queue.poll();
				deadEntities.add(ent);
			}
			else{
				Entity ent = queue.poll();
				ent.setHealth(ent.getHealth() - attackDamage);
				
			}
		}
		return deadEntities;
	}
	public void payOut() {
		target.setBalance(((Player) target).getBalance() + bounty);
	}

}
