package logic;

import javafx.scene.image.Image;

public class TowerSelfDestruct extends Tower{

	public TowerSelfDestruct(){
		super();
		cost = 50;
		strength = 50;
		currentImage = new Image("file:./../images/selfDestructTower.png");
		description = "SelfDestructTower";
		price = 290;
		name = "Self Destruct Tower";
	}

	@Override
	public Tower getInstance() {
		// TODO Auto-generated method stub
		
		return new TowerSelfDestruct();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}

