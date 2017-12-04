package logic;

import java.util.ArrayList;
import java.util.List;

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
		
		
		return new RifleTower();
	}
	@Override
	public List<Entity> getNearby(){
		ArrayList<Cell> nearby =(ArrayList<Cell>) range.getNearby();
		ArrayList<Entity> entities = new ArrayList<>();
		for(Cell c : nearby){
			Entity ent = c.getEntityInCell();
			if(ent.getClass().getSuperclass().equals(Tower.class) ||
					c.getEntityInCell().getClass().equals(Player.class)){
				entities.add(ent);
			}
			
		}
		return entities;
	}
}

	
	
	

