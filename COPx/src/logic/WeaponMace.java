package logic;

import javafx.scene.image.Image;

public class WeaponMace extends Weapon{

	public WeaponMace() {
		name = "Mace";
		price = 40;
		attackStrength = (float)2.0;
		icon = new Image("file:./../images/mace.png");
		description = "A Mace to swing, not the spraying kind.";
	}

	@Override
	public void attack() {
		return; 
	}
}