package logic;

import javafx.scene.image.Image;

public abstract class Weapon {
	int strength;
	Image currentImage;
	
	public abstract void attack();
	public Image getImg() {
		// TODO Auto-generated method stub
		return currentImage;
	}
}
