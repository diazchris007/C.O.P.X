package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.Cell;
import logic.Loadout;
import logic.Location;
import logic.Player;

public class TestUnitPlayerSetBalance {

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
		Loadout ld = null ;
		Player player = new Player(new Cell(new Location(x, y)), ld);
		
		int expectBalance = 200;
		player.setBalanceNoNotify(expectBalance);
		
		int result = player.getBalance();
		
		assertEquals(expectBalance, result);
		
	}

}
