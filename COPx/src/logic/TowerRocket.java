package logic;

import javafx.scene.image.Image;

public class TowerRocket extends Tower{

	public TowerRocket(){
		super();
		cost = 30;
		strength = 30;
		currentImage = new Image("file:./../images/rocketTower.png");
		description = "RocketTower";
		price = 150;
		name = "Rocket Tower";
	}

	@Override
	public Tower getInstance() {
		// TODO Auto-generated method stub
		
		return new TowerRocket();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}
