package logic;

import javafx.scene.image.Image;

public class Player extends Entity{
    private Image currentimg;
    private Direction dir;
    private Loadout loadout;
    private int balance;
        
    private static final Image rightFacingIMG = new Image("file:./../images/RightFacing.png");
    private static final Image rearFacingIMG = new Image("file:./../images/RearFacing.png");
    private static final Image leftFacingIMG = new Image("file:./../images/LeftFacing.png");
    private static final Image frontFacingIMG = new Image("file:./../images/FrontFacing.png");
    
    public Player(Cell cell, Loadout loadout){
    	super(200, 50);
    		currentimg = leftFacingIMG;
        this.currentCell = cell;
        cell.setEntityInCell(this);
        this.loadout = loadout;
        this.dir = Direction.EAST;
        balance = 1000;
    }
    @Override 
	public Cell getCurrentCell(){
        return this.currentCell;
    }
	@Override
    public void setCurrentCell(Cell cell){
        this.currentCell = cell;
    }

	public Image getImg() {
		return currentimg;
	}
	
	public void turnCCW() {
	    	switch(dir){

	   		case NORTH:
	   			dir = Direction.EAST;
	   	    		currentimg = rightFacingIMG;
	   			break;
	   		case EAST:
	   			dir = Direction.SOUTH;
	   	    		currentimg = rearFacingIMG;
	   			break;
	   		case SOUTH:
	   			dir = Direction.WEST;
	   	    		currentimg = leftFacingIMG;
	   			break;
	   		case WEST:
	   			dir = Direction.NORTH;
	   	    		currentimg = frontFacingIMG;
	   			break;	
	   		default:
	   			break;
	    	}
	}
	public void turnCW(){
	   	switch(dir){
	   		case EAST:
	   			dir = Direction.NORTH;
	   	    		currentimg = frontFacingIMG;
	   			break;
	   		case SOUTH:
	   			dir = Direction.EAST;
	   	    		currentimg = rightFacingIMG;
	   			break;
	   		case WEST:
	   			dir = Direction.SOUTH;
	   			currentimg = rearFacingIMG;
	   			break;
	   		case NORTH:
	   			dir = Direction.WEST;
	   	    		currentimg = leftFacingIMG;
	   			break;
	   		default:
	   			break;	
	   	}		
	}

	public Direction getDirection() {
		return dir;
	}
	public Loadout getLoadout(){
		return loadout;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int i) {
		balance = i;
	}
    
}