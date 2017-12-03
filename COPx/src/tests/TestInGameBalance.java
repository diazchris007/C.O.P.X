//tmgerrit@calpoly.edu
package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.GameDisplay;
import logic.Player;
import logic.Profile;
import logic.Tower;


public class TestInGameBalance {
	//This code needed since the player constructor tries to initialize an Image object 
	@BeforeClass
	public static void initJFX() throws InterruptedException {
	    Thread t = new Thread("JavaFX Dummy Thread") {
	        @Override
	    	public void run() {
	        	String[] x = new String[0];
	        	
	            Application.launch(dummyApp.class, x);
	        }
	    };
	    t.setDaemon(true);
	    t.start();
	    Thread.sleep(1000);
	}
		
	@Test
	public void myTestPlayerInGameBalanceDecreaseWhenTowerPlaced(){
		Profile p = new Profile();
		GameDisplay d = null;
		try {
			d = new GameDisplay(p.getLoadout(0));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(d != null){
			Player pl = d.getPlayer();
//			int oldbal = pl.getBalance();
			pl.setBalance(1000);
			Tower towerToPlace = pl.getLoadout().getTower(1).getInstance();
			int towerCost = towerToPlace.getCost();
			
			d.placeTower(1);
			
			assertEquals((long)1000 - towerCost, pl.getBalance());
		}
	}

}
