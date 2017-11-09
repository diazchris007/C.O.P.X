package logic;

import javafx.scene.image.Image;

public class Sword1 implements Item{

	private String name;
	private int price;
	private float attackStrength;
	private Image icon;
	
	public Sword1() {
		name = "Sword1";
		price = 20;
		attackStrength = (float)1.5;
		icon = new Image("file:./../images/sword1.png");;
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
