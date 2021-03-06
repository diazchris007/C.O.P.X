package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.Profile;

public class TestIntegrationInitializeTowers {
	
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
		
		List<String> tower = new ArrayList<>();
		tower.add("Heavy Tower");
		tower.add("Rocket Tower");
		tower.add("Self Destruct Tower");
		tower.add("Heavy Tower");
		tower.add("Swat Tower");
		tower.add("Blast Tower");
		
		Profile user = new Profile(null, null, tower);

		List<String> result = user.getInventory().listTowerInventory();
		
		assertEquals(result, tower);
	}
	
}
