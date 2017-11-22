package logic;

import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StartMenu extends Application {
	// buttons
	Button settingBtn;
	Button wrenchBtn;
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
	Button americasRegion;
	Button europeRegion;
	Button asiaRegion;
	Button oceaniaRegion;
	Button africaRegion;
	Button accountBtn;
	Button tbd1Btn;
	Button tbd2Btn;
	
	Button manageLoadoutBtn;
	//Button manageLoadoutExitBtn;
	
	// scenes
	Scene settingScene;
	Scene startGameScene;
	Scene startScene;
	Scene leaderboardScene;
	Scene storeScene;
	Scene manageLoadoutScene;
	Scene americasScene;
	Scene europeScene;
	Scene asiaScene;
	Scene oceaniaScene;
	Scene africaScene;
	
	// stage
	Stage stage;
	
	// grid panes
	GridPane settingSceneGrid;
	GridPane storeGrid;
	GridPane startSceneGrid;
	GridPane leaderboardSceneGrid;
//	GridPane startGameSceneGrid;
	
	// labels
	Label lblSetting;
	Label storeTitleLbl;
	Label lblRegions;
	
	Profile profile;
	
	EventHandler<ActionEvent> changeScreens = new EventHandler<ActionEvent>() {
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
					e.getSource() == storeExitBtn ){
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
			if (e.getSource() == manageLoadoutBtn)
			{
				stage.setScene(manageLoadoutScene);
				return;
			}
		}
	};
	
	/*
	 ********************* 
	 ********TO-DO******** 
	 *********************
	EventHandler<ActionEvent> changeLeaderboardRegions = new EventHandler<ActionEvent>() {
		// handles all events
		public void handle(ActionEvent e) {
			if (e.getSource() == americasRegion) {
				stage.setScene(americasScene);
				return;
			}
			if (e.getSource() == africaRegion) {
				stage.setScene(africaScene);
				
				return;
			}
			if (e.getSource() == asiaRegion) {
				stage.setScene(asiaScene);
				return;
			}
			if (e.getSource() == europeRegion) {
				stage.setScene(europeScene);
				return;
			}

			if (e.getSource() == oceaniaRegion) {
				stage.setScene(oceaniaScene);
				return;
			}
		}
	}; */

	public static void main( String[] args) {
		launch(args);
	}
	
	private void setWidths() {
	   startGameBtn.setPrefWidth(150);

	   // leaderboard
	   lblRegions.setPrefWidth(150);
	   leaderboardBtn.setPrefWidth(150);
	   leaderboardExitBtn.setPrefWidth(150);
	   
	   // settings
	   lblSetting.setPrefWidth(150);
	   settingBtn.setPrefWidth(150);
	   settingsExitBtn.setPrefWidth(150);

//	   startGameExitBtn.setPrefWidth(150);

	   // store
	   
	   storeBtn.setPrefWidth(150);
	   manageLoadoutBtn.setPrefWidth(150);
//	   storeExitBtn.setPrefWidth(150);
//	   buyGun.setPrefWidth(150);
//	   buyGun.setPrefHeight(80);
//	   buyShield.setPrefWidth(150);
//	   buyShield.setPrefHeight(80);
//	   buyItem.setPrefWidth(150);
//	   buyItem.setPrefHeight(80);
//	   storeTitleLbl.setPrefWidth(450);
	}
	 
	// sets handler
	public void attachCode() {
	   //have each button run changeScreens when clicked
	   settingBtn.setOnAction(changeScreens);
	   startGameBtn.setOnAction(changeScreens);
	   leaderboardExitBtn.setOnAction(changeScreens);
	   settingsExitBtn.setOnAction(changeScreens);
//	   storeExitBtn.setOnAction(changeScreens);
//	   startGameExitBtn.setOnAction(changeScreens);
	   storeBtn.setOnAction(changeScreens);
	   leaderboardBtn.setOnAction(changeScreens);
	   manageLoadoutBtn.setOnAction(changeScreens);
	   
	   // have each button run changeLeaderboardRegion when clicked
/*
	   americasRegion.setOnAction(changeLeaderboardRegions);
	   europeRegion.setOnAction(changeLeaderboardRegions);
	   asiaRegion.setOnAction(changeLeaderboardRegions);
	   oceaniaRegion.setOnAction(changeLeaderboardRegions);
	   africaRegion.setOnAction(changeLeaderboardRegions);
*/ // IMPLEMENT ... TO-DO
	}
	
	public void setUpGameStage() throws Exception {
		profile = new Profile();
		
		GameDisplay gameDisplay = new GameDisplay(profile.getLoadout(0));
		startGameScene = new Scene(gameDisplay);
		gameDisplay.setupInput(startGameScene);
	}
	
	public void setUpLeaderboardStage() {		
		lblRegions = new Label("Select Region Below");
		lblRegions.setAlignment(Pos.CENTER);
		
		Image americas = new Image("File:./../images/americasRegion.png");
		ImageView americasIM = new ImageView();
		americasIM.setFitWidth(75);
		americasIM.setFitHeight(75);
		americasIM.setImage(americas);

		Image europe = new Image("File:./../images/europeRegion.png");
		ImageView europeIM = new ImageView();
		europeIM.setFitWidth(75);
		europeIM.setFitHeight(75);
		europeIM.setImage(europe);
		
		Image africa = new Image("File:./../images/africaRegion.png");
		ImageView africaIM = new ImageView();
		africaIM.setFitWidth(75);
		africaIM.setFitHeight(75);
		africaIM.setImage(africa);
		
		Image asia = new Image("File:./../images/asiaRegion.png");
		ImageView asiaIM = new ImageView();
		asiaIM.setFitWidth(100);
		asiaIM.setFitHeight(75);
		asiaIM.setImage(asia);
		
		Image oceania = new Image("File:./../images/oceaniaRegion.png");
		ImageView oceaniaIM = new ImageView();
		oceaniaIM.setFitWidth(75);
		oceaniaIM.setFitHeight(75);
		oceaniaIM.setImage(oceania);

		americasRegion = new Button("Americas", americasIM);
		africaRegion = new Button("Africa", africaIM);
		europeRegion = new Button("Europe", europeIM);
		asiaRegion = new Button("Asia", asiaIM);
		oceaniaRegion = new Button("Oceania", oceaniaIM);
		leaderboardExitBtn = new Button("Back to Start Screen");
		
		leaderboardSceneGrid = new GridPane();
		leaderboardSceneGrid.setAlignment(Pos.CENTER);
		leaderboardSceneGrid.setHgap(10);
		leaderboardSceneGrid.setVgap(10);
		
		leaderboardSceneGrid.add(lblRegions, 2, 0);
		leaderboardSceneGrid.add(americasRegion, 0, 1);
		leaderboardSceneGrid.add(europeRegion, 1, 1);
		leaderboardSceneGrid.add(africaRegion, 2, 1);
		leaderboardSceneGrid.add(asiaRegion, 3, 1);
		leaderboardSceneGrid.add(oceaniaRegion, 4, 1);
		leaderboardSceneGrid.add(leaderboardExitBtn, 2, 5);
		
		leaderboardScene = new Scene(leaderboardSceneGrid, 1000, 800);
	}
	
	public void setUpStorePage() {		
		StoreMenu storeMenu = new StoreMenu(stage, profile); // needs to be after Profile set up
		storeMenu.attachCode(startScene);
		storeScene = new Scene(storeMenu, 1000, 800); 
	}
	public void setUpManageLoadout(){
		ManageLoadoutMenu manageLoadoutMenu = new ManageLoadoutMenu(stage, profile);
		manageLoadoutMenu.attachCode(startScene);
		manageLoadoutScene = new Scene(manageLoadoutMenu, 1000, 800); 
		
	}
	
	public void setUpStartScreen() {
		storeBtn = new Button("Store");
		startGameBtn = new Button("Start Game");
		leaderboardBtn = new Button("View Leaderboard");
		settingBtn = new Button("Settings");
		manageLoadoutBtn = new Button("Manage Loadout");

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
		startSceneGrid.add(storeBtn, 1, 1);
		startSceneGrid.add(startGameBtn, 0, 1);
		startSceneGrid.add(settingBtn, 1, 2);
		startSceneGrid.add(leaderboardBtn, 2, 1);
		startSceneGrid.add(manageLoadoutBtn, 2, 2);
		
		startScene = new Scene(startSceneGrid, 1000, 800);
	}
	
	public void setUpSettingPage() {
		lblSetting = new Label("Settings");
		lblSetting.setAlignment(Pos.CENTER);
		
		Image account = new Image("File:./../images/account.png");
		ImageView accountIM = new ImageView();
		accountIM.setFitWidth(60);
		accountIM.setFitHeight(60);
		accountIM.setImage(account);
		
		Image tbd1 = new Image("File:./../images/tbd1.png");
		ImageView tbd1IM = new ImageView();
		tbd1IM.setFitWidth(60);
		tbd1IM.setFitHeight(60);
		tbd1IM.setImage(tbd1);
		
		Image tbd2 = new Image("File:./../images/tbd2.png");
		ImageView tbd2IM = new ImageView();
		tbd2IM.setFitWidth(60);
		tbd2IM.setFitHeight(60);
		tbd2IM.setImage(tbd2);
		
		accountBtn = new Button("My Account", accountIM);
		tbd1Btn = new Button("tbd1", tbd1IM);
		tbd2Btn = new Button("tbd2", tbd2IM);
		settingsExitBtn = new Button("Back to Start Screen");
		
		settingSceneGrid = new GridPane(); 
		settingSceneGrid.setAlignment(Pos.CENTER);
		settingSceneGrid.setHgap(10);
		settingSceneGrid.setVgap(10);
		
		settingSceneGrid.add(lblSetting, 1, 0);
		settingSceneGrid.add(accountBtn, 0, 1);
		settingSceneGrid.add(tbd1Btn, 1, 1);
		settingSceneGrid.add(tbd2Btn, 2, 1);
		settingSceneGrid.add(settingsExitBtn, 1,4);
		
		settingScene = new Scene(settingSceneGrid, 1000, 800);
	}
	
	public void playMusic(String musicFile) {
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	@Override 
	public void start(Stage stagep) throws Exception {
//		String musicFile = "./music/GearworksFactory.mp3";     // For example
		//playMusic("./music/GearworksFactory.mp3");
		playMusic("./music/GearworksFactory.mp3");

		
		stage = stagep;
		stagep.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				Platform.exit();
				System.exit(0);
			}
			
		});
		setUpStartScreen();
		setUpSettingPage();
		setUpGameStage();
		setUpStorePage();
		setUpManageLoadout();
		setUpLeaderboardStage();

		setWidths();
		attachCode();
		 
		stage.setScene(startScene);
		stage.setTitle("COPX");
		stage.show();
	}
}
