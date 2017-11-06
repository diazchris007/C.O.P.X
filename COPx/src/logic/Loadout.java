package logic;

public class Loadout {
	Tower[] towers;
	Weapon weapon;
	Loadout(){
		towers = new Tower[4];
		
	}
	public void setTower(int slot,Tower tower){
		towers[slot] = tower;
	}
	public void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	public Tower getTower(int slot) {
		// TODO Auto-generated method stub
		return towers[slot];
	}

	
}
