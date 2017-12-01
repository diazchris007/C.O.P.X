package logic;

import javafx.scene.image.Image;

public class WeaponRocketLauncher extends Weapon {

	
	public WeaponRocketLauncher() {
		name = "Rocket Launcher";
		price = 20;
		attackStrength = (float)1.5;
		icon = new Image("file:./../images/rocketLauncher.png");
		description = "Rocket Launcher: destroys a wide range of targets but is slow...";
	}

	@Override
	public void attack() {
		return;
		
	}
	
	

	

}
