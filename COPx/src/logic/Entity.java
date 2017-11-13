package logic;

import javafx.scene.image.Image;

public abstract class Entity {
	protected String name;
	protected int health;
	protected Cell currentCell;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	/**
	 * @return the location
	 */

	public abstract Image getImg();
	public Cell getCurrentCell() {
		// TODO Auto-generated method stub
		return currentCell;
	}
	public void setCurrentCell(Cell nextCell) {
		// TODO Auto-generated method stub
		this.currentCell = nextCell;
	}
	
	public Cell[][] moveDown(Board board) {
		// TODO Auto-generated method stub
        Cell nextCell = null;
        Cell cells[][];
        cells = board.getCells();
        int x = currentCell.getLocation().getX();
        int y = currentCell.getLocation().getY();
        System.out.println(name + " at" + x + ", "+ y);
        
        //if not at the end of board
        if (y+1 < cells[0].length){
			cells[x][y].clearEntityInCell();
            nextCell = cells[x][y + 1];
            System.out.println("moving Entity down");
        	setCurrentCell(nextCell);
            nextCell.setEntityInCell(this);
		}
        //if index was out of range, what do we do now?
        else{
        	//Wrap around
            this.setCurrentCell(cells[x][0]);
            cells[x][0].setEntityInCell(this);
            cells[x][y].clearEntityInCell();
        }
        
        return cells;
	}
    public Cell[][] moveUp(Board board) {
        Cell nextCell = null;
        Cell cells[][];
        cells = board.getCells();
        int x = currentCell.getLocation().getX();
        int y = currentCell.getLocation().getY();
        System.out.println("Player at" + x+ ", "+ y);
        
        if (y-1 >= 0){
			cells[x][y].clearEntityInCell();
            nextCell = cells[x][y - 1];
            System.out.println("moving player up");
        	this.setCurrentCell(nextCell);
            nextCell.setEntityInCell(this);
		}
        
        //index was out of range, wrap around.
        else{
        	this.setCurrentCell(cells[x][cells[0].length -1]);
            cells[x][cells[0].length-1].setEntityInCell(this);
            cells[x][y].clearEntityInCell();
        }
        return cells;
    }
    
    public Cell[][] moveLeft(Board board) {
        Cell nextCell = null;
        Cell cells[][];
        cells = board.getCells();
        int x = currentCell.getLocation().getX();
        int y = currentCell.getLocation().getY();
        
        if (x-1 >= 0){
			cells[x][y].clearEntityInCell();
            nextCell = cells[x-1][y];
            System.out.println("moving player left");
        	this.setCurrentCell(nextCell);
            nextCell.setEntityInCell(this);
		}
       //index was out of range
        else{
        	//System.out.println("Player reached end" + x+ ", "+ y);
            this.setCurrentCell(cells[cells.length -1][y]);
            cells[cells.length -1][y].setEntityInCell(this);
            cells[x][y].clearEntityInCell();
        }
        
        return cells;
    }
    public Cell[][] moveRight(Board board) {
        Cell nextCell = null;
        Cell cells[][];
        cells = board.getCells();
        int x = currentCell.getLocation().getX();
        int y = currentCell.getLocation().getY();
        
        if (x+1 < cells.length){
			cells[x][y].clearEntityInCell();
            nextCell = cells[x+1][y];
            System.out.println("moving player right");
        	this.setCurrentCell(nextCell);
            nextCell.setEntityInCell(this);
		}
        else{
        	this.setCurrentCell(cells[0][y]);
            cells[0][y].setEntityInCell(this);
            cells[x][y].clearEntityInCell();
        }
        return cells;
    }
    
	
}
