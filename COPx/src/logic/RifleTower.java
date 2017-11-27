package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import javafx.scene.image.Image;

public class RifleTower extends Tower{

	public RifleTower(){
		super(200,10);
		cost = 10;
		this.range = new RangeCircular(currentCell,1);
		currentImage = new Image("file:./../images/military3_frontFacing.png");
	}

	@Override
	public Tower getInstance() {
		// TODO Auto-generated method stub
		
		return new RifleTower();
	}

	public ArrayList<Entity> getNearby(){
		ArrayList<Cell> nearby =range.getNearby();
		ArrayList<Entity> entities = new ArrayList<Entity>();
		for(Cell c : nearby){
			Entity ent = c.getEntityInCell();
			if(ent.getClass().getSuperclass().equals(Tower.class)){
				entities.add(ent);
			}
			else if(c.getEntityInCell().getClass().equals(Player.class)){
				entities.add(ent);
			}
		}
		return entities;
	}
	public ArrayList<Entity> attack(){
		ArrayList<Entity> entities = getNearby();
		ArrayList<Entity> deadEntities = new ArrayList<Entity>();
		if(entities.size()>0){
			System.out.println("Entity :" + entities.get(0));
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
				System.out.println(ent.getClass() + " is now at " + ent.getHealth());
			}
		}
		return deadEntities;
	}

}

	
	
	

