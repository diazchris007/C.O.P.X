package logic;

import javafx.scene.image.Image;

public class WeaponSword1 extends Weapon{

	public WeaponSword1() {
		name = "Sword1";
		price = 20;
		attackStrength = (float)1.5;
		icon = new Image("file:./../images/sword1.png");
	}

	@Override
	public void attack() {
		return; 
		
	}
	
	
}
