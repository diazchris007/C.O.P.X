package logic;

import javafx.scene.image.Image;

public class Player extends Entity{
    private Image currentimg;
    private Direction dir;
    private Loadout loadout;
    private int balance;
    
    public Player(Cell cell, Loadout loadout){
    	super(200, 50);
    	currentimg = new Image("file:./../images/RightFacing.png");
        this.currentCell = cell;
        cell.setEntityInCell(this);
        this.loadout = loadout;
        this.dir = Direction.EAST;
        balance = 1000;
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
	
	public void turnCCW() {

		//TODO update current image 
    	switch(dir){
   		case NORTH:
   			dir = Direction.NORTHEAST;
   			System.out.println("Facing NorthEast");
   			break;
   		case NORTHEAST:
   			dir = Direction.EAST;
   	    	currentimg = new Image("file:./../images/RightFacing.png");
   			System.out.println("Facing East");
   			break;
   		case EAST:
   			dir = Direction.SOUTHEAST;
   			System.out.println("Facing SouthEast");
   			break;
   		case SOUTHEAST:
   			dir = Direction.SOUTH;
   	    	currentimg = new Image("file:./../images/RearFacing.png");
   			System.out.println("Facing South");
   			break;
   		case SOUTH:
   			dir = Direction.SOUTHWEST;
   			System.out.println("Facing SouthWest");
   			break;
   		case SOUTHWEST:
   			dir = Direction.WEST;
   	    	currentimg = new Image("file:./../images/LeftFacing.png");
   			System.out.println("Facing West");
   			break;
   		case WEST:
   			dir = Direction.NORTHWEST;
   			System.out.println("Facing NorthWest");
   			break;
   		case NORTHWEST:
   			dir = Direction.NORTH;
   	    	currentimg = new Image("file:./../images/FrontFacing.png");
   			System.out.println("Facing North");
   			break;
     			
   			
   		default:
   			break;
   			
    	}
	}
	public void turnCW(){
		//TODO update current image 
	   	switch(dir){
   		case NORTH:
   			dir = Direction.NORTHWEST;
   			System.out.println("Facing NorthWest");
   			break;
   		case NORTHEAST:
   			dir = Direction.NORTH;
   	    	currentimg = new Image("file:./../images/FrontFacing.png");
   			System.out.println("Facing North");
   			break;
   		case EAST:
   			dir = Direction.NORTHEAST;
   			System.out.println("Facing NorthEast");
   			break;
   		case SOUTHEAST:
   			dir = Direction.EAST;
   	    	currentimg = new Image("file:./../images/RightFacing.png");
   			System.out.println("Facing East");
   			break;
   		case SOUTH:
   			dir = Direction.SOUTHEAST;
   			System.out.println("Facing SouthEast");
   			break;
   		case SOUTHWEST:
   			dir = Direction.SOUTH;
   	    	currentimg = new Image("file:./../images/RearFacing.png");

   			System.out.println("Facing South");
   			break;
   		case WEST:
   			dir = Direction.SOUTHWEST;
   			System.out.println("Facing SouthWest");
   			break;
   		case NORTHWEST:
   			dir = Direction.WEST;
   	    	currentimg = new Image("file:./../images/LeftFacing.png");
   			System.out.println("Facing West");
   			break;
   			
   		default:
   			break;
   			
    	}		
	}

	public Direction getDirection() {
		// TODO Auto-generated method stub
		return dir;
	}
	public Loadout getLoadout(){
		return loadout;
	}

	public int getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public void setBalance(int i) {
		// TODO Auto-generated method stub
		balance = i;
		
	}
    
}