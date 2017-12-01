package logic;

public class ItemFactory {
	private ItemFactory()
	{
		
	}

	public static Item getItem(String item) {
		
		if (item == null) {
			return null;
		}
				
		if (item.equalsIgnoreCase("Sword5")) {
			return new ItemSword5();
		} else if (item.equalsIgnoreCase("Shield")) {
			return new ItemShield();
		} else if (item.equalsIgnoreCase("Green Potion")) {
			return new ItemGreenPotion();
		} else if (item.equalsIgnoreCase("Charge Potion")) {
			return new ItemChargePotion();
		} else if (item.equalsIgnoreCase("Hp Potion")) {
			return new ItemHpPotion();
		} else if (item.equalsIgnoreCase("Mana potion")) {
			return new ItemManaPotion();
		}
		
		
		return null;
	}
}
