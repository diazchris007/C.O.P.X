package logic;


import javafx.scene.image.Image;

public class TowerRocket extends Tower{

	public TowerRocket(){
		super(200, 30);
		cost = 30;
		currentImage = new Image("file:./../images/rocketTower.png");
		name = "Rocket Tower";
		price = 150;
		description = "A tower that launches Rockets, very slow.";
		this.range = new RangeCircular(currentCell,1);
	}




	@Override
	public Tower getInstance() {
		return new TowerRocket();
	}


	
}
