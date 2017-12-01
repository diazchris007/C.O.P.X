package logic;

import javafx.scene.image.Image;

public abstract class Weapon {
	int strength;
	Image currentImage;
	
	String name;
	int price;
	float attackStrength;
	Image icon;
	String description;
	
	public abstract void attack();
	public Image getImg() {
		 
		return currentImage;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public float getAttackStrength() {
		return attackStrength;
	}
	
	public Image getIcon() {
		return icon;
	}
}
