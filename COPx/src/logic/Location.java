package logic;

public class Location {
	private int x;
	private int y;
	
	public Location(int x ,int y)
	{
		this.x = x;
		this.y = y;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	public void compare(Location other)
	{
		if(this.x== other.getX() && this.y == other.getY())
			return;
			
	}
	public String toString()
	{
		return "("+ x + ", " + y + ")"; 
	}
}