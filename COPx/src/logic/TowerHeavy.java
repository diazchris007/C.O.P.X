package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class TowerHeavy extends Tower{

	public TowerHeavy(){
		super(210, 80);
		cost = 40;
		currentImage = new Image("file:./../images/heavyTower.png");
		description = "HeavyTower";
		price = 210;
		name = "Heavy Tower";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		
		
		return new TowerHeavy();
	}


	
}


