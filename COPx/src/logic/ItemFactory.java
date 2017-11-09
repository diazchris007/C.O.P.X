package logic;

public class ItemFactory {

	public static Item getItem(String item) {
		
		if (item == null) {
			return null;
		}
				
		if (item.equalsIgnoreCase("Sword1")) {
			return new Sword1();
		} else if (item.equalsIgnoreCase("Sword2")) {
			return new Sword2();
		} else if (item.equalsIgnoreCase("Sword3")) {
			return new Sword3();
		} else if (item.equalsIgnoreCase("Sword4")) {
			return new Sword4();
		} else if (item.equalsIgnoreCase("Sword5")) {
			return new Sword5();
		}
		
		return null;
	}
}
