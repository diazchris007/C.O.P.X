package logic;

import javafx.scene.image.Image;

public class RifleTower extends Tower{

	public RifleTower(){
		super();
		cost = 10;
		strength = 10;
		currentImage = new Image("file:./../images/military3_frontFacing.png");
	}

	@Override
	public Tower getInstance() {
		// TODO Auto-generated method stub
		
		return new RifleTower();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
