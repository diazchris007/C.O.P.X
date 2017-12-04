package logic;

import java.util.Arrays;
import java.util.List;

public class Profile {
	Loadout[] loadouts;
	private int outsideGameBalance;
	Inventory inv;
	private static final int NUMLOADOUTS = 3;
	
	
	public Profile() {
		loadouts = new Loadout[NUMLOADOUTS];
		
		List<String> towerNames = Arrays.asList("Rifle Tower", "Rocket Tower", "Swat Tower", "Heavy Tower");
		for(int i = 0; i < NUMLOADOUTS; i++){
			loadouts[i] = new Loadout();
			loadouts[i].setTower(0, TowerFactory.getTower(towerNames.get(0)));
			loadouts[i].setTower(1, TowerFactory.getTower(towerNames.get(1)));
			loadouts[i].setTower(2, TowerFactory.getTower(towerNames.get(2)));
			loadouts[i].setTower(3, TowerFactory.getTower(towerNames.get(3)));
		}
		outsideGameBalance = 800;
 		inv = new Inventory();
	}
	
	// need to add a parameter for current balance
	public Profile(List<String> initialItems, List<String> initialWeapons, List<String> initialTowers) {
		loadouts = new Loadout[NUMLOADOUTS];
		for(int i = 0; i < NUMLOADOUTS; i++){
			loadouts[i] = new Loadout();
			loadouts[i].setTower(0, new TowerRifle());
			loadouts[i].setTower(1, new TowerRifle());
			loadouts[i].setTower(2, new TowerRifle());
			loadouts[i].setTower(3, new TowerRifle());
		}
		outsideGameBalance = 10000;
		
		inv = new Inventory(initialItems, initialWeapons, initialTowers);
	}


	public int getBalance() { 
		return outsideGameBalance;
	}
	
	public Loadout getLoadout(int slot) {
		
		return loadouts[slot];
	}

	
	public int purchaseItem (String item) {
		Item i = ItemFactory.getItem( item );
		if (i.getPrice() <= outsideGameBalance) {
			outsideGameBalance = outsideGameBalance - i.getPrice();
			inv.addItem(i);
			return 0;
		}
		else
		{
			
			return 1;
		}
	}
	public boolean itemInInv(final String name){
	    List<String> list = inv.listItemInventory();
	    for (int i = 0; i < list.size(); i++) {
	    		if (list.get(i).equalsIgnoreCase(name))
	    			return true;
	    }
	    return false;
	}
	
	public boolean weaponInInv(final String name){
	    
	    List<String> list = inv.listWeaponInventory();
	    for (int i = 0; i < list.size(); i++) {
	    		if (list.get(i).equalsIgnoreCase(name))
	    			return true;
	    }
	    return false;
	    
	}
	
	public boolean towerInInv(final String name){
	    List<String> list = inv.listTowerInventory();
	    for (int i = 0; i < list.size(); i++) {
	    		if (list.get(i).equalsIgnoreCase(name))
	    			return true;
	    }
	    return false;
	}
	
	
	
	public int purchaseItem(Item item ) {
		if (item.getPrice() <= outsideGameBalance) {
			Item temp = ItemFactory.getItem( item.getName() ); // duplicate
			outsideGameBalance = outsideGameBalance - item.getPrice();
			inv.addItem(temp);
			return 0;
		}
		else
		{
			
			return 1;
		}
	}
	
	public int purchaseWeapon(Weapon weapon ) {
		if (weapon.getPrice() <= outsideGameBalance) {
			Weapon temp = WeaponFactory.getWeapon( weapon.getName() ); // duplicate
			outsideGameBalance = outsideGameBalance - temp.getPrice();
			inv.addWeapon(temp);
			return 0;
		}
		else
		{
			
			return 1;
		}
	}
	
	public int purchaseTower(Tower tower ) {
		if (tower.getPrice() <= outsideGameBalance) {
			Tower temp = TowerFactory.getTower( tower.getName() ); // duplicate
			outsideGameBalance = outsideGameBalance - temp.getPrice();
			inv.addTower(temp);
			return 0;
		}
		else
		{
			
			return 1;
		}
	}
	
	public Inventory getInventory() {
		return inv;
	}
}
