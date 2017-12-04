package logic;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.Slider;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StartMenu extends Application {
	int dimsW = 1000;
	int dimsH = 600;
	
	// buttons
	Button settingBtn;
	Button startGameBtn;
	Button settingsExitBtn;
	Button leaderboardBtn;
	Button storeBtn;
	Button accountBtn;
	Button tbd1Btn;
	
	Button manageLoadoutBtn;
	
	// scenes
	Scene settingScene;
	Scene startGameScene;
	Scene startScene;
	Scene leaderboardScene;
	Scene storeScene;
	Scene manageLoadoutScene;
	
	// stage
	Stage stage;
	
	// grid panes
	GridPane settingSceneGrid;
	GridPane storeGrid;
	GridPane startSceneGrid;
	GridPane leaderboardSceneGrid;
	
	// labels
	Label lblSetting;
	
	Profile profile;
	EventHandlerChangeScreenStart changeScreens;

	public static void main( String[] args) {
		launch(args);
	}
	
	private void setWidths() {
	   startGameBtn.setPrefWidth(150);

	   // leaderboard
	   leaderboardBtn.setPrefWidth(150);
	   
	   // settings
	   lblSetting.setPrefWidth(150);
	   settingBtn.setPrefWidth(150);
	   settingsExitBtn.setPrefWidth(150);

	   // store
	   storeBtn.setPrefWidth(150);
	   
	   // loadout
	   manageLoadoutBtn.setPrefWidth(150);

	}
	
	// sets handler
	public void attachCode() {
	   //have each button run changeScreens when clicked
	   settingBtn.setOnAction(changeScreens);
	   startGameBtn.setOnAction(changeScreens);
	   settingsExitBtn.setOnAction(changeScreens);
	   storeBtn.setOnAction(changeScreens);
	   leaderboardBtn.setOnAction(changeScreens);
	   manageLoadoutBtn.setOnAction(changeScreens);
	}
	
	public void setUpGameStage() {
		profile = new Profile();
		
		GameDisplay gameDisplay = new GameDisplay(profile.getLoadout(0), this);
		startGameScene = new Scene(gameDisplay);
		gameDisplay.setupInput(startGameScene);
	}
	
	public void setUpLeaderboard() {		
		Leaderboard leaderboard = new Leaderboard(stage);
		leaderboard.attachCode(startScene);
		
		leaderboardScene = new Scene(leaderboard, dimsW, dimsH);
		
		leaderboard.pushLeaderboardScene(leaderboardScene);
	}
	
	public void setUpStorePage() {		
		StoreMenu storeMenu = new StoreMenu(stage, profile, dimsW, dimsH); // needs to be after Profile set up
		storeMenu.attachCode(startScene);

    	storeScene = storeMenu;
	}
	public void setUpManageLoadout(){
		ManageLoadoutMenu manageLoadoutMenu = new ManageLoadoutMenu(stage, profile,  dimsW, dimsH);
		manageLoadoutMenu.attachCode(startScene);
				
		manageLoadoutScene = manageLoadoutMenu;
		
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
		
		startSceneGrid.add(pic, 0, 0, 4, 1 );
		startSceneGrid.add(storeBtn, 1, 1);
		startSceneGrid.add(startGameBtn, 0, 1);
		startSceneGrid.add(settingBtn, 1, 2);
		startSceneGrid.add(leaderboardBtn, 2, 1);
		startSceneGrid.add(manageLoadoutBtn, 2, 2);
		
		startScene = new Scene(startSceneGrid, dimsW, dimsH);
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
		settingsExitBtn = new Button("Back to Start Screen");
		
		settingSceneGrid = new GridPane(); 
		settingSceneGrid.setAlignment(Pos.CENTER);
		settingSceneGrid.setHgap(10);
		settingSceneGrid.setVgap(10);
		
		settingSceneGrid.add(lblSetting, 1, 0);
		settingSceneGrid.add(accountBtn, 0, 1);
		settingSceneGrid.add(tbd1Btn, 1, 1);
		settingSceneGrid.add(settingsExitBtn, 1,4);
		
		HBox mediaBar = new HBox();
		// Add the volume label
		Label volumeLabel = new Label("Vol: ");
		mediaBar.getChildren().add(volumeLabel);
		
		// Add Volume slider
		Slider volumeSlider = new Slider();        
		volumeSlider.setPrefWidth(70);
		volumeSlider.setMaxWidth(Region.USE_PREF_SIZE);
		volumeSlider.setMinWidth(30);
		volumeSlider.setValue(20/2);
		mediaPlayer.setVolume(volumeSlider.getValue() / 100.0);
		
		volumeSlider.valueProperty().addListener(new EventHandlerListenerMainVolume(volumeSlider, mediaPlayer));
		mediaBar.getChildren().add(volumeSlider);
		settingSceneGrid.add(mediaBar, 1, 5);
		settingScene = new Scene(settingSceneGrid, dimsW, dimsH);
	}
	
	MediaPlayer mediaPlayer;
	public void playMusic(String musicFile) {
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	@Override 
	public void start(Stage stagep) throws Exception {
		
		if(System.getProperty("os.name").contains("w")){
			playMusic("File:./../music/GearworksFactory.mp3");
		}
		else{
			playMusic("./../music/GearworksFactory.mp3");
		}
		stage = stagep;
		stagep.setOnCloseRequest(new EventHandlerExitApp());
		
		setUpStartScreen();
		setUpSettingPage();
		setUpGameStage();
		setUpStorePage();
		setUpLeaderboard();
		setUpManageLoadout();
		
		changeScreens = new EventHandlerChangeScreenStart();
		setUpEventHandler();
		
		setWidths();
		attachCode();
		
		stage.setScene(startScene);
		stage.setTitle("COPX");
		stage.show();
	}
	
	public void setStartScene() {
		
		stage.setScene(startScene);
		setUpGameStage();
		// catch when needed?
	}
	
	public void restartGame() {
		setUpGameStage();
		stage.setScene(startGameScene);
		// catch when needed?
	}
	
	public void setUpEventHandler() {
		changeScreens.setUpSettingEvent( settingBtn, settingScene );
		changeScreens.setUpStartGameEvent( startGameBtn,  startGameScene );
		changeScreens.setUpLeaderboardEvent( leaderboardBtn,  leaderboardScene );
		changeScreens.setUpStoreEvent(storeBtn ,  storeScene );
		changeScreens.setUpManageLoadoutEvent(manageLoadoutBtn ,  manageLoadoutScene );
		changeScreens.setUpSettingExitEvent(settingsExitBtn, startScene );
	}
	class EventHandlerChangeScreenStart implements EventHandler<ActionEvent>{
		
		
		
		
		
		public void playMusic(String musicFile) {
			Media sound = new Media(new File(musicFile).toURI().toString());
			mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		}
		
		
		public void handle(ActionEvent e) {
			if (e.getSource() == settingBtn) {
				stage.setScene(settingScene);
				return;
			}
			if (e.getSource() == startGameBtn) {
				
				mediaPlayer.stop();
				if(System.getProperty("os.name").contains("w")){
					playMusic("File:./../music/Replicant_Police.mp3");
					stage.setScene(startGameScene);
				}
				else{
					playMusic("./../music/Replicant_Police.mp3");
					stage.setScene(startGameScene);
				}
				
				
				
				return;
			}
			if (e.getSource() == settingsExitBtn) {
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
				((ManageLoadoutMenu) manageLoadoutScene).refreshInventory();
				stage.setScene(manageLoadoutScene);
				return;
			}
		}
		
		public void setUpSettingEvent(Button btn, Scene setting ) {
			settingBtn = btn;
			settingScene = setting;
		}
		
		public void setUpStartGameEvent(Button btn, Scene scene ) {
			startGameBtn = btn;
			startGameScene = scene;
		}

		public void setUpLeaderboardEvent(Button btn, Scene scene ) {
			leaderboardBtn = btn;
			leaderboardScene = scene;
		}
		
		public void setUpStoreEvent(Button btn, Scene scene ) {
			storeBtn = btn;
			storeScene = scene;
		}
		
		public void setUpManageLoadoutEvent(Button btn, Scene scene ) {
			manageLoadoutBtn = btn;
			manageLoadoutScene = scene;
		}

		public void setUpSettingExitEvent(Button btn, Scene scene ) {
			settingsExitBtn = btn;
			startScene = scene;
		}
		
	}
}
