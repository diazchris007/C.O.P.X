package logic;

public class Cell {
    private Location location;
    private Entity entityInCell;
    
    public Cell(Location location) {
        this.location= location;
    }
    public void setEntityInCell(Entity p){
        this.entityInCell = p;
    }
    public void clearEntityInCell(){
        this.entityInCell = null;
    }
    public Entity getEntityInCell(){
        return this.entityInCell;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
	public Location getIndex() {
		return location;
	}
		
}