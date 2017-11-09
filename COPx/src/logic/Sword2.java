package logic;

import javafx.scene.image.Image;

public class Sword2 implements Item{

	private String name;
	private int price;
	private float attackStrength;
	private Image icon;
	
	public Sword2() {
		name = "Sword2";
		price = 40;
		attackStrength = (float)3.0;
		icon = new Image("file:./../images/sword2.png");
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
