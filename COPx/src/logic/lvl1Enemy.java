package logic;

import javafx.scene.image.Image;

public class lvl1Enemy extends Enemy{

	public lvl1Enemy(Cell startCell, Entity target) {
		super(startCell, target);
		// TODO Auto-generated constructor stub
		name = "Level 1 Enemy";
		health = 100;
    	currentImage = new Image("file:./../images/Player.png");
    	dir = Direction.EAST;
	}
	

}
