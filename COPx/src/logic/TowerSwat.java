package logic;

import javafx.scene.image.Image;

public class TowerSwat extends Tower{

	public TowerSwat(){
		super();
		cost = 50;
		strength = 100;
		currentImage = new Image("file:./../images/swatTower.png");
		description = "SwatTower";
		price = 230;
		name = "Swat Tower";
	}

	@Override
	public Tower getInstance() {
		// TODO Auto-generated method stub
		
		return new TowerSwat();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}



