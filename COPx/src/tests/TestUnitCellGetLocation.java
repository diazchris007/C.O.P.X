
package tests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import javafx.application.Application;
import logic.Cell;
import logic.Location;



public class TestUnitCellGetLocation {

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
	public void TestIfCellSet() {
		
    Cell c = new Cell(new Location(0,0));
    c.setLocation(new Location(0,0));
	
	assertEquals(c.getLocation(), c.getLocation());
		
	
	}

	
}