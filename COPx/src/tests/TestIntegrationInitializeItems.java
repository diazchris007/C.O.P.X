package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.Profile;

public class TestIntegrationInitializeItems {
	
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
		
		List<String> real = new ArrayList<>();
		real.add("Shield");
		real.add("Green Potion");
		real.add("Sword5");
		real.add("Charge Potion");
		real.add("HP Potion");
		real.add("Mana Potion");
		
		Profile user = new Profile(real, null, null);

		List<String> result = user.getInventory().listItemInventory();
		
		assertEquals(result, real);
	}
	
}
