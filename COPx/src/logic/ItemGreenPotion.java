package logic;

import javafx.scene.image.Image;

public class ItemGreenPotion extends Item{
	public ItemGreenPotion() {
		name = "Green Potion";
		price = 10;
		icon = new Image("file:./../images/greenPotion.png");
		description = "A green potion. Dont ask how its made.";
	}
}