package logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Enemy extends Entity {
	
    protected Image currentImage;
    protected Direction dir;
    protected Entity target;

	public Enemy(int health, Cell startCell,Entity target){
		currentImage = null;
		this.currentCell = startCell;
		this.target = target;
		maxHealth = health;
		currentHealth = health;
	}
	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return currentImage;
	}
	public void setTarget(Entity target) {
		// TODO Auto-generated method stub
		this.target = target;
	}
	public Entity getTarget() {
		return target;
	}
	public Cell[][] moveToTarget(Board board) {
		
		Cell targetCell = target.getCurrentCell();
		Location targetLoc = targetCell.getLocation();
		Location currentLoc = currentCell.getLocation();
		int currentX = currentLoc.getX();
		int currentY = currentLoc.getY();
		int targetX = targetLoc.getX();
		int targetY = targetLoc.getY();
		if(targetX == currentX) {
			if(((targetY - 1) == currentY) || ((targetY + 1) == currentY)) {
				System.out.println("Target is infront");
			}
			else if(targetY > currentY) {
				return moveDown(board);
			}
			else if(targetY < currentY) {
				return moveUp(board);
			}
			
		}
		else if(targetY == currentY) {
			if(((targetX - 1) == currentX) || ((targetX + 1) == currentX)) {
				System.out.println("Target is infront");
			}
			else if(targetX > currentX) {
				return moveRight(board);
			}
			else if(targetX < currentX) {
				return moveLeft(board);
			}

		}
		else {
			if(targetX > currentX) {
				return moveRight(board);
			}
			else {
				return moveLeft(board);
			}
		}
		
		return board.getCells();
	}

}
