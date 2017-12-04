package logic;


import javafx.scene.image.Image;

public class TowerRifle extends Tower{

	public TowerRifle(){
		super(325, 10);
		cost = 10;
		currentImage = new Image("file:./../images/rifleTower.png");
		name = "Rifle Tower";
		price = 240;
		description = "A tower with a guy with a rifle in it.";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		return new TowerRifle();
	}




}
