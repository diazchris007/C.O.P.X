package logic;


import javafx.scene.image.Image;

public class TowerSelfDestruct extends Tower{

	public TowerSelfDestruct(){
		super(200, 50);
		cost = 50;
		currentImage = new Image("file:./../images/selfDestructTower.png");
		name = "Self Destruct Tower";
		price = 290;
		description = "A tower that self destructs when enemies are near.";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		return new TowerSelfDestruct();
	}




}

