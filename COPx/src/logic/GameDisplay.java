package logic;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import logic.Board;
import logic.Cell;
import logic.Player;
import logic.Location;

public class GameDisplay extends Pane{
	private Cell cells[][]; 
    private Player player;
    private Board board;
    private Cell currentCell, nextCell;
    private int x, y; 
    
    
	
	
	public GameDisplay() throws Exception
	{
		cells = new Cell[39][28];
		for (int i = 0; i < cells.length; i++) {
            for(int j = 0 ; j < cells[i].length; j++)
            	cells[i][j] = new Cell(new Location(i,j));
        }
        
		this.player = new Player(cells[0][0]);
        this.board = new Board(cells);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(board);
        
        BackgroundImage myBI= new BackgroundImage(new Image("File:./../images/Map027.png",39 * 30,29*30,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));
        
        this.getChildren().add(pane);
	}
	public void moveDown() {
        
        currentCell = player.getCurrentCell();
        nextCell = null;
        x = currentCell.getLocation().getX();
        y = currentCell.getLocation().getY();
        System.out.println("Player at" + x+ ", "+ y);
        
        //if not at the end of board
        if (y+1 < cells[0].length){
			cells[x][y].clearEntityInCell();
            nextCell = cells[x][y + 1];
            System.out.println("moving player down");
        	player.setCurrentCell(nextCell);
            nextCell.setEntityInCell(player);
		}
        //if index was out of range, what do we do now?
        else{
        	//Wrap around
            player.setCurrentCell(cells[x][0]);
            cells[x][0].setEntityInCell(player);
            cells[x][y].clearEntityInCell();
        }
        board.draw();
    }
    public void moveUp() {
    	currentCell = player.getCurrentCell();
        nextCell = null;
        x = currentCell.getLocation().getX();
        y = currentCell.getLocation().getY();
        System.out.println("Player at" + x+ ", "+ y);
        
        if (y-1 >= 0){
			cells[x][y].clearEntityInCell();
            nextCell = cells[x][y - 1];
            System.out.println("moving player up");
        	player.setCurrentCell(nextCell);
            nextCell.setEntityInCell(player);
		}
        
        //index was out of range, wrap around.
        else{
        	player.setCurrentCell(cells[x][cells[0].length -1]);
            cells[x][cells[0].length-1].setEntityInCell(player);
            cells[x][y].clearEntityInCell();
        }
        board.draw();
    }
    public void moveLeft() {
    	currentCell = player.getCurrentCell();
        nextCell = null;
        x = currentCell.getLocation().getX();
        y = currentCell.getLocation().getY();
        
        if (x-1 >= 0){
			cells[x][y].clearEntityInCell();
            nextCell = cells[x-1][y];
            System.out.println("moving player left");
        	player.setCurrentCell(nextCell);
            nextCell.setEntityInCell(player);
		}
       //index was out of range
        else{
        	//System.out.println("Player reached end" + x+ ", "+ y);
            player.setCurrentCell(cells[cells.length -1][y]);
            cells[cells.length -1][y].setEntityInCell(player);
            cells[x][y].clearEntityInCell();
        }
        
        board.draw();
    }
    public void moveRight() {
    	currentCell = player.getCurrentCell();
        nextCell = null;
        x = currentCell.getLocation().getX();
        y = currentCell.getLocation().getY();
        
        if (x+1 < cells.length){
			cells[x][y].clearEntityInCell();
            nextCell = cells[x+1][y];
            System.out.println("moving player right");
        	player.setCurrentCell(nextCell);
            nextCell.setEntityInCell(player);
		}
        else{
        	player.setCurrentCell(cells[0][y]);
            cells[0][y].setEntityInCell(player);
            cells[x][y].clearEntityInCell();
        }
        
        board.draw();
    }
    public void setupInput(Scene Gamescene)
    {
    	Gamescene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent actionEvent) {
            	switch(actionEvent.getCode()){
	           		case S: 
	           			moveDown();
	           			break;
	           		case W:
	           			moveUp();
	           			break;
	           		case A:
	           			moveLeft();
	           			break;
	           		case D:
	           			moveRight();
	           			break;
	           		case DOWN: 
	           			moveDown();
	           			break;
	           		case UP:
	           			moveUp();
	           			break;
	           		case LEFT:
	           			moveLeft();
	           			break;
	           		case RIGHT:
	           			moveRight();
	           			break;
	           		case Q:
	           			player.turnCCW();
	           			break;
	           		case E:
	           			player.turnCW();
	           			break;
	           		case ESCAPE:
	           			//TODO go to pause scene. . . 
	           			break;
	           		default:
	           			break;
	           			
            	}
            	System.out.println("Player now at: " + player.getCurrentCell().getLocation().toString());
                	
                
            }
        });
    }

}
