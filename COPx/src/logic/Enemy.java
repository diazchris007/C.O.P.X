package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Enemy extends Entity {
	
    protected Image currentImage;
    protected Direction dir;
    protected Entity target;
    protected int bounty;
	public Enemy(int health,int attack, int bounty,Cell startCell,Entity target){
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
	public void setTarget(Entity target) {
		
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
			if(((targetY - 1) == currentY) || ((targetY + 1) == currentY)) {
				
			}
			else if(targetY > currentY) {
				if(moveDown())
					return true;
				else {
					//Find Alt path
					return false;
				}
			}
			else if(targetY < currentY) {
				if(moveUp()) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		else if(targetY == currentY) {
			
			if(targetX > currentX) {
				if(moveRight())
					return true;
				else {
					return false;
				}
			}
			else {
				if(moveLeft())
					return true;
				else {
					return false;
				}
			}
		}
		else {

			if(targetY > currentY) {
				if(moveDown()) {
					return true;
				}
				if(targetX > currentX) {
					if(moveRight())
						return true;
					else {
						return false;
					}

				}
			}
			else{
				if(moveUp()) {
					return true;
				}
				if(targetX > currentX) {
					if(moveRight())
						return true;
					else {
						return false;
					}
				}
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
			
			PriorityQueue<Entity> queue = new PriorityQueue<>(entities.size(), new Comparator<Entity>(){
	
				@Override
				public int compare(Entity arg0, Entity arg1) {
					if(arg0.getHeathPercent() > arg1.getHeathPercent())
						return 1;
					if(arg0.getHeathPercent() < arg1.getHeathPercent())
						return -1;
					return 0;
					
				}
				
			});
			
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
		// TODO Auto-generated method stub
		target.setBalance(target.getWealth() + bounty);
		
	}

}
