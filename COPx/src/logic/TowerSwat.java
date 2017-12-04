package logic;


import javafx.scene.image.Image;

public class TowerSwat extends Tower{

	public TowerSwat(){
		super(500, 100);
		cost = 50;
		currentImage = new Image("file:./../images/swatTower.png");
		name = "Swat Tower";
		price = 230;
		description = "A tower with the durability of a S.W.A.T. team.";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		
		
		return new TowerSwat();
	}




}



