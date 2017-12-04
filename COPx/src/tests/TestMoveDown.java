package tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.Board;
import logic.Location;
import logic.Cell;
import logic.Player;

public class TestMoveDown {
	
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
	public void MyTestMoveDown() {
		Cell[][] cells = new Cell[39][28];
		for (int i = 0; i < cells.length; i++) {
            for(int j = 0 ; j < cells[i].length; j++)
            	cells[i][j] = new Cell(new Location(i,j));
        }
		
		Board board = Board.getInstance();
		board.setCells(cells);
		Player p = new Player(new Cell(new Location(0,0)), null);
		p.moveDown();
		
		assertEquals(new Location(0,1).getY(), p.getCurrentCell().getLocation().getY());
	}
	

}
