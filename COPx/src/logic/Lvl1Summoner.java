package logic;

import java.util.ArrayList;

public class Lvl1Summoner extends Summoner {

	private static final int NUMMINIONS = 3;
	private static final int NUMWAVES = 4;
	public Lvl1Summoner(Player target) {
		super(target);

		for(int i = 0; i < NUMWAVES; i++) { 
			enemies.put(i,new ArrayList<Enemy>());
			for(int j =0 ; j<NUMMINIONS;j++) {
				enemies.get(i).add(new Lvl1Enemy(new Cell(new Location(0,20)), target));
			}
		}
	}

}
