package logic;

public class Profile {
	Loadout[] loadouts;
	int outsideGameBalance;
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
	}
	
	public Loadout getLoadout(int slot) {
		// TODO Auto-generated method stub
		return loadouts[slot];
	}
}
