package logic;


import javafx.scene.image.Image;

public class TowerRocket extends Tower{

	public TowerRocket(){
		super(200, 45);
		cost = 45;
		timeBetweenAttack = 2000;
		currentImage = new Image("file:./../images/rocketTower.png");
		name = "Rocket Tower";
		price = 150;
		description = "A tower that launches Rockets, very slow.";
		this.range = new RangeCircular(currentCell,2);
	}




	@Override
	public Tower getInstance() {
		return new TowerRocket();
	}


	
}
