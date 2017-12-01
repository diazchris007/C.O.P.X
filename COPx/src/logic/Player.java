package logic;

import javafx.scene.image.Image;

public class Player extends Entity{
    private Image currentimg;
    private Direction dir;
    private Loadout loadout;
    private int balance;
    private static final String DEFAULTIMG = "file:./../images/RightFacing.png";
    public Player(Cell cell, Loadout loadout){
    	super(200, 50);
    	currentimg = new Image(DEFAULTIMG);
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
   			dir = Direction.NORTHEAST;
   			
   			break;
   		case NORTHEAST:
   			dir = Direction.EAST;
   	    	currentimg = new Image(DEFAULTIMG);
   			
   			break;
   		case EAST:
   			dir = Direction.SOUTHEAST;
   			
   			break;
   		case SOUTHEAST:
   			dir = Direction.SOUTH;
   	    	currentimg = new Image("file:./../images/RearFacing.png");
   			
   			break;
   		case SOUTH:
   			dir = Direction.SOUTHWEST;
   			
   			break;
   		case SOUTHWEST:
   			dir = Direction.WEST;
   	    	currentimg = new Image("file:./../images/LeftFacing.png");
   			
   			break;
   		case WEST:
   			dir = Direction.NORTHWEST;
   			
   			break;
   		case NORTHWEST:
   			dir = Direction.NORTH;
   	    	currentimg = new Image("file:./../images/FrontFacing.png");
   			
   			break;
     			
   			
   		default:
   			break;
   			
    	}
	}
	public void turnCW(){
		
	   	switch(dir){
   		case NORTH:
   			dir = Direction.NORTHWEST;
   			
   			break;
   		case NORTHEAST:
   			dir = Direction.NORTH;
   	    	currentimg = new Image("file:./../images/FrontFacing.png");
   			
   			break;
   		case EAST:
   			dir = Direction.NORTHEAST;
   			
   			break;
   		case SOUTHEAST:
   			dir = Direction.EAST;
   	    	currentimg = new Image(DEFAULTIMG);
   			
   			break;
   		case SOUTH:
   			dir = Direction.SOUTHEAST;
   			
   			break;
   		case SOUTHWEST:
   			dir = Direction.SOUTH;
   	    	currentimg = new Image("file:./../images/RearFacing.png");

   			
   			break;
   		case WEST:
   			dir = Direction.SOUTHWEST;
   			
   			break;
   		case NORTHWEST:
   			dir = Direction.WEST;
   	    	currentimg = new Image("file:./../images/LeftFacing.png");
   			
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