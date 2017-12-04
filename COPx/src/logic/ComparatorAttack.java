package logic;

import java.util.Comparator;

public class ComparatorAttack implements Comparator<Entity> {
	
	@Override
	public int compare(Entity arg0, Entity arg1) {
		if(arg0.getHeathPercent() > arg1.getHeathPercent())
			return 1;
		if(arg0.getHeathPercent() < arg1.getHeathPercent())
			return -1;
		return 0;
		
	}
}
