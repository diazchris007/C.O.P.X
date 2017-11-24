package logic;

import javafx.scene.image.Image;

public abstract class Tower extends Entity{
	Image currentImage;
	Cell currentCell;
	int strength;
	int cost;
	String description;
	int price;
	String name;
	
	public Tower(){
		currentImage = null;
		this.currentCell = null;
	}
	
	public Image getIcon() {
		return currentImage;
	}
	
	public String getDescription () {
		return description;
	}
    
	public Cell getCurrentCell(){
        return this.currentCell;
    }
	public void setCurrentCell(Cell cell){
		this.currentCell = cell;
		cell.setEntityInCell(this);
	}
	public abstract void attack();
	
	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return currentImage;
	}

	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract Tower getInstance();

}
