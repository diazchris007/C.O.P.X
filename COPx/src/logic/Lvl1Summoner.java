package logic;

public class Lvl1Summoner extends Summoner {

	private final int NUM_MINIONS = 1;
	public Lvl1Summoner(Entity target,Board board) {
		super(target, board);
		// TODO Auto-generated constructor stub
		for(int i = 0; i <= NUM_MINIONS; i++) {
			enemies.add(new Lvl1Enemy(new Cell(new Location(0,0)), target));
		}
	}
	

}
