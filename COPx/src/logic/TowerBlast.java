package logic;


import javafx.scene.image.Image;

public class TowerBlast extends Tower{

	public TowerBlast(){
		super(150, 20);
		cost = 40;
		timeBetweenAttack = 1000;
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

