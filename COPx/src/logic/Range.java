package logic;

import java.util.ArrayList;

public abstract class Range {
	int maxDistance;
	int currentX;
	int currentY;
	Location loc;
	public Range(Cell cell, int maxDistance){
		Location loc = cell.getLocation();
		this.maxDistance = maxDistance;
		this.currentX = loc.getX();
		this.currentY = loc.getY();
	}
	public abstract ArrayList<Cell> getNearby();
	public void recalculate(Cell nextCell) {
		// TODO Auto-generated method stub
		Location loc = nextCell.getLocation();
		this.currentX = loc.getX();
		this.currentY = loc.getY();		
		
	}
}
