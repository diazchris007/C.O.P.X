package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.Profile;
import logic.WeaponFactory;

public class TestIntegrationPurchaseWeapon {

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
			real.add("Rifle");
			real.add("Mace");
			real.add("Rocket Launcher");
			real.add("Staff");
			real.add("Sword1");
			real.add("Sword2");
			
			List<String> initialWeapons =new ArrayList<>();
			Profile user = new Profile(null, initialWeapons, null);
		
			for (int i = 0; i < real.size(); i++) {
				user.purchaseWeapon(WeaponFactory.getWeapon(real.get(i)));
			}

			List<String> result = user.getInventory().listWeaponInventory();
			
			assertEquals(real, result);
		}
}
