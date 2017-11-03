package logic;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell {
    private Location location;
    private Entity entityInCell;
    private Rectangle r1;
    public Cell(Location location) {
        this.location= location;
        r1 = new Rectangle();
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.WHITE);
    }
    public void setPlayerInCell(Player p){
        this.entityInCell = p;
    }
    public void clearPlayerInCell(){
        this.entityInCell = null;
    }
    public Entity getPlayerInCell(){
        return this.entityInCell;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
	public Location getIndex() {
		// TODO Auto-generated method stub
		return location;
	}
	/**
	 * @return the r1
	 */
	public Rectangle getR1() {
		return r1;
	}
	/**
	 * @param r1 the r1 to set
	 */
	public void setR1(Rectangle r1) {
		this.r1 = r1;
	}
	
}