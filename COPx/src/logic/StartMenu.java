package logic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StartMenu extends Application {
	/* buttons */
	Button settingBtn;
	Button startGameBtn;
	Button leaderboardExitBtn;
	Button settingsExitBtn;
	Button storeExitBtn;
//	Button startGameExitBtn;
	Button leaderboardBtn;
	Button storeBtn;
	Button buyGun;
	Button buyShield;
	Button buyItem;
	
	/* scenes */
	Scene settingScene;
	Scene startGameScene;
	Scene startScene;
	Scene leaderboardScene;
	Scene storeScene;
	Stage stage;
	
	/* grid panes */
	GridPane settingSceneGrid;
	GridPane storeGrid;
	GridPane startSceneGrid;
	GridPane leaderboardSceneGrid;
//	GridPane startGameSceneGrid;
	
	/* labels */
	Label lbl_Setting;
	Label storeTitleLbl;
	Label lblRegions;
	Label lblAmerica;
	Label lblEurope;
	Label lblAsia;
	
	EventHandler<ActionEvent> changeScreens = new EventHandler<ActionEvent>(){
		// handles all events
		public void handle(ActionEvent e) {
			
			if (e.getSource() == settingBtn) {
				stage.setScene(settingScene);
				return;
			}
			if (e.getSource() == startGameBtn) {
				stage.setScene(startGameScene);
				
				return;
			}
			if (e.getSource() == leaderboardExitBtn ||
					e.getSource() == settingsExitBtn ||
					e.getSource() == storeExitBtn) {
//					e.getSource() == startGameExitBtn) {
				stage.setScene(startScene);
				return;
			}
			if (e.getSource() == storeBtn) {
				stage.setScene(storeScene);
				return;
			}

			if (e.getSource() == leaderboardBtn) {
				stage.setScene(leaderboardScene);
				return;
			}
		}
	};

	public static void main( String[] args) {
		launch(args);
	}
	
	private void setWidths() {
	   settingBtn.setPrefWidth(70);
	   startGameBtn.setPrefWidth(150);

	   lbl_Setting.setPrefWidth(150);

	   leaderboardBtn.setPrefWidth(150);

	   lblRegions.setPrefWidth(150);
	   leaderboardExitBtn.setPrefWidth(150);
	   settingsExitBtn.setPrefWidth(150);
	   storeExitBtn.setPrefWidth(150);
//	   startGameExitBtn.setPrefWidth(150);

	  // store
	   storeBtn.setPrefWidth(150);
	   
	   buyGun.setPrefWidth(150);
	   buyGun.setPrefHeight(80);
	   buyShield.setPrefWidth(150);
	   buyShield.setPrefHeight(80);
	   buyItem.setPrefWidth(150);
	   buyItem.setPrefHeight(80);
	   storeTitleLbl.setPrefWidth(450);

	}
	 
	// sets handler
	public void attachCode() {
	   //have each button run changeScreens when clicked
	   settingBtn.setOnAction(changeScreens);
	   startGameBtn.setOnAction(changeScreens);
	   leaderboardExitBtn.setOnAction(changeScreens);
	   settingsExitBtn.setOnAction(changeScreens);
	   storeExitBtn.setOnAction(changeScreens);
//	   startGameExitBtn.setOnAction(changeScreens);
	   storeBtn.setOnAction(changeScreens);
	   leaderboardBtn.setOnAction(changeScreens);
	}
	
	public void setUpGameStage() throws Exception {
		GameDisplay gameDisplay = new GameDisplay();
		startGameScene = new Scene(gameDisplay);
		gameDisplay.setupInput(startGameScene);
	}
	
	public void setUpLeaderboardStage() {
		lblRegions = new Label("Select Region Below");
		lblRegions.setAlignment(Pos.CENTER);
		
		lblAmerica = new Label("America");
		lblAmerica.setAlignment(Pos.CENTER);
		
		lblEurope = new Label("Europe");
		lblEurope.setAlignment(Pos.CENTER);
		
		lblAsia = new Label("Asia");
		lblAsia.setAlignment(Pos.CENTER);
		
		leaderboardSceneGrid = new GridPane();
		leaderboardSceneGrid.setAlignment(Pos.CENTER);
		
		leaderboardSceneGrid.setHgap(10);
		leaderboardSceneGrid.setVgap(10);
		
		leaderboardSceneGrid.add(lblRegions, 0, 0);
		leaderboardSceneGrid.add(lblAmerica, 2, 2);
		leaderboardSceneGrid.add(lblEurope, 4, 2);
		leaderboardSceneGrid.add(lblAsia, 6, 2);
		leaderboardSceneGrid.add(leaderboardExitBtn, 0, 25);
		
		leaderboardScene = new Scene(leaderboardSceneGrid, 1000, 800);
		
	}
	
	public void setUpStorePage() {
		storeTitleLbl = new Label("Welcome to the store");
		storeTitleLbl.setAlignment(Pos.CENTER);
		
		Image gun = new Image("File:./../images/gunIcon.png");
		ImageView gunIM = new ImageView();
		gunIM.setFitWidth(50);
		gunIM.setFitHeight(40);
		gunIM.setImage(gun);
		
		Image shield = new Image("File:./../images/shieldIcon.png");
		ImageView shieldIM = new ImageView();
		shieldIM.setFitWidth(50);
		shieldIM.setFitHeight(40);
		shieldIM.setImage(shield);
		
		buyGun = new Button("Buy Gun", gunIM);
		buyShield = new Button("Buy Shield", shieldIM);
		buyItem = new Button("Buy Item");
		storeExitBtn = new Button("Back to Start Screen");
		
		storeGrid = new GridPane();
		storeGrid.setAlignment(Pos.CENTER);
		storeGrid.setHgap(10);
		storeGrid.setVgap(10);
		
		storeGrid.add(storeTitleLbl, 0, 0, 3, 1);
		
		storeGrid.add(buyGun, 0, 1);
		storeGrid.add(buyShield, 1, 1);
		storeGrid.add(buyItem, 2, 1);
		storeGrid.add(storeExitBtn, 1, 4);
		
		storeScene = new Scene(storeGrid, 1000, 800); 
	}
	
	public void setUpStartScreen() {

		storeBtn = new Button("Store");
		startGameBtn = new Button("Start Game");
		leaderboardBtn = new Button("View Leaderboard");
		settingBtn = new Button("Settings");

		startSceneGrid = new GridPane();
		
		startSceneGrid.setAlignment(Pos.CENTER);
		
		startSceneGrid.setHgap(10);
		startSceneGrid.setVgap(10);

		Image logo = new Image("File:./../images/COPX_logo.png");
		ImageView pic = new ImageView();
		pic.setFitWidth(260);
		pic.setFitHeight(130);
		pic.setImage(logo);
		
		startSceneGrid.add(pic, 0,0, 4, 1 );
		startSceneGrid.add(settingBtn, 1, 1);
		startSceneGrid.add(startGameBtn, 0,1);
		startSceneGrid.add(storeBtn, 0, 2);
		startSceneGrid.add(leaderboardBtn, 2, 1);
		
		startScene = new Scene(startSceneGrid, 1000, 800);
	}
	
	public void setUpSettingPage() {
		lbl_Setting = new Label("Settings:");
		lbl_Setting.setAlignment(Pos.CENTER);
		
		settingSceneGrid = new GridPane(); 
		settingSceneGrid.setAlignment(Pos.CENTER);
		
		settingSceneGrid.setHgap(10);
		settingSceneGrid.setVgap(10);
		
		settingSceneGrid.add(lbl_Setting, 0, 0);
		settingSceneGrid.add(settingsExitBtn, 0,1);
		
		settingScene = new Scene(settingSceneGrid, 1000, 800);
	}
	
	@Override 
	public void start(Stage stagep) throws Exception {
		stage = stagep;
		
		leaderboardExitBtn = new Button("Back to Start Screen");
		settingsExitBtn = new Button("Back to Start Screen");
		
		setUpStartScreen();
		setUpSettingPage();
		setUpGameStage();
		setUpStorePage();
		setUpLeaderboardStage();

		setWidths();
		attachCode();
		 
		stage.setScene(startScene);
		stage.setTitle("COPX");
		stage.show();
	}
}
