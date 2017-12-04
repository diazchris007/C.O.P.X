package logic;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.scene.image.Image;

public class TowerSelfDestruct extends Tower{

	public TowerSelfDestruct(){
		super(300, 50);
		cost = 80;
		timeBetweenAttack = 6000;
		currentImage = new Image("file:./../images/selfDestructTower.png");
		name = "Self Destruct Tower";
		price = 290;
		description = "A tower that self destructs when enemies are near.";
		this.range = new RangeCircular(currentCell,1);
	}

	@Override
	public Tower getInstance() {
		return new TowerSelfDestruct();
	}
	public ArrayList<Enemy> attack(){
		long newTime = new Date().getTime();
		long temp = newTime - lastAttacked;
		System.out.println(temp);
		if(temp < timeBetweenAttack){
			return  new ArrayList<>();
		}
		lastAttacked = newTime;
		ArrayList<Entity> entities = (ArrayList<Entity>) getNearby();
		ArrayList<Enemy> deadEntities = new ArrayList<>();
		if(!entities.isEmpty()){
			
			
			for(Entity e : entities){
				if(e.getClass() != Player.class){
					if((e.getHealth() <= attackDamage)){
						deadEntities.add((Enemy)e);
						
					}
					else{
						e.setHealth(e.getHealth() - attackDamage);
					}
				}
			}
		}
		return deadEntities;
	}



}

