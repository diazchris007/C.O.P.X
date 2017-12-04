package logic;


import javafx.scene.image.Image;

public class TowerBlast extends Tower{

	public TowerBlast(){
		super(230, 20);
		cost = 20;
		currentImage = new Image("file:./../images/blastTower.png");
		name = "Blast Tower";
		price = 230;
		description = "A tower to blast your enemies away.";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		
		
		return new TowerBlast();
	}



	
}

