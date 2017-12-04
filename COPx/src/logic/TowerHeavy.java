package logic;


import javafx.scene.image.Image;

public class TowerHeavy extends Tower{

	public TowerHeavy(){
		super(210, 80);
		cost = 40;
		currentImage = new Image("file:./../images/heavyTower.png");
		name = "Heavy Tower";
		price = 210;
		description = "A tower that is really heavy and durable.";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		
		
		return new TowerHeavy();
	}


	
}


