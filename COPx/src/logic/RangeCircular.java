package logic;

import java.util.ArrayList;
import java.util.List;

public class RangeCircular extends Range {

	public RangeCircular(Cell cell, int maxDistance) {
		
		super(cell, maxDistance);
		
	}

	@Override
	public List<Cell> getNearby() {
		
		Cell[][] cells = Board.getInstance().getCells();
		ArrayList<Cell> nearby =  new ArrayList<>();
		int maxY = currentY + maxDistance;
		int maxX = currentX + maxDistance;
		int minX = currentX - maxDistance;
		int minY = currentY - maxDistance;
		if(maxY > cells.length){
			maxY = cells.length;
		}
		if(maxX> cells[0].length){
			maxX = cells[0].length;
		}
		if(minX<0){
			minX = 0;
		}
		if(minY<0){
			minY = 0;
		}
		for(int i = minX; i <=maxX; i++){
			for(int j = minY; j<= maxY; j++){
				
				if(cells[i][j].hasEntity()){
					nearby.add(cells[i][j]);
				}
			}
		}
		nearby.remove(cells[currentX][currentY]);
		return nearby; 
	}

}
