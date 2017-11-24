package logic;

import javafx.scene.image.Image;

public class TowerHeavy extends Tower{

	public TowerHeavy(){
		super();
		cost = 40;
		strength = 80;
		currentImage = new Image("file:./../images/heavyTower.png");
		description = "HeavyTower";
		price = 210;
		name = "Heavy Tower";
	}

	@Override
	public Tower getInstance() {
		// TODO Auto-generated method stub
		
		return new TowerHeavy();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}


