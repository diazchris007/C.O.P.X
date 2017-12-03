package logic;



import javafx.scene.image.Image;

public class Lvl1Enemy extends Enemy{

	public Lvl1Enemy(Cell startCell, Entity target) {
		super(600,10,50 ,startCell, target);
		timeBetweenAttack = 500;
		name = "Level 1 Enemy";
    	currentImage = new Image("file:./../images/Player.png");
    	dir = Direction.EAST;
		this.range = new RangeCircular(startCell,1);
	}

	

}
