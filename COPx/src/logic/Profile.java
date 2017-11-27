package logic;

import java.util.Arrays;
import java.util.List;

public class Profile {
	Loadout[] loadouts;
	private int outsideGameBalance;
	Inventory inv;
	private final int numLoadouts = 3;
	
	
	public Profile() {
		loadouts = new Loadout[numLoadouts];
		
		List<String> towerNames = Arrays.asList("Rifle Tower", "Rocket Tower", "Swat Tower", "Heavy Tower");
		for(int i = 0; i < numLoadouts; i++){
			loadouts[i] = new Loadout();
			loadouts[i].setTower(0, TowerFactory.getTower(towerNames.get(0)));
			loadouts[i].setTower(1, TowerFactory.getTower(towerNames.get(1)));
			loadouts[i].setTower(2, TowerFactory.getTower(towerNames.get(2)));
			loadouts[i].setTower(3, TowerFactory.getTower(towerNames.get(3)));
		}
		outsideGameBalance = 800;
 		inv = new Inventory();
	}
	
	public Profile(List<String> initialItems, List<String> initialWeapons, List<String> initialTowers) {
		loadouts = new Loadout[numLoadouts];
		for(int i = 0; i < numLoadouts; i++){
			loadouts[i] = new Loadout();
			loadouts[i].setTower(0, new TowerRifle());
			loadouts[i].setTower(1, new TowerRifle());
			loadouts[i].setTower(2, new TowerRifle());
			loadouts[i].setTower(3, new TowerRifle());
		}
		outsideGameBalance = 200;
		
		inv = new Inventory(initialItems, initialWeapons, initialTowers);
	}


	public int getBalance() {
		return outsideGameBalance;
	}
	
	public Loadout getLoadout(int slot) {
		// TODO Auto-generated method stub
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
			System.out.println("You cannot purchase " + item + "! :(");
			return 1;
		}
	}
	
	public int purchaseItem1(Item item ) {
		if (item.getPrice() <= outsideGameBalance) {
			Item temp = ItemFactory.getItem( item.getName() ); // duplicate
			outsideGameBalance = outsideGameBalance - item.getPrice();
			inv.addItem(temp);
			return 0;
		}
		else
		{
			System.out.println("You cannot purchase " + item.getName() + "! :(");
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
			System.out.println("You cannot purchase " + weapon.getName() + "! :(");
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
			System.out.println("You cannot purchase " + tower.getName() + "! :(");
			return 1;
		}
	}
	
	public Inventory getInventory() {
		return inv;
	}
}
