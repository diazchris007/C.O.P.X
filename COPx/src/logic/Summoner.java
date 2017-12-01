package logic;

import java.util.ArrayList;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

public abstract class Summoner {
	
	List<Enemy> enemies;
	List<Tower> towers;
	Entity target;
	Board board;
	Boolean paused;
	public Summoner(Entity target, Board board) {
		enemies = new ArrayList<>();
		towers = new ArrayList<>();
		this.target = target;
		this.board = board;
		paused = true; 
		
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
						if(enemies.isEmpty()){
							return;
						}
						if(paused)
						{
							return;
						}
						else
						{
							attackAll();
							moveAll();
							board.draw();
						}
					}
				});
			}
			
		};
		timer.scheduleAtFixedRate(task, 0,500);
	}
	public void attackAll(){
		for(Enemy e : enemies){
			ArrayList<Entity> dead = (ArrayList<Entity>) e.attack();
			for(Entity ent : dead){
					if(ent.getClass().equals(Player.class)){
						paused = true;
					}
					else{
						towers.remove(ent);
						
					}
					ent.getCurrentCell().clearEntityInCell();
			}
		}
		for(Tower t : towers){
			ArrayList<Entity> dead = (ArrayList<Entity>) t.attack();
			for(Entity ent : dead){
					enemies.remove(ent);
					ent.getCurrentCell().clearEntityInCell();
			}
		}
	}
	public void moveAll() {
		for(Enemy e : enemies) {
			board.setCells(e.moveToTarget(board));
		}
	}
	public void pause()
	{
		paused = true;
	}
	public void unPause()
	{
		paused = false;
	}
}
