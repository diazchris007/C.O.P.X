package logic;

public class TowerFactory {
	private TowerFactory()
	{
		
	}
	
	public static Tower getTower(String tower) {
		
		if (tower == null) {
			return null; 
		}
				
		if (tower.equalsIgnoreCase("Rifle Tower")) {
			return new TowerRifle();
		} else if (tower.equalsIgnoreCase("Rocket Tower")) {
			return new TowerRocket();
		} else if (tower.equalsIgnoreCase("Blast Tower")) {
			return new TowerBlast();
		} else if (tower.equalsIgnoreCase("Self Destruct Tower")) {
			return new TowerSelfDestruct();
		} else if (tower.equalsIgnoreCase("Heavy Tower")) {
			return new TowerHeavy();
		} else if (tower.equalsIgnoreCase("Swat Tower")) {
				return new TowerSwat();
		} 
		
		return null;
	}

}
