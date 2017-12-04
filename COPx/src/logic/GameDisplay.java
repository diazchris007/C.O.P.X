package logic;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.Board;
import logic.Cell;
import logic.Player;
import logic.Location;

public class GameDisplay extends Pane{
	private Cell[][] cells; 
    private Player player;
    private Board board;
    private List<Tower> towers;
    
    private static final Logger logger = Logger.getLogger(GameDisplay.class.getName());
    
    
    private final int numTowers;
    Summoner summoner;
    Button resumeBtn;
    Button restartBtn;
    Button saveBtn;
    Button exitBtn;
	Stage pausePopup;
	
	EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
		
		public void handle(ActionEvent e) {
			if (e.getSource() == resumeBtn) {
				pausePopup.close();
				summoner.unPause();
				return;
			}
		}
	};
	
	
	public GameDisplay(Loadout loadout)
	{
		numTowers = 4;
		cells = new Cell[39][28];
		for (int i = 0; i < cells.length; i++) {
            for(int j = 0 ; j < cells[i].length; j++)
            	cells[i][j] = new Cell(new Location(i,j));
        }
		this.player = new Player(cells[5][5],loadout);
        this.board = Board.getInstance();
        this.board.setCells(cells);
        this.board.draw();
        summoner = new Lvl1Summoner(player);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(board);
        BackgroundImage myBI= new BackgroundImage(new Image("file:./../images/Map027.png",39 * 30,29*30,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
        
        pane.setBackground(new Background(myBI));
        towers = new LinkedList<>();
        this.getChildren().add(pane);
        summoner.start();
	}
	public Player getPlayer()
	{
		return player;
	}
	
	public void placeTowerFunction(Boolean test,int x,int y,String sucessMessage , String balanceMessage, int towerCost, Tower towerToPlace ) {
		Cell nextCell;
		if (test){
	            nextCell = cells[x][y];

	   			if(nextCell.hasEntity())
	   				return;
	   			logger.log(Level.FINE, sucessMessage);
	            nextCell.setEntityInCell(towerToPlace);
	            towerToPlace.setCurrentCell(nextCell);
	            towerToPlace.getRange().recalculate(nextCell);
	            player.setBalance(player.getBalance() - towerCost);

	            logger.log(Level.FINE, balanceMessage);
			}
	        //index was out of range, wrap around.
	        else{
	        		String errorDirMessage = "Can Not Place Tower There";
	        		logger.log(Level.FINE, errorDirMessage );
	        }
	}
		
	public void placeTower(int slot){
		String towerCosts = "\n tower costs: ";
		String balanceString = "balance: ";
		Cell currentCell; 
	    int x;
	    int y;
		if(slot >numTowers)
			return;
		
		Direction dir = player.getDirection();
		Tower towerToPlace = player.getLoadout().getTower(slot).getInstance();
		int towerCost = towerToPlace.getCost();
		
		String message;
		
		if(towerCost > player.getBalance()) {
			 message = "Not enough balance: " + player.getBalance() + towerCosts + towerCost;
		     logger.log(Level.FINE, message);
			return;
		}
		towers.add(towerToPlace);
		summoner.addTower(towerToPlace);
    		currentCell = player.getCurrentCell();
        x = currentCell.getLocation().getX();
        y = currentCell.getLocation().getY();
        message = "Player at" + x + ", "+ y;
        logger.log(Level.FINE, message);
 		
	   	switch(dir){
	   		case SOUTH:
	   			placeTowerFunction((y-1 >= 0), x , y-1 , "Placing tower Above player",
	   							  balanceString + player.getBalance() + towerCosts + towerCost, towerCost,  towerToPlace );

	   	        board.draw();
	   			
	   			break;
	   		case NORTHEAST:
	   		case NORTHWEST:
	   		case SOUTHEAST:
	   		case SOUTHWEST:
	   			message = "Need to be facing North/South/East/West";
	   			logger.log(Level.FINE, message);
	   			break;
	   		case WEST:
	   			
	   			placeTowerFunction((x-1 >= 0),x -1 ,y,"Placing tower Right of the player" ,
	   					(balanceString + player.getBalance() + towerCosts + towerCost), towerCost, towerToPlace );
	
	   	        board.draw();
	   			break;
	   		case NORTH:
	   			placeTowerFunction(y+1 < cells[0].length, x, y+1 , "Placing tower Below player",
	   						balanceString + player.getBalance() + towerCosts + towerCost,
	   						 towerCost,  towerToPlace );

	   	        board.draw();
	   			
	   			break;

	   		case EAST:
	   			
	   			placeTowerFunction( (x+1 < cells.length), x+1, y,
	   							 "Placing tower Left of the player" ,
	   							(balanceString + player.getBalance() + towerCosts + towerCost),
	   							 towerCost,  towerToPlace );
	  	        board.draw();
	   			break;
	   			
	   		default:
	   			break;
	    	}		
	}
	public void moveDown(Entity ent) {
        if(ent.moveDown())
        	board.draw();
    }
    public void moveUp(Entity ent) {
        if(ent.moveUp())
        	board.draw();
    }
    public void moveLeft(Entity ent) {
        if(ent.moveLeft())
        	board.draw();
    }
    public void moveRight(Entity ent) {
        if(ent.moveRight())
        	board.draw();
    }
    public Board getBoard(){
    		return board;
    }
    
    public void pauseMenu() {
	    	VBox pauseRoot = new VBox(20);
	    	pauseRoot.getChildren().add(new Label("PAUSED"));
	    	pauseRoot.setStyle("-fx-backround-color: rgba(255, 255, 255, 0.8);");
	    	pauseRoot.setAlignment(Pos.CENTER);
	    	pauseRoot.setPadding(new Insets(20));
	    	
	    	resumeBtn = new Button("RESUME");
	    	restartBtn = new Button("RESTART");
	    	saveBtn = new Button("SAVE GAME");
	    	exitBtn = new Button("EXIT TO MAIN MENU");
	    	pauseRoot.getChildren().add(resumeBtn);
	    	pauseRoot.getChildren().add(restartBtn);
	    	pauseRoot.getChildren().add(saveBtn);
	    	pauseRoot.getChildren().add(exitBtn);
	    	
	    	setHandler();
	    	
	    	pausePopup = new Stage(StageStyle.TRANSPARENT);
	    	pausePopup.setScene(new Scene(pauseRoot));
	    	pausePopup.show();
    }
    
	public void setHandler() {
		resumeBtn.setOnAction(eventHandler);
	}
    
    public void setupInput(Scene gamescene)
    {
    		gamescene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent actionEvent) {
            		switch(actionEvent.getCode()){
	           		case S: 
	           		case DOWN: 
	           			moveDown(player);
	           			break;
	           		case W:
	           		case UP:
	           			moveUp(player);
	           			break;
	           		case A:
	           		case LEFT:
	           			moveLeft(player);
	           			break;
	           		case D:
	           		case RIGHT:
	           			moveRight(player);
	           			break;
	           		case Q:
	           			player.turnCCW();
	           			board.draw();
	           			break;
	           		case E:
	           			player.turnCW();
	           			board.draw();
	           			break;
	           		case ESCAPE:
	           		case P:
	           			summoner.pause();
	           			pauseMenu();
	           			break;
	           		case DIGIT1:
	           			placeTower(0);
	           			break;
	           		case DIGIT2:
	           			placeTower(1);
	           			break;
	           		case DIGIT3:
	           			placeTower(2);
	           			break;
	           		case DIGIT4:
	           			placeTower(3);
	           			break;
	           		case SPACE:
	           			summoner.unPause();
	           			break;
	           		default:
	           			break;
            		}
            		String message = "Player now at: " + player.getCurrentCell().getLocation().toString();
            		logger.log(Level.FINE, message);
            }
        });
    }
    
}
