package logic;

import java.util.ArrayList;

public class Lvl1Summoner extends Summoner {

	private static final int NUMMINIONS = 3;
	private static final int NUMWAVES = 4;
	public Lvl1Summoner(Player target) {
		super(target);

		for(int i = 0; i < (NUMWAVES - 2); i++) { 
			enemies.put(i,new ArrayList<Enemy>());
			for(int j =0 ; j<(NUMMINIONS*(i + 1));j++) {
				enemies.get(i).add(new Lvl1Enemy(new Cell(new Location(0,0)), target));
			}
		}
		for(int i = 2; i < NUMWAVES; i++){
			enemies.put(i,new ArrayList<Enemy>());
			for(int j =0 ; j<(NUMMINIONS*(i + 1));j++) {
				enemies.get(i).add(new Lvl2Enemy(new Cell(new Location(0,0)), target));
			}			
		}
	}

}
