package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class Lvl2Enemy  extends Enemy{

	public Lvl2Enemy(Cell startCell, Player target) {
		super(1000,10 ,60,startCell, target);
		timeBetweenAttack = 500;
		name = "Level 2 Enemy";
    	currentImage = new Image("file:./../images/Player.png");
    	dir = Direction.EAST;
		this.range = new RangeCircular(startCell,1);
	}
	public List<Entity> attack(){
		long newTime = new Date().getTime();
		long temp = newTime - lastAttacked;
		System.out.println(temp);
		if(temp < timeBetweenAttack){
			return  new ArrayList<>();
		}
		lastAttacked = newTime;
		ArrayList<Entity> entities = (ArrayList<Entity>) getNearby();
		ArrayList<Entity> deadEntities = new ArrayList<>();
		if(!entities.isEmpty()){
			
			
			for(Entity e : entities){
				if((e.getHealth() <= attackDamage)){
					deadEntities.add(e);
					
				}
				else{
					e.setHealth(e.getHealth() - attackDamage);
				}
			}
		}
		return deadEntities;
	}


}
