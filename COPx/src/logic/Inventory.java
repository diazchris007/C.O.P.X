package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {

	List <Tower> towers;
	List <Weapon> weapons;
	
	List <Item> items;
	
	public Inventory() {
		List<String> itemList = Arrays.asList("sword1", "sword2", "sword1");
		items = new ArrayList<Item>();
		Item temp;
		for (int i = 0; i < itemList.size(); i++) {
			temp = ItemFactory.getItem( itemList.get(i) );			
			items.add(temp);
		}	
	}
	
	public Inventory(List<String> list) {
		items = new ArrayList<Item>();
		Item temp;
		for (int i = 0; i < list.size(); i++) {
			temp = ItemFactory.getItem( list.get(i) );			
			items.add(temp);
		}
	}
	
	public void addItem(Item itemToAdd) {
		items.add(itemToAdd);
	}
	
	public Item getItem(int i) {
		return items.get(i);
	}
	
	public int getItemNum() {
		return items.size();
	}
	
}
