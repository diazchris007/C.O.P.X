package logic;

import javafx.scene.image.Image;

public class WeaponStaff extends Weapon{

	public WeaponStaff() {
		name = "Staff";
		price = 20;
		attackStrength = (float)1.4;
		icon = new Image("file:./../images/staff.png");
		description = "A stick that may or may not have magical powers. (Probably not though..)";
	}

	@Override
	public void attack() {
		return; 
	}
}
