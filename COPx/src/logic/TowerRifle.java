package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class TowerRifle extends Tower{

	public TowerRifle(){
		super(325, 10);
		cost = 10;
		currentImage = new Image("file:./../images/rifleTower.png");
		description = "RifleTower";
		price = 240;
		name = "Rifle Tower";
		this.range = new RangeCircular(currentCell,1);
		
	}

	@Override
	public Tower getInstance() {
		
		
		return new TowerRifle();
	}




}
