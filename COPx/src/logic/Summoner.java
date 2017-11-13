package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

public abstract class Summoner {
	
	List<Enemy> enemies;
	Entity target;
	Board board;
	public Summoner(Entity target, Board board) {
		enemies = new ArrayList<Enemy>();
		this.target = target;
		this.board = board;
	}
	public void start() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						
						moveAll();
						board.draw();
					}
				});
			}
			
		};
		timer.scheduleAtFixedRate(task, 0,1000);
	}
	
	public void moveAll() {
		for(Enemy e : enemies) {
			board.setCells(e.moveToTarget(board));
		}
	}
}
