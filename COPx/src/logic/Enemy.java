package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;

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
		
		return currentImage;
	}
	public void setTarget(Entity target) {
		
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
				
			}
			else if(targetY > currentY) {
				return moveDown(board);
			}
			else if(targetY < currentY) {
				return moveUp(board); 
			}
			
		}
		else if(targetY == currentY) {
			
			if(targetX > currentX) {
				return moveRight(board);
			}
			else {
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

}
