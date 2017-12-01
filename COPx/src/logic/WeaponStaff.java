package logic;

import javafx.scene.image.Image;

public class WeaponStaff extends Weapon{

	public WeaponStaff() {
		name = "Staff";
		price = 20;
		attackStrength = (float)1.4;
		icon = new Image("file:./../images/staff.png");
	}

	@Override
	public void attack() {
		return; 
	}
}
