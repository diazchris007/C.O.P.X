package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.Cell;
import logic.Location;
import logic.Player;

public class TestUnitPlayerSetCurrentCell {

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
		
		int x = 0;
		int y = 5;
		Player player = new Player(new Cell(new Location(x, y)), null);
		
		int newX = 20;
		int newY = 10;
		Location expectLocation = new Location(newX, newY);
		player.setCurrentCell(new Cell(expectLocation));
		
		Location result = player.getCurrentCell().getLocation();
		
		assertEquals(expectLocation, result);
	}

}
