package logic;

import java.util.LinkedList;
import java.util.List;

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
	private Cell cells[][]; 
    private Player player;
    private Board board;
    private List<Tower> towers;
    
    
    private final int numTowers;
    Summoner summoner;
    Button resumeBtn, restartBtn, saveBtn, exitBtn;
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
	
	
	public GameDisplay(Loadout loadout) throws Exception
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
        summoner = new Lvl1Summoner(player, board);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(board);
        BackgroundImage myBI= new BackgroundImage(new Image("file:./../images/Map027.png",39 * 30,29*30,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
        
        pane.setBackground(new Background(myBI));
        towers = new LinkedList<Tower>();
        this.getChildren().add(pane);
        summoner.start();
	}
	public Player getPlayer()
	{
		return player;
	}
	public void placeTower(int slot){

		Cell currentCell; 
	    Cell nextCell;
	    int x;
	    int y;
		if(slot >numTowers)
			return;
		
		Direction dir = player.getDirection();
		Tower towerToPlace = player.getLoadout().getTower(slot).getInstance();
		int towerCost = towerToPlace.getCost();
		
		if(towerCost > player.getBalance()) {
			System.out.println("Not enough balance: " + player.getBalance() +"\n tower costs: " + towerCost);
			return;
		}
		towers.add(towerToPlace);
		summoner.addTower(towerToPlace);
    	currentCell = player.getCurrentCell();
        nextCell = null;
        x = currentCell.getLocation().getX();
        y = currentCell.getLocation().getY();
        System.out.println("Player at" + x+ ", "+ y);
 		
	   	switch(dir){
   		case NORTH:
   			if (y-1 >= 0){
   	            nextCell = cells[x][y - 1];

   	   			if(nextCell.hasEntity())
   	   				return;
   	            System.out.println("Placeing tower Above player");
   	            nextCell.setEntityInCell(towerToPlace);
   	            towerToPlace.setCurrentCell(nextCell);
   	            
   	            player.setBalance(player.getBalance() - towerCost);

   	            System.out.println("balance: " + player.getBalance() +"\n tower costs: " + towerCost);
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
   	   			if(nextCell.hasEntity())
   	   				return;
   	            System.out.println("Placeing tower Right of the player");
   	            nextCell.setEntityInCell(towerToPlace);
   	            towerToPlace.setCurrentCell(nextCell);
   	            player.setBalance(player.getBalance() - towerCost);

   	            System.out.println("balance: " + player.getBalance() +"\n tower costs: " + towerCost);
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
   	   			if(nextCell.hasEntity())
   	   				return;
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
   	   			if(nextCell.hasEntity())
   	   				return;
   	            System.out.println("Placeing tower Left of the player");
   	            nextCell.setEntityInCell(towerToPlace);
   	            towerToPlace.setCurrentCell(nextCell);
   	            player.setBalance(player.getBalance() - towerCost);

   	            System.out.println("balance: " + player.getBalance() +"\n tower costs: " + towerCost);
   	            
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
	public void moveDown(Entity ent) {
        
		board.setCells(ent.moveDown(board));
        board.draw();
    }
    public void moveUp(Entity ent) {
    	board.setCells(ent.moveUp(board));
        board.draw();
    }
    public void moveLeft(Entity ent) {
    	board.setCells(ent.moveLeft(board));
        board.draw();
    }
    public void moveRight(Entity ent) {
    	board.setCells(ent.moveRight(board));
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
    
    public void setupInput(Scene Gamescene)
    {
    	Gamescene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent actionEvent) {
            	switch(actionEvent.getCode()){
	           		case S: 
	           			moveDown(player);
	           			break;
	           		case W:
	           			moveUp(player);
	           			break;
	           		case A:
	           			moveLeft(player);
	           			break;
	           		case D:
	           			moveRight(player);
	           			break;
	           		case DOWN: 
	           			moveDown(player);
	           			break;
	           		case UP:
	           			moveUp(player);
	           			break;
	           		case LEFT:
	           			moveLeft(player);
	           			break;
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
	           		case P:
	           			summoner.pause();
	           			break;
	           		default:
	           			break;
	           			
            	}
            	System.out.println("Player now at: " + player.getCurrentCell().getLocation().toString());
                	
                
            }
        });
    }
    
}
