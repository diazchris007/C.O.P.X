package logic;


import java.util.List;

public abstract class Range {
	int maxDistance;
	int currentX;
	int currentY;
	Location loc;
	public Range(Cell cell, int maxDistance){
		if(cell != null){
			loc = cell.getLocation();
			this.currentX = loc.getX();
			this.currentY = loc.getY();
		}
		this.maxDistance = maxDistance;
	}
	public abstract List<Cell> getNearby();
	public void recalculate(Cell nextCell) {
		
		Location locs = nextCell.getLocation();
		this.currentX = locs.getX(); 
		this.currentY = locs.getY();		
		
	}
}
