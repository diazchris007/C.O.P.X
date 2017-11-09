package logic;

import javafx.scene.image.Image;

public class Sword4 implements Item{

	private String name;
	private int price;
	private float attackStrength;
	private Image icon;
	
	public Sword4() {
		name = "Sword4";
		price = 80;
		attackStrength = (float)3.0;
		icon = new Image("file:./../images/sword4.png");
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