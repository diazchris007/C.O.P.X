package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class TowerSelfDestruct extends Tower{

	public TowerSelfDestruct(){
		super(200, 50);
		cost = 50;
		currentImage = new Image("file:./../images/selfDestructTower.png");
		description = "SelfDestructTower";
		price = 290;
		name = "Self Destruct Tower";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		return new TowerSelfDestruct();
	}



}

