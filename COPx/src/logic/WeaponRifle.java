package logic;

import javafx.scene.image.Image;

public class WeaponRifle extends Weapon{

	public WeaponRifle() {
		name = "Rifle";
		price = 20;
		attackStrength = (float)1.4;
		icon = new Image("file:./../images/rifle.png");
	}

	@Override
	public void attack() {
		return; 
	}
}
