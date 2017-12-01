package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class TowerRocket extends Tower{

	public TowerRocket(){
		super(200, 30);
		cost = 30;
		currentImage = new Image("file:./../images/rocketTower.png");
		description = "RocketTower";
		price = 150;
		name = "Rocket Tower";
		this.range = new RangeCircular(currentCell,1);
	}


	public List<Entity> attack(){ 
		ArrayList<Entity> entities = (ArrayList<Entity>) getNearby();
		ArrayList<Entity> deadEntities = new ArrayList<>();
		if(!entities.isEmpty()){
			PriorityQueue<Entity> queue = new PriorityQueue<>(entities.size(), new Comparator<Entity>(){
	
				@Override
				public int compare(Entity arg0, Entity arg1) {
					if(arg0.getHeathPercent() > arg1.getHeathPercent())
						return 1;
					if(arg0.getHeathPercent() < arg1.getHeathPercent())
						return -1;
					return 0;
					
				}
				
			});
			
			for(Entity e : entities){
				if(e.getClass() != Player.class)
					queue.add(e);
			}
			if(queue.peek().getHealth() <= attackDamage){
				Entity ent = queue.poll();
				deadEntities.add(ent);
			}
			else{
				Entity ent = queue.poll();
				ent.setHealth(ent.getHealth() - attackDamage);
				
			}
		}
		return deadEntities;
	}

	@Override
	public Tower getInstance() {
		return new TowerRocket();
	}


	
}
