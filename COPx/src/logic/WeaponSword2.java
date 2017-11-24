package logic;

import javafx.scene.image.Image;

public class WeaponSword2 extends Weapon{

	public WeaponSword2() {
		name = "Sword2";
		price = 30;
		attackStrength = (float)1.8;
		icon = new Image("file:./../images/sword2.png");
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
	}
}

