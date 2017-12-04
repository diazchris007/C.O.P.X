package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public abstract class Tower extends Entity{
	Image currentImage;
	
	int strength;
	int cost;
	String description;
	int price;
	
	
	public Tower(int health, int attack){
		super(health, attack);
		currentImage = null;
		this.currentCell = null;
	}
	
	public Image getIcon() {
		return currentImage;
	}
	
	public String getDescription () {
		return description;
	}
    
	@Override
	public void setCurrentCell(Cell cell){
		this.currentCell = cell;
		cell.setEntityInCell(this);
		range.recalculate(cell);
	}
	@Override
	public Image getImg() {
		
		return currentImage;
	}

	public int getCost() {
		
		return cost;
	}

	public int getPrice() {
		return price;
	}
	@Override
	public String getName() {
		return name;
	}
	
	public abstract Tower getInstance();
	public List<Entity> getNearby(){ 
		ArrayList<Cell> nearby = (ArrayList<Cell>) range.getNearby();
		ArrayList<Entity> entities = new ArrayList<>();
		for(Cell c : nearby){
			Entity ent = c.getEntityInCell();
			if(ent.getClass().getSuperclass().equals(Enemy.class)){
				entities.add(ent);
			}
		}
		return entities;
	}
	public List<Enemy> attack(){
		ArrayList<Entity> entities = (ArrayList<Entity>) getNearby();
		ArrayList<Enemy> deadEntities = new ArrayList<>();
		if(!entities.isEmpty()){
					
			PriorityQueue<Entity> queue = new PriorityQueue<>(entities.size(), new ComparatorAttack());
			
			for(Entity e : entities){
				if(e.getClass() != Player.class)
					queue.add(e);
			}
			if(queue.peek().getHealth() <= attackDamage){
				Entity ent = queue.poll();
				deadEntities.add((Enemy)ent);
			}
			else{
				Entity ent = queue.poll();
				ent.setHealth(ent.getHealth() - attackDamage);
				
			}
		}
		return deadEntities; 
	}

	public Range getRange() {
		return range;
	}
}
