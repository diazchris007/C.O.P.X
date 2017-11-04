package logic;

import javafx.scene.image.Image;

public class Player extends Entity{
    private Cell currentCell;
    private Image currentimg;
    public Player(Cell cell){
    	currentimg = new Image("File:./../images/Player.png");
        this.currentCell = cell;
        cell.setEntityInCell(this);
    }
    
	public Cell getCurrentCell(){
        return this.currentCell;
    }

    public void setCurrentCell(Cell cell){
        this.currentCell = cell;
    }

	public Image getImg() {
		return currentimg;
	}

	public void turnCW() {
		//TODO update current image 
	}
	public void turnCCW(){
		//TODO update current image 
	}
    
}