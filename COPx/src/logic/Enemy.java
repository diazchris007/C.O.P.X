package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Enemy extends Entity {
	
    protected Image currentImage;
    protected Direction dir;
    protected Entity target;
	public Enemy(int health,int attack, Cell startCell,Entity target){
		super(health, attack);
		currentImage = null;
		this.currentCell = startCell;
		this.target = target;
	}
	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return currentImage;
	}
	public void setTarget(Entity target) {
		// TODO Auto-generated method stub
		this.target = target;
	}
	public Entity getTarget() {
		return target;
	}
	public Cell[][] moveToTarget(Board board) {
		
		Cell targetCell = target.getCurrentCell();
		Location targetLoc = targetCell.getLocation();
		Location currentLoc = currentCell.getLocation();
		int currentX = currentLoc.getX();
		int currentY = currentLoc.getY();
		int targetX = targetLoc.getX();
		int targetY = targetLoc.getY();
		if(targetX == currentX) {
			if(((targetY - 1) == currentY) || ((targetY + 1) == currentY)) {
				System.out.println("Target is infront");
			}
			else if(targetY > currentY) {
				return moveDown(board);
			}
			else if(targetY < currentY) {
				return moveUp(board);
			}
			
		}
		else if(targetY == currentY) {
			if(((targetX - 1) == currentX) || ((targetX + 1) == currentX)) {
				System.out.println("Target is infront");
			}
			else if(targetX > currentX) {
				return moveRight(board);
			}
			else if(targetX < currentX) {
				return moveLeft(board);
			}

		}
		else {
			if(targetX > currentX) {
				return moveRight(board);
			}
			else {
				return moveLeft(board);
			}
		}
		
		return board.getCells();
	}
	public ArrayList<Entity> getNearby(){
		ArrayList<Cell> nearby =range.getNearby();
		ArrayList<Entity> entities = new ArrayList<Entity>();
		for(Cell c : nearby){
			Entity ent = c.getEntityInCell();
			if(ent.getClass().getSuperclass().equals(Tower.class)){
				entities.add(ent);
			}
			else if(c.getEntityInCell().getClass().equals(Player.class)){
				entities.add(ent);
			}
		}
		return entities;
	}
	public ArrayList<Entity> attack(){
		ArrayList<Entity> entities = getNearby();
		ArrayList<Entity> deadEntities = new ArrayList<Entity>();
		if(entities.size()>0){
			System.out.println("Entity :" + entities.get(0));
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
				System.out.println(ent.getClass() + " is now at " + ent.getHealth());
			}
		}
		return deadEntities;
	}

}
