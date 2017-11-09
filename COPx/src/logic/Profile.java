package logic;

public class Profile {
	Loadout[] loadouts;
	private int outsideGameBalance;
	Inventory inv;
	private final int numLoadouts = 3;
	
	
	public Profile() {
		loadouts = new Loadout[numLoadouts];
		for(int i = 0; i < numLoadouts; i++){
			loadouts[i] = new Loadout();
			loadouts[i].setTower(0, new RifleTower());
			loadouts[i].setTower(1, new RifleTower());
			loadouts[i].setTower(2, new RifleTower());
			loadouts[i].setTower(3, new RifleTower());
		}
		outsideGameBalance = 200;
		
		inv = new Inventory();
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
}
