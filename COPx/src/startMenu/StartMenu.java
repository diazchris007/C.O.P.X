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
	Button btnStartGameBtn;
	Button exitBtn_PlayGame;
	Button leaderboardBtn;
	Scene settingScene;
	Scene startGameScene;
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

	
	Button btnClear;
	EventHandler<ActionEvent> changeScreens = new EventHandler<ActionEvent>(){
		// handles all events
		public void handle(ActionEvent e) {
			
			if (e.getSource() == settingBtn) {
				stage.setScene(settingScene);
				return;
			}
			if (e.getSource() == btnStartGameBtn) {
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
	   btnStartGameBtn.setPrefWidth(150);
	   storeBtn.setPrefWidth(150);

	   leaderboardBtn.setPrefWidth(150);

	   exitBtn_PlayGame.setPrefWidth(150);
		
	   btnClear.setPrefWidth(150);
	   lblLoading.setPrefWidth(150);
	   lbl_Setting.setPrefWidth(150);

	   storeTitleLbl.setPrefWidth(450);

	   lblRegions.setPrefWidth(150);
	   
	   
	   buyGun.setPrefWidth(150);
	   buyGun.setPrefHeight(80);
	   buySheild.setPrefWidth(150);
	   buySheild.setPrefHeight(80);
	   buyItem.setPrefWidth(150);
	   buyItem.setPrefHeight(80);
	}
	 
	// sets handler
	public void attachCode() {
	   //have each button run BTNCODE when clicked
	   settingBtn.setOnAction(changeScreens);
	   btnStartGameBtn.setOnAction(changeScreens);
	   exitBtn_PlayGame.setOnAction(changeScreens);
	   storeBtn.setOnAction(changeScreens);



	   leaderboardBtn.setOnAction(changeScreens);
	   btnClear.setOnAction(changeScreens);
	}
	
	
	
	@Override 
	public void start(Stage stagep) throws Exception {
		stage = stagep;
		btnStartGameBtn = new Button("Start Game");
		settingBtn = new Button("Settings");
		exitBtn_PlayGame = new Button("Back to Start Screen");
		btnClear = new Button("Clear");
		leaderboardBtn = new Button("View Leaderboard");
		
		lblLoading = new Label("Loading...");
		lblLoading.setAlignment(Pos.CENTER);
		
		lbl_Setting = new Label("Settings:");
		lbl_Setting.setAlignment(Pos.CENTER);
		
		storeTitleLbl = new Label("Welcome to the store");
		storeTitleLbl.setAlignment(Pos.CENTER);

		lblRegions = new Label("Select Region Below");
		lblRegions.setAlignment(Pos.CENTER);
		
		lblAmerica = new Label("America");
		lblAmerica.setAlignment(Pos.CENTER);
		
		lblEurope = new Label("Europe");
		lblEurope.setAlignment(Pos.CENTER);
		
		lblAsia = new Label("Asia");
		lblAsia.setAlignment(Pos.CENTER);
		
		storeBtn = new Button("Store");
		
		
//		Image imageOk = new Image(getClass().getResourceAsStream("ok.png"));
//		Button button3 = new Button("Accept", new ImageView(imageOk));
//		
//		Image logo = new Image("File:./../images/COPX_logo.png");
		
		//Image gun = new Image(getClass().getResourceAsStream("gunIcon.png"));
		Image gun = new Image("File:./../images/gunIcon.png");
		ImageView gunIM = new ImageView();
		gunIM.setFitWidth(50);
		gunIM.setFitHeight(40);
		gunIM.setImage(gun);
		
		//Image shield = new Image(getClass().getResourceAsStream("ok.png"));
		Image shield = new Image("File:./../images/shieldIcon.png");
		ImageView shieldIM = new ImageView();
		shieldIM.setFitWidth(50);
		shieldIM.setFitHeight(40);
		shieldIM.setImage(shield);
		
		buyGun = new Button("Buy Gun", gunIM);
		buySheild = new Button("Buy Shield", shieldIM);
		buyItem = new Button("Buy Item");

		
		GridPane startSceneGrid = new GridPane();
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
		startSceneGrid.add(btnStartGameBtn, 0,1);
		startSceneGrid.add(storeBtn, 0, 2);

		startSceneGrid.add(leaderboardBtn, 2, 1);
		
		GridPane settingSceneGrid = new GridPane(); 
		settingSceneGrid.setAlignment(Pos.CENTER);
		
		settingSceneGrid.setHgap(10);
		settingSceneGrid.setVgap(10);
		
		settingSceneGrid.add(lbl_Setting, 0, 0);
		settingSceneGrid.add(exitBtn_PlayGame, 0,1);
		
		GridPane startGameSceneGrid = new GridPane(); 
		startGameSceneGrid.setAlignment(Pos.CENTER);
		
		startGameSceneGrid.setHgap(10);
		startGameSceneGrid.setVgap(10);
		
		// elements can only be added to one grid at a time
		//startGameSceneGrid.add(pic, 0,0);
		startGameSceneGrid.add(lblLoading, 0, 0);
		startGameSceneGrid.add(exitBtn_PlayGame, 0, 1);

		storeGrid = new GridPane();
		storeGrid.setAlignment(Pos.CENTER);
		storeGrid.setHgap(10);
		storeGrid.setVgap(10);
		
		storeGrid.add(storeTitleLbl, 0, 0, 3, 1);
		
		storeGrid.add(buyGun, 0, 1);
		storeGrid.add(buySheild, 1, 1);
		storeGrid.add(buyItem, 2, 1);

		
		GridPane leaderboardSceneGrid = new GridPane();
		leaderboardSceneGrid.setAlignment(Pos.CENTER);
		
		leaderboardSceneGrid.setHgap(10);
		leaderboardSceneGrid.setVgap(10);
		
		leaderboardSceneGrid.add(lblRegions, 0, 0);
		leaderboardSceneGrid.add(lblAmerica, 2, 2);
		leaderboardSceneGrid.add(lblEurope, 4, 2);
		leaderboardSceneGrid.add(lblAsia, 6, 2);
		leaderboardSceneGrid.add(exitBtn_PlayGame, 0, 25);


		setWidths();
		attachCode();
		
		startScene = new Scene(startSceneGrid, 1000, 800);
		settingScene = new Scene(settingSceneGrid, 1000, 800);
		startGameScene = new Scene(startGameSceneGrid, 1000, 800);

		storeScene = new Scene(storeGrid, 1000, 800); 
		

		leaderboardScene = new Scene(leaderboardSceneGrid, 1000, 800);
		 
		stage.setScene(startScene);
		stage.setTitle("COPX");
		stage.show();

	}
}
