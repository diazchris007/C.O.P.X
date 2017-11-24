package logic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class Inventory {

	List <Tower> towers;
	List <Weapon> weapons;
	List <Item> items;
	
//	public Inventory() {
//		List<String> listItems = Arrays.asList( "mana potion", "shield", "hp potion");
//		items = new ArrayList<Item>();
//		Item tempitem;
//		for (int i = 0; i < listItems.size(); i++) {
//			tempitem = ItemFactory.getItem( listItems.get(i) );			
//			items.add(tempitem);
//		}
//		
//		List<String> listWeapons = Arrays.asList("rocket Launcher", "mace", "Rifle");
//		weapons = new ArrayList<Weapon>();
//		Weapon tempWeapon;
//		for (int i = 0; i < listWeapons.size(); i++) {
//			tempWeapon = WeaponFactory.getWeapon( listWeapons.get(i) );
//			weapons.add(tempWeapon);
//		}
//		
//		List<String> listTowers = Arrays.asList("Rifle Tower", "Rocket Tower", "Heavy tower");
//		towers = new ArrayList<Tower>();
//		Tower tempTower;
//		for (int i = 0; i < listTowers.size(); i++) {
//			tempTower = TowerFactory.getTower( listTowers.get(i) );			
//			towers.add(tempTower);
//		}
//	}
	
	
	// empty default inventory
	public Inventory() {
		items = new ArrayList<Item>();
		weapons = new ArrayList<Weapon>();
		towers = new ArrayList<Tower>();
	}
	
	public Inventory(List<String> listItems, List<String> listWeapons, List<String> listTowers) {
		
		items = new ArrayList<Item>();
		Item tempitem;
		if (listItems != null) {
			for (int i = 0; i < listItems.size(); i++) {
				tempitem = ItemFactory.getItem( listItems.get(i) );			
				items.add(tempitem);
			}
		}
		
		weapons = new ArrayList<Weapon>();
		Weapon tempWeapon;
		if (listWeapons != null) {
			for (int i = 0; i < listWeapons.size(); i++) {
				tempWeapon = WeaponFactory.getWeapon( listWeapons.get(i) );			
				weapons.add(tempWeapon);
			}
		}
		
		towers = new ArrayList<Tower>();
		Tower tempTower;
		if (listTowers != null) {
			for (int i = 0; i < listTowers.size(); i++) {
				tempTower = TowerFactory.getTower( listTowers.get(i) );			
				towers.add(tempTower);
			}
		}
	}
	
	public void addItem(Item itemToAdd) {
		items.add(itemToAdd);
	}
	
	public void addWeapon(Weapon weaponToAdd) {
		weapons.add(weaponToAdd);
	}
	
	public void addTower(Tower towerToAdd) {
		towers.add(towerToAdd);
	}
	
	// int: 0 item, 1 Weapon, 2 Tower, -1 for unknown
	public int getIWT(int i) {
		if (i >= 0 && i < items.size()) {
			return 0;
		} else if (i >= items.size() && i < (items.size() + weapons.size())) {
			return 1;
		} else if (i >= (items.size() + weapons.size()) && i <(items.size() + weapons.size() + towers.size())) {
			return 2;
		} else {
			return -1;
		}
	};
	
	public Item getItem(int i) {
		return items.get(i);
	}
	
	public Weapon getWeapon(int i) {
		return weapons.get(i);
	}
	
	public Tower getTower(int i) {
		return towers.get(i);
	}
	
	public int getItemNum() {
		return items.size();
	}
	
	public int getWeaponNum() {
		return weapons.size();
	}
	
	public int getTowerNum() {
		return towers.size();
	}
	
	public int getInventoryNum() {
		return (towers.size() + weapons.size() + items.size());
	}
	
	public List<String> listItemInventory() {
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < items.size(); i++) {
			temp.add(items.get(i).getName());
		}
		
		return temp;
	}
	
}
