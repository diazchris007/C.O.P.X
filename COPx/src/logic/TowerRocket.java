package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class TowerRocket extends Tower{

	public TowerRocket(){
		super(200, 30);
		cost = 30;
		currentImage = new Image("file:./../images/rocketTower.png");
		description = "RocketTower";
		price = 150;
		name = "Rocket Tower";
		this.range = new RangeCircular(currentCell,1);
	}




	@Override
	public Tower getInstance() {
		return new TowerRocket();
	}


	
}
