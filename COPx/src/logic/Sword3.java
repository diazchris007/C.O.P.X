package logic;

import javafx.scene.image.Image;

public class Sword3 implements Item{

	private String name;
	private int price;
	private float attackStrength;
	private Image icon;
	
	public Sword3() {
		name = "Sword3";
		price = 50;
		attackStrength = (float)3.0;
		icon = new Image("file:./../images/sword3.png");
	}
	
	@Override
	public int getPrice() {
		return price;
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
