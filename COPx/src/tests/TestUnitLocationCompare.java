package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.Location;

public class TestUnitLocationCompare {

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
		int y = 0;
		Location loc = new Location(x, y);
		
		int expectX = 2;
		loc.setX(expectX);
		
		int resultX = loc.getX();
		
		assertEquals(expectX, resultX);
		
	}

}
