package logic;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class lvl1Enemy extends Enemy{

	public lvl1Enemy(Cell startCell, Entity target) {
		super(600,10 ,startCell, target);
		// TODO Auto-generated constructor stub
		name = "Level 1 Enemy";
    	currentImage = new Image("file:./../images/Player.png");
    	dir = Direction.EAST;
		this.range = new RangeCircular(startCell,1);
	}

	

}
