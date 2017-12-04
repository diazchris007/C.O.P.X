package logic;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class EventHandlerChangeScreenStart implements EventHandler<ActionEvent>{
	
	MediaPlayer mediaPlayer;
	Stage stage;
	
	Button settingBtn;
	Button startGameBtn;
	Button settingsExitBtn;
	Button storeBtn;
	Button leaderboardBtn;
	Button manageLoadoutBtn;
	
	Scene settingScene;
	Scene startGameScene;
	Scene startScene;
	Scene leaderboardScene;
	Scene storeScene;
	Scene manageLoadoutScene;
	
	public EventHandlerChangeScreenStart(MediaPlayer mp, Stage s) {
		mediaPlayer = mp;
		stage = s;
	}
	
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
			playMusic("file:./../music/Replicant_Police.mp3");
			stage.setScene(startGameScene);
			
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

