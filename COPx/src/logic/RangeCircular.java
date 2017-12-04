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
		System.out.println(maxX + " " + maxY + " " + minX + " " + minY);
		if(maxY > cells[0].length){
			maxY = cells[0].length - 1;
		}
		if(maxX> cells.length){
			maxX = cells.length - 1;
		}
		if(minX<0){
			minX = 0;
		}
		if(minY<0){
			minY = 0;
		}

		System.out.println(maxX + " " + maxY + " " + minX + " " + minY);
		for(int i = minX; i <maxX; i++){
			for(int j = minY; j< maxY; j++){
				
				if(cells[i][j].hasEntity()){
					nearby.add(cells[i][j]);
				}
			}
		}
		nearby.remove(cells[currentX][currentY]);
		return nearby; 
	}

}
