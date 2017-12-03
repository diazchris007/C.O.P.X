package logic;

import java.util.ArrayList;

public class Lvl1Summoner extends Summoner {

	private static final int NUMMINIONS = 3;
	private static final int NUMWAVES = 4;
	public Lvl1Summoner(Entity target) {
		super(target);

		for(int i = 0; i < NUMWAVES; i++) { 
			enemies.add(new ArrayList<Enemy>());
			for(int j =0 ; j<NUMMINIONS;j++) {
				enemies.get(i).add(new Lvl1Enemy(new Cell(new Location(0,0)), target));
			}
		}
		System.out.println(enemies.size() + " waves");
		System.out.println(enemies.get(0).size() + " minions");
		
	}
	

}
