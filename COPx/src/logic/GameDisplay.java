package logic;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	private Cell cells[][] = new Cell[39][28];
    private Player player;
    private Board board;
    private Cell currentCell, nextCell;
    private int x, y; 
    private Scene scene;
    Button move = new Button("move");
	
	
	public GameDisplay() throws Exception
	{
		for (int i = 0; i < cells.length; i++) {
        	
            for(int j = 0 ; j < cells[i].length; j++)
            	cells[i][j] = new Cell(new Location(i,j));
        }
        this.player = new Player(cells[0][0]);
        this.board = new Board(player, cells);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(board);
        
        
        BackgroundImage myBI= new BackgroundImage(new Image("File:./../images/Map027.png",39 * 30,29*30,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
        //then you set to your node
        pane.setBackground(new Background(myBI));
        
        //primaryStage.minWidthProperty().bind(board.widthProperty());
        
        this.getChildren().add(pane);
	}
	public void moveDown() {
        //Get current players cell, we want to move them one right
        currentCell = player.getCurrentCell();
        nextCell = null;
        //Searching for current cell in board, if found we need to clear the player from it and select the next cell
        x = 0;
        y = 0;
        findPlayer(); 
        System.out.println("Player at" + x+ ", "+ y);
        findPlayer();
        
        if (y+1 < cells[0].length){
			cells[x][y].clearPlayerInCell();
            nextCell = cells[x][y + 1];
		}
        //We found it, let's move the player
        if (nextCell != null) {
        	System.out.println("moving player down");
        	player.setCurrentCell(nextCell);
            nextCell.setPlayerInCell(player);
        }
        //We didn't find it, or our index was out of range, what do we do now?
        else{
        	//System.out.println("Player reaced end" + x+ ", "+ y);
            //Error handling, next cell not found
            //Example, let's put them back at the start
            player.setCurrentCell(cells[x][0]);
            cells[x][0].setPlayerInCell(player);
            cells[x][y].clearPlayerInCell();
        }
        //System.out.println("Player now at: " + player.getCurrentCell().getLocation().toString());
        board.paint();
    }
    public void moveUp() {
        //Get current players cell, we want to move them one right
        //currentCell = player.getCurrentCell();
        nextCell = null;
        //Searching for current cell in board, if found we need to clear the player from it and select the next cell
        x = 0;
        y = 0;
        findPlayer();
        
        if (y-1 >= 0){
			cells[x][y].clearPlayerInCell();
            nextCell = cells[x][y - 1];
		}
        //We found it, let's move the player
        if (nextCell != null) {
        	System.out.println("moving player up");
        	player.setCurrentCell(nextCell);
            nextCell.setPlayerInCell(player);
        }
        //We didn't find it, or our index was out of range, what do we do now?
        else{
        	//System.out.println("Player reached end" + x+ ", "+ y);
            //Error handling, next cell not found
            //Example, let's put them back at the start
            player.setCurrentCell(cells[x][cells[0].length -1]);
            cells[x][cells[0].length-1].setPlayerInCell(player);
            cells[x][y].clearPlayerInCell();
        }
        //System.out.println("Player now at: " + player.getCurrentCell().getLocation().toString());
        board.paint();
    }
    public void moveLeft() {
        //Get current players cell, we want to move them one right
        //currentCell = player.getCurrentCell();
        nextCell = null;
        //Searching for current cell in board, if found we need to clear the player from it and select the next cell
        x = 0;
        y = 0;
        findPlayer();
        
        if (x-1 >= 0){
			cells[x][y].clearPlayerInCell();
            nextCell = cells[x-1][y];
		}
        //We found it, let's move the player
        if (nextCell != null) {
        	System.out.println("moving player left");
        	player.setCurrentCell(nextCell);
            nextCell.setPlayerInCell(player);
        }
        //We didn't find it, or our index was out of range, what do we do now?
        else{
        	System.out.println("Player reached end" + x+ ", "+ y);
            //Error handling, next cell not found
            //Example, let's put them back at the start
            player.setCurrentCell(cells[cells.length -1][y]);
            cells[cells.length -1][y].setPlayerInCell(player);
            cells[x][y].clearPlayerInCell();
        }
        //System.out.println("Player now at: " + player.getCurrentCell().getLocation().toString());
        board.paint();
    }
    public void moveRight() {
        //Get current players cell, we want to move them one right
        //currentCell = player.getCurrentCell();
        nextCell = null;
        //Searching for current cell in board, if found we need to clear the player from it and select the next cell
        x = 0;
        y = 0;
        findPlayer();
        
        if (x+1 < cells.length){
			cells[x][y].clearPlayerInCell();
            nextCell = cells[x+1][y];
		}
        //We found it, let's move the player
        if (nextCell != null) {
        	System.out.println("moving player right");
        	player.setCurrentCell(nextCell);
            nextCell.setPlayerInCell(player);
        }
        //We didn't find it, or our index was out of range, what do we do now?
        else{
        	//System.out.println("Player reached end" + x+ ", "+ y);
            //Error handling, next cell not found
            //Example, let's put them back at the start
            player.setCurrentCell(cells[0][y]);
            cells[0][y].setPlayerInCell(player);
            cells[x][y].clearPlayerInCell();
        }
        //System.out.println("Player now at: " + player.getCurrentCell().getLocation().toString());
        board.paint();
    }
    private void findPlayer()
    {
    	currentCell = player.getCurrentCell();
    	for (x = 0; x < cells.length; x++)
        {
            Cell[] c = cells[x];
            boolean found = false;
        	for(y = 0; y < c.length; y++)
        	{
        		if (c[y] == currentCell){
        			found = true;
        			break;
        		}    
            }
        	if(found){
        		//System.out.println("found playerPlayer at: " + x +", " +y);
        		break;
        	}
        }
    }
    public void setupInput(Scene pane)
    {
    	pane.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent actionEvent) {
            	switch(actionEvent.getCode()){
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
            	}
            	System.out.println("Player now at: " + player.getCurrentCell().getLocation().toString());
                	
                
            }
        });
    }

}
