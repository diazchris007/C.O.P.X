package logic;

public class WeaponFactory {
	private WeaponFactory()
	{
		
	}

	
	public static Weapon getWeapon(String weapon) {
		
		if (weapon == null) {
			return null;
		}
				
		if (weapon.equalsIgnoreCase("Rocket Launcher")) {
			return new WeaponRocketLauncher();
		} else if (weapon.equalsIgnoreCase("sword1")) {
			return new WeaponSword1();
		} else if (weapon.equalsIgnoreCase("sword2")) {
			return new WeaponSword2();
		} else if (weapon.equalsIgnoreCase("mace")) {
			return new WeaponMace();
		} else if (weapon.equalsIgnoreCase("staff")) {
			return new WeaponStaff();
		} else if (weapon.equalsIgnoreCase("rifle")) {
			return new WeaponRifle();
		}
		
		return null;
	}
}
