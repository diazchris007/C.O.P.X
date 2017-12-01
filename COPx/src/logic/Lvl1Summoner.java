package logic;

public class Lvl1Summoner extends Summoner {

	private static final int NUMMINIONS = 1;
	public Lvl1Summoner(Entity target,Board board) {
		super(target, board);

		for(int i = 0; i <= NUMMINIONS; i++) { 
			enemies.add(new Lvl1Enemy(new Cell(new Location(0,0)), target));
		}
	}
	

}
