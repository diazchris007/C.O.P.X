package logic;

import java.util.ArrayList;
import java.util.List;

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
	public abstract List<Entity> attack();
	
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
}
