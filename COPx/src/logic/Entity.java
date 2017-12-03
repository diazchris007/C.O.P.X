package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.scene.image.Image;


public abstract class Entity{
	protected String name;
	protected int currentHealth;
	protected Cell currentCell;
	protected int maxHealth;
	protected Range range;
	protected int attackDamage;
	protected long lastAttacked;
	protected long timeBetweenAttack;
	protected long lastMoved;
	protected long timeBetweenMove;
	protected Board board;
	/**
	 * @return the name
	 */
	public Entity(int health, int attk){
		this.currentHealth = health;
		this.maxHealth = health;
		this.attackDamage = attk;
		this.board = Board.getInstance();
		
	}
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
		return currentHealth;
	}
	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.currentHealth = health;
	}
	/**
	 * @return the location
	 */

	public abstract Image getImg();
	public Cell getCurrentCell() {
		
		return currentCell;
	}
	public void setCurrentCell(Cell nextCell) {
		
		this.currentCell = nextCell;
		range.recalculate(nextCell);
	}
	public boolean moveDown( ) {
		long newTime = new Date().getTime();
		long temp = newTime - lastMoved;
		System.out.println("trying to move down");
		if(temp < timeBetweenMove) {
			return false;
		}
		System.out.println("trying to move down");
        Cell nextCell = null;
        Cell[][] cells;
        cells = board.getCells();
        int x = currentCell.getLocation().getX();
        int y = currentCell.getLocation().getY();
        
        
        //if not at the end of 
        if (y+1 < cells[0].length){
			
            nextCell = cells[x][y + 1];
            if(nextCell.hasEntity()) {

    			System.out.println("move down didnt work");
            	return false;
            }
            cells[x][y].clearEntityInCell();
            
        	setCurrentCell(nextCell);
            nextCell.setEntityInCell(this);
		}
        //if index was out of range
        else{
        	//Wrap around
            this.setCurrentCell(cells[x][0]);
            cells[x][0].setEntityInCell(this);
            cells[x][y].clearEntityInCell();
        }

		lastMoved = newTime;
		board.setCells(cells);
        return true;
	}
    public boolean moveUp( ) {
		long newTime = new Date().getTime();
		long temp = newTime - lastMoved;
		if(temp < timeBetweenMove) {
			return false;
		}
		
        Cell nextCell = null;
        Cell[][] cells;
        cells = board.getCells();
        int x = currentCell.getLocation().getX();
        int y = currentCell.getLocation().getY();
        
        
        if (y-1 >= 0){
			
            nextCell = cells[x][y - 1];
            if(nextCell.hasEntity()) return false;
            cells[x][y].clearEntityInCell();
            
        	this.setCurrentCell(nextCell);
            nextCell.setEntityInCell(this);
		}
        
        //index was out of range, wrap around.
        else{
        	this.setCurrentCell(cells[x][cells[0].length -1]);
            cells[x][cells[0].length-1].setEntityInCell(this);
            cells[x][y].clearEntityInCell();
        }
		lastMoved = newTime;
		board.setCells(cells);
        return true;
    }
    
    public boolean moveLeft( ) {
		long newTime = new Date().getTime();
		long temp = newTime - lastMoved;
		if(temp < timeBetweenMove) {
			return false;
		}
        Cell nextCell = null;
        Cell[][] cells;
        cells = board.getCells();
        int x = currentCell.getLocation().getX();
        int y = currentCell.getLocation().getY();
        
        if (x-1 >= 0){
			
            nextCell = cells[x-1][y];
            if(nextCell.hasEntity()) return false;
            cells[x][y].clearEntityInCell();
            
        	this.setCurrentCell(nextCell);
            nextCell.setEntityInCell(this);
		}
       //index was out of range
        else{
        	
            this.setCurrentCell(cells[cells.length -1][y]);
            cells[cells.length -1][y].setEntityInCell(this);
            
            cells[x][y].clearEntityInCell();
        }
		lastMoved = newTime;
        board.setCells(cells);
        return true;
    }
    public boolean moveRight( ) {
		long newTime = new Date().getTime();
		long temp = newTime - lastMoved;
		if(temp < timeBetweenMove) {
			return false;
		}
        Cell nextCell = null;
        Cell[][] cells;
        cells = board.getCells();
        int x = currentCell.getLocation().getX();
        int y = currentCell.getLocation().getY();
        
        if (x+1 < cells.length){
			
            nextCell = cells[x+1][y];
            System.out.println(nextCell.hasEntity());
            if(nextCell.hasEntity()) return false;
            cells[x][y].clearEntityInCell();
            
        	this.setCurrentCell(nextCell);
            nextCell.setEntityInCell(this);
		}
        else{
        	this.setCurrentCell(cells[0][y]);
            cells[0][y].setEntityInCell(this);
            cells[x][y].clearEntityInCell();
        }
		lastMoved = newTime;
		board.setCells(cells);
        return true;
    }
	public float getHeathPercent() {
		return (float)currentHealth/(float)maxHealth;
	}
	public List<Entity> getNearbyEntities(  int range){
		ArrayList<Entity> entites = new ArrayList<>();
		Cell[][] cells = board.getCells();
		Location loc = currentCell.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		for(int i = 1 ; i < range; i++) {
			cells[x][y].getEntityInCell();
		}
		return entites;
	}
	public int getWealth() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setBalance(int i) {
		// TODO Auto-generated method stub
		
	}

    
	
}