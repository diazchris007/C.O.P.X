package logic;

import java.util.ArrayList;

public class RangeCircular extends Range {

	public RangeCircular(Cell cell, int maxDistance) {
		
		super(cell, maxDistance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Cell> getNearby() {
		// TODO Auto-generated method stub
		Cell[][] cells = Board.getInstance().getCells();
		ArrayList<Cell> nearby =  new ArrayList<Cell>();
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
				System.out.println(i +" "+ j);
				if(cells[i][j].hasEntity()){
					nearby.add(cells[i][j]);
				}
			}
		}
		nearby.remove(cells[currentX][currentY]);
		return nearby;
	}

}
