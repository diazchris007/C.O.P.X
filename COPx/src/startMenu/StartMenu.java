package startMenu;
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
	Button settingBtn;
	Button startGameBtn;
	Button exitBtn_PlayGame;
	Button leaderboardBtn;
	Scene settingScene;
	GridPane settingSceneGrid;
	Scene startGameScene;
	GridPane startSceneGrid;
	Scene startScene;
	Scene leaderboardScene;
	Stage stage;
	
	Scene storeScene;
	Button storeBtn;
	GridPane storeGrid;
	
	Button buyGun;
	Button buySheild;
	Button buyItem;

	
	Label lbl_Setting;
	Label lblLoading;
	Label storeTitleLbl;

	Label lblRegions;
	Label lblAmerica;
	Label lblEurope;
	Label lblAsia;
	
	GridPane leaderboardSceneGrid;
	GridPane startGameSceneGrid;

	
	Button btnClear;
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
			if (e.getSource() == exitBtn_PlayGame) {
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

	   btnClear.setPrefWidth(150);
	   lblLoading.setPrefWidth(150);
	   lbl_Setting.setPrefWidth(150);

	   leaderboardBtn.setPrefWidth(150);

	   lblRegions.setPrefWidth(150);
	   exitBtn_PlayGame.setPrefWidth(150);

	  // store
	   storeBtn.setPrefWidth(150);
	   
	   buyGun.setPrefWidth(150);
	   buyGun.setPrefHeight(80);
	   buySheild.setPrefWidth(150);
	   buySheild.setPrefHeight(80);
	   buyItem.setPrefWidth(150);
	   buyItem.setPrefHeight(80);
	   storeTitleLbl.setPrefWidth(450);

	}
	 
	// sets handler
	public void attachCode() {
	   //have each button run BTNCODE when clicked
	   settingBtn.setOnAction(changeScreens);
	   startGameBtn.setOnAction(changeScreens);
	   exitBtn_PlayGame.setOnAction(changeScreens);
	   storeBtn.setOnAction(changeScreens);

	   leaderboardBtn.setOnAction(changeScreens);
	   btnClear.setOnAction(changeScreens);
	}
	
	public void setUpGameStage() {
		lblLoading = new Label("Loading...");
		lblLoading.setAlignment(Pos.CENTER);
		
		startGameSceneGrid = new GridPane(); 
		startGameSceneGrid.setAlignment(Pos.CENTER);
		
		startGameSceneGrid.setHgap(10);
		startGameSceneGrid.setVgap(10);
		
		// elements can only be added to one grid at a time
		//startGameSceneGrid.add(pic, 0,0);
		startGameSceneGrid.add(lblLoading, 0, 0);
		startGameSceneGrid.add(exitBtn_PlayGame, 0, 1);
		
		startGameScene = new Scene(startGameSceneGrid, 1000, 800);
		
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
		leaderboardSceneGrid.add(exitBtn_PlayGame, 0, 25);
		
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
		buySheild = new Button("Buy Shield", shieldIM);
		buyItem = new Button("Buy Item");
		
		storeGrid = new GridPane();
		storeGrid.setAlignment(Pos.CENTER);
		storeGrid.setHgap(10);
		storeGrid.setVgap(10);
		
		storeGrid.add(storeTitleLbl, 0, 0, 3, 1);
		
		storeGrid.add(buyGun, 0, 1);
		storeGrid.add(buySheild, 1, 1);
		storeGrid.add(buyItem, 2, 1);
		
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
		settingSceneGrid.add(exitBtn_PlayGame, 0,1);
		
		settingScene = new Scene(settingSceneGrid, 1000, 800);

	}
	
	@Override 
	public void start(Stage stagep) throws Exception {
		stage = stagep;
		
		exitBtn_PlayGame = new Button("Back to Start Screen");
		btnClear = new Button("Clear");
		
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
