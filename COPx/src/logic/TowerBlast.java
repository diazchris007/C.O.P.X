package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class TowerBlast extends Tower{

	public TowerBlast(){
		super(230, 20);
		cost = 20;
		currentImage = new Image("file:./../images/blastTower.png");
		description = "BlastTower";
		price = 230;
		name = "Blast Tower";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		
		
		return new TowerBlast();
	}



	
}

