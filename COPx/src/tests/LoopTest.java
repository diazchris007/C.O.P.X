package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.Board;
import logic.Cell;
import logic.GameDisplay;
import logic.Profile;

public class LoopTest {
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
	public void testCreateUpperCorner() {
		Profile p = new Profile();
		GameDisplay d = new GameDisplay(p.getLoadout(0), null);
		Cell[][] c = Board.getInstance().getCells();
		assertTrue(c[0][0] instanceof Cell);
	}
	@Test
	public void testCreateFarCorner() {
		Profile p = new Profile();
		GameDisplay d = new GameDisplay(p.getLoadout(0), null);
		Cell[][] c = Board.getInstance().getCells();
		assertTrue(c[c.length -1][c[0].length -1] instanceof Cell);
	}

}
