package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.Inventory;

public class TestUnitInventoryFactory {
	//This code needed since the player constructor tries to initialize an Image object 
	@BeforeClass
	public static void initJFX() throws InterruptedException {
	    Thread t = new Thread("JavaFX Dummy Thread") {
	    		@Override
	        public void run() {
	            Application.launch(DummyApp.class, new String[0]);
	        }
	    };
	    t.setDaemon(true);
	    t.start();
	    Thread.sleep(1000);
	}
	
	@Test
	public void test() {

		// list of items
		List<String> test = new ArrayList<>();
		test.add("Green Potion");
		test.add("Charge Potion");
		test.add("HP Potion");
		test.add("Green Potion");
		test.add("Mana Potion");
		test.add("Sword5");
		test.add("Shield");

		Inventory inventory = null;
		List<String> result;
		
		inventory = new Inventory(test, null, null);
		result = inventory.listItemInventory();
		assertEquals(result, test);
		 	
	}
}
