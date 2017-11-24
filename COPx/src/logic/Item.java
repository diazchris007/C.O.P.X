package logic;

import javafx.scene.image.Image;

public abstract class Item {
	String name;
	int price;
	Image icon;
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public Image getIcon() {
		return icon;
	}
}
