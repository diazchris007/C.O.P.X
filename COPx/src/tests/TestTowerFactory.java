package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;

import logic.TowerBlast;
import logic.TowerFactory;
import logic.TowerHeavy;
import logic.TowerRifle;
import logic.TowerRocket;
import logic.TowerSelfDestruct;
import logic.TowerSwat;


public class TestTowerFactory {

	//This code needed since the constructor tries to initialize an Image object 
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
public void testGet() {
	
	
	assertTrue(TowerFactory.getTower("Rifle Tower") instanceof TowerRifle);
}
@Test
public void testGetItemSword1() {
	assertTrue(TowerFactory.getTower("Rocket Tower") instanceof TowerRocket);		}
@Test
public void testGetItemSword2() {
	assertTrue(TowerFactory.getTower("Blast Tower") instanceof TowerBlast);		}
@Test
public void testGetItemMace() {
	assertTrue(TowerFactory.getTower("Self Destruct Tower") instanceof TowerSelfDestruct);		}
@Test
public void testGetItemStaff() {
	assertTrue(TowerFactory.getTower("Heavy Tower") instanceof TowerHeavy);		}
@Test
public void testGetWeeponRifle() {
	assertTrue(TowerFactory.getTower("Swat Tower") instanceof TowerSwat);		}

}
