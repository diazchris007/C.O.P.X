package tests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import javafx.application.Application;
import logic.Cell;
import logic.Direction;
import logic.Location;
import logic.Player;

//tmgerrit@calpoly.edu
public class TestPlayerTurnCCW {
	//This code needed since the player constructor tries to initialize an Image object 
	@BeforeClass
	public static void initJFX() throws InterruptedException {
	    Thread t = new Thread("JavaFX Dummy Thread") {
	    		@Override
	        public void run() {
	            Application.launch(dummyApp.class, new String[0]);
	        }
	    };
	    t.setDaemon(true);
	    t.start();
	    Thread.sleep(1000);
	}
	
	@Test
	public void myTestTurnCCW() {
		Player p = new Player(new Cell(new Location(0,0)), null);
		p.turnCCW();
		assertEquals(Direction.NORTHEAST, p.getDirection());
	}

	
}
