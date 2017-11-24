package logic;

import javafx.scene.image.Image;

public class TowerRifle extends Tower{

	public TowerRifle(){
		super();
		cost = 10;
		strength = 10;
		currentImage = new Image("file:./../images/rifleTower.png");
		description = "RifleTower";
		price = 240;
		name = "Rifle Tower";
	}

	@Override
	public Tower getInstance() {
		// TODO Auto-generated method stub
		
		return new TowerRifle();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}
