package logic;

import java.util.LinkedList;
import java.util.List;

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
    private List<Tower> towers;
    private Cell currentCell, nextCell;
    private int x, y;
    private final int numTowers = 4;
    
	
	
	public GameDisplay(Loadout loadout) throws Exception
	{
		cells = new Cell[39][28];
		for (int i = 0; i < cells.length; i++) {
            for(int j = 0 ; j < cells[i].length; j++)
            	cells[i][j] = new Cell(new Location(i,j));
        }
        
		this.player = new Player(cells[0][0],loadout);
        this.board = new Board(cells);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(board);
        BackgroundImage myBI= new BackgroundImage(new Image("file:./../images/Map027.png",39 * 30,29*30,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
        /*
        BackgroundImage myBI= new BackgroundImage(new Image("file:\\Users\\Christian\\Desktop\\jio\\stuff\\Workspace\\copx\\C.O.P.X\\trunk\\COPx\\images\\Map027.png",39 * 30,29*30,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
        */
        pane.setBackground(new Background(myBI));
        towers = new LinkedList<Tower>();
        this.getChildren().add(pane);
	}
	public void placeTower(int slot){

		if(slot >numTowers)
			return;
		
		Direction dir = player.getDirection();
		Tower towerToPlace = player.getLoadout().getTower(slot).getInstance();
		int towerCost = towerToPlace.getCost();
		
		if(towerCost > player.getBalance())
			return;
		
		player.setBalance(player.getBalance() - towerCost);
		towers.add(towerToPlace);
    	currentCell = player.getCurrentCell();
        nextCell = null;
        x = currentCell.getLocation().getX();
        y = currentCell.getLocation().getY();
        System.out.println("Player at" + x+ ", "+ y);
 		
	   	switch(dir){
   		case NORTH:
   	        if (y-1 >= 0){
   	            nextCell = cells[x][y - 1];
   	            System.out.println("Placeing tower Above player");
   	            nextCell.setEntityInCell(towerToPlace);
   	            towerToPlace.setCurrentCell(nextCell);
   			}
   	        
   	        //index was out of range, wrap around.
   	        else{
   	        	System.out.println("Can Not Place Tower There");
   	        }
   	        board.draw();
   			
   			break;
   		case NORTHEAST:
   			System.out.println("Need to be facing North/South/East/West");
   			break;
   		case EAST:
   	        if (x-1 >= 0){
   	            nextCell = cells[x-1][y];
   	            System.out.println("Placeing tower Right of the player");
   	            nextCell.setEntityInCell(towerToPlace);
   	            towerToPlace.setCurrentCell(nextCell);
   			}
   	        //if index was out of range, what do we do now?
   	        else{
   	        	//Wrap around

   	        	System.out.println("Can Not Place Tower There");
   	        }

   	        board.draw();
   			break;
   		case SOUTHEAST:
   			System.out.println("Need to be facing North/South/East/West");
   			break;
   		case SOUTH:
   	        if (y+1 < cells[0].length){
   	            nextCell = cells[x][y + 1];
   	            System.out.println("Placeing tower Below player");
   	            nextCell.setEntityInCell(towerToPlace);
   	            towerToPlace.setCurrentCell(nextCell);
   			}
   	        //if index was out of range, what do we do now?
   	        else{
   	        	//Wrap around

   	        	System.out.println("Can Not Place Tower There");
   	        }
   	        board.draw();
   			
   			break;
   		case SOUTHWEST:
   			System.out.println("Need to be facing North/South/East/West");
   			break;
   		case WEST:
   	       if (x+1 < cells.length){
                nextCell = cells[x+1][y];
   	            System.out.println("Placeing tower Left of the player");
   	            nextCell.setEntityInCell(towerToPlace);
   	            towerToPlace.setCurrentCell(nextCell);
   			}
   	        //if index was out of range, what do we do now?
   	        else{
   	        	//Wrap around

   	        	System.out.println("Can Not Place Tower There");
   	        }

  	        board.draw();
   			break;
   		case NORTHWEST:
   			System.out.println("Need to be facing North/South/East/West");
   			break;
   			
   		default:
   			break;
   			
    	}		

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
	           		case DIGIT1:
	           			placeTower(0);
	           		case DIGIT2:
	           			placeTower(1);
	           		case DIGIT3:
	           			placeTower(2);
	           		case DIGIT4:
	           			placeTower(3);
	           		default:
	           			break;
	           			
            	}
            	System.out.println("Player now at: " + player.getCurrentCell().getLocation().toString());
                	
                
            }
        });
    }

}
