package tests;
 
 import static org.junit.Assert.*;
 import org.junit.BeforeClass;
 import org.junit.Test;
 import javafx.application.Application;
 import logic.Cell;
 import logic.Direction;
 import logic.Location;
 import logic.Player;
 

 public class TurnCWTest {
 	@BeforeClass
 	public static void initJFX() throws InterruptedException {
 	    Thread t = new Thread("JavaFX Dummy Thread") {
 	        public void run() {
 	            Application.launch(DummyApp.class, new String[0]);
 	        }
 	    };
 	    t.setDaemon(true);
 	    t.start();
 	    Thread.sleep(1000);
 	}
 	
 	@Test
 	public void TestTurnCW() {
 		Player p = new Player(new Cell(new Location(0,0)), null);
 		p.turnCW();
 		assertEquals(Direction.SOUTH, p.getDirection());
 	}
 
 	
 }