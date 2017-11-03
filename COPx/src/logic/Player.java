package logic;

public class Player extends Entity{
    private Cell currentCell;
    public Player(Cell cell) throws Exception {
        this.currentCell = cell;
        cell.setPlayerInCell(this);
    }
    
	public Cell getCurrentCell(){
        return this.currentCell;
    }

    public void setCurrentCell(Cell cell){
        this.currentCell = cell;
    }
}