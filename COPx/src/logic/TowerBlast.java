package logic;

import javafx.scene.image.Image;

public class TowerBlast extends Tower{

	public TowerBlast(){
		super();
		cost = 20;
		strength = 20;
		currentImage = new Image("file:./../images/blastTower.png");
		description = "BlastTower";
		price = 230;
		name = "Blast Tower";
	}

	@Override
	public Tower getInstance() {
		// TODO Auto-generated method stub
		
		return new TowerBlast();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}

