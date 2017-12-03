package logic;

import javafx.scene.image.Image;

public class ItemHpPotion extends Item{
	public ItemHpPotion() {
		name = "HP Potion";
		price = 20;
		icon = new Image("file:./../images/hpPotion.png");
		description = "A potion that will charge your HP.";
		
	}
}
