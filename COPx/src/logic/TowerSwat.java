package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class TowerSwat extends Tower{

	public TowerSwat(){
		super(500, 100);
		cost = 50;
		currentImage = new Image("file:./../images/swatTower.png");
		description = "SwatTower";
		price = 230;
		name = "Swat Tower";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		
		
		return new TowerSwat();
	}




}



