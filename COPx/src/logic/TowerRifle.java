package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class TowerRifle extends Tower{

	public TowerRifle(){
		super(325, 10);
		cost = 10;
		currentImage = new Image("file:./../images/rifleTower.png");
		description = "A tower that contains a guy with a rifle...";
		price = 240;
		name = "Rifle Tower";
		this.range = new RangeCircular(currentCell,1);
		
	}

	@Override
	public Tower getInstance() {
		
		
		return new TowerRifle();
	}


	public List<Entity> attack(){ 
		ArrayList<Entity> entities = (ArrayList<Entity>) getNearby();
		ArrayList<Entity> deadEntities = new ArrayList<Entity>();
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


}
