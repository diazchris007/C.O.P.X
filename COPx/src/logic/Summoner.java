package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

public abstract class Summoner {
	
	List<Enemy> enemies;
	List<Tower> towers;
	Entity target;
	Board board;
	public Summoner(Entity target, Board board) {
		enemies = new ArrayList<Enemy>();
		towers = new ArrayList<Tower>();
		this.target = target;
		this.board = board;
	}
	public void addTower(Tower tower){
		towers.add(tower);
	}
	public void start() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						attackAll();
						moveAll();
						board.draw();
					}
				});
			}
			
		};
		timer.scheduleAtFixedRate(task, 0,1000);
	}
	public void attackAll(){
		for(Enemy e : enemies){
			ArrayList<Entity> dead = e.attack();
			if(dead.size()>0){
				for(Entity ent : dead){
					if(ent.getClass().equals(Player.class)){
						System.out.println("over");
					}
					else{
						towers.remove(ent);
						
					}
					ent.getCurrentCell().clearEntityInCell();
				}
			}
		}
	}
	public void moveAll() {
		for(Enemy e : enemies) {
			board.setCells(e.moveToTarget(board));
		}
	}
}
