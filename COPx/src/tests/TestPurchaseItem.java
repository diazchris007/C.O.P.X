package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.ItemFactory;
import logic.Profile;

public class TestPurchaseItem {
	
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
		
		List<String> real = new ArrayList<String>();
		real.add("Shield");
		real.add("Green Potion");
		
		List<String> initialItems =new ArrayList<String>();
		Profile user = new Profile(initialItems, null, null);
	
		for (int i = 0; i < real.size(); i++) {
			user.purchaseItem(ItemFactory.getItem(real.get(i)));
		}

		
		List<String> result = user.getInventory().listItemInventory();
		
		assertEquals(result, real);
	}
	
}
