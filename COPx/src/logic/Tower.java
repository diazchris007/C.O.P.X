package logic;

import javafx.scene.image.Image;

public abstract class Tower extends Entity{
	Image currentImage;
	Cell currentCell;
	int strength;
	int cost;
	
	public Tower(){
		currentImage = null;
		this.currentCell = null;
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

	public abstract Tower getInstance();

}
