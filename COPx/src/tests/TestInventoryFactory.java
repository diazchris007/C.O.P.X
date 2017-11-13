package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
//import logic.GameDisplay;
import logic.Inventory;

public class TestInventoryFactory {
	//This code needed since the player constructor tries to initialize an Image object 
	@BeforeClass
	public static void initJFX() throws InterruptedException {
	    Thread t = new Thread("JavaFX Dummy Thread") {
	        public void run() {
	            Application.launch(dummyApp.class, new String[0]);
	        }
	    };
	    t.setDaemon(true);
	    t.start();
	    Thread.sleep(1000);
	}
	
	@Test
	public void test() {

		// list of items
		List<String> test = new ArrayList<String>();
		test.add("Sword1");
		test.add("Sword2");
		test.add("Sword4");
		test.add("Sword5");
		test.add("Sword1");
		test.add("Sword2");
		test.add("Sword4");
		test.add("Sword5");
		
		Inventory inventory = null;
		try {
			inventory = new Inventory(test);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		List<String> result = inventory.listItemInventory();
		
		assertEquals(result, test);
		
	}

}
