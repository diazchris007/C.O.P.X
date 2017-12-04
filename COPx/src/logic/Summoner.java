package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

public abstract class Summoner {
	List<Tower> towers;
	HashMap<Integer, List<Enemy>> enemies;
	Entity target;
	Board board;
	Boolean paused;
	int wave;
	public Summoner(Entity target) {
		enemies = new HashMap<>();
		towers = new ArrayList<>();
		this.target = target;
		this.board = Board.getInstance();
		paused = true; 
		wave = 0;
	}
	public void addTower(Tower tower){
		towers.add(tower);
	}
	public void start() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(new SummonerRunner());
			}
			
		};
		timer.scheduleAtFixedRate(task, 0,100);
	}
	public void attackAll(){
		if(!enemies.get(wave).isEmpty()) {
			for(Enemy e : enemies.get(wave)){
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
				ArrayList<Enemy> dead = t.attack();
				for(Enemy ent : dead){
						ent.payOut();
						enemies.get(wave).remove(ent);
						ent.getCurrentCell().clearEntityInCell();
				}
			}
			
		}
		else if(enemies.size()> wave+1) {
			System.out.println("New Wave coming game paused");
			paused = true;
			wave++;
		}
		else {
			paused = true;
			return;
		}

	}
	public void moveAll() {
		if(!enemies.get(wave).isEmpty()) {

			System.out.println("wave #:" + wave);
			System.out.println("minions #:" + enemies.get(wave).size());
			for(Enemy e : enemies.get(wave)) {
				e.moveToTarget();
			}
			
		}
		else if(enemies.size()> wave+1) {
			paused = true;
			wave++;
		}
		else {
			paused = true;
			return;
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

	public class SummonerRunner implements Runnable{
		@Override
		public void run() {
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
			
	}
		
	
}

