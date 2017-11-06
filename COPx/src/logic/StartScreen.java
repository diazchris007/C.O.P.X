package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartScreen extends GridPane{
	Button settingBtn;
	Button startGameBtn;
	Button leaderboardBtn;
	Button storeBtn;
	
	Scene settingScene;
	Scene startGameScene;
	Scene leaderboardScene;
	Scene startStoreScene;
	Scene startScene;
	Scene storeScene;
	
	Stage stPointer;
	EventHandler<ActionEvent> changeScreens = new EventHandler<ActionEvent>(){
		// handles all events
		public void handle(ActionEvent e) {
			
			if (e.getSource() == settingBtn) {
				stPointer.setScene(settingScene);
				return;
			}
			if (e.getSource() == startGameBtn) {
				stPointer.setScene(startGameScene);
				
				return;
			}
			if (e.getSource() == leaderboardBtn) {
				stPointer.setScene(leaderboardScene);
				return;
			}
			if (e.getSource() == storeBtn) {
				stPointer.setScene(storeScene);
				return;
			}
		}
	};
	
	public void setUpEventHandler (Stage currentStage) {
		stPointer = currentStage;
	   settingBtn.setOnAction(changeScreens);
	   startGameBtn.setOnAction(changeScreens);
	   leaderboardBtn.setOnAction(changeScreens);
	   storeBtn.setOnAction(changeScreens);
	}
	
	public void setUpSettingBtn(Scene setting) {
		settingScene = setting;
	}
	
	public void setUpStartGameBtn(Scene startGame) {
		startGameScene = startGame;
	}
	
	public void setUpLeaderBoardBtn(Scene leaderBoard) {
		leaderboardScene = leaderBoard;
	}
	
	public void setUpStoreBtn(Scene store) {
		storeScene = store;
	}
	
	public void setUpWidth() {
	   settingBtn.setPrefWidth(70);
	   startGameBtn.setPrefWidth(150);
	   leaderboardBtn.setPrefWidth(150);
	   storeBtn.setPrefWidth(150);  
	}

	public StartScreen() {
		storeBtn = new Button("Store (to buy stuff)");
		startGameBtn = new Button("Start Game");
		leaderboardBtn = new Button("View Leaderboard");
		settingBtn = new Button("Settings");

		Image logo = new Image("File:./../images/COPX_logo.png");
		ImageView pic = new ImageView();
		pic.setFitWidth(260);
		pic.setFitHeight(130);
		pic.setImage(logo);
		this.add(pic, 0,0, 4, 1 );
		
		this.add(settingBtn, 1, 1);
		this.add(startGameBtn, 0,1);
		this.add(storeBtn, 0, 2);

		this.add(leaderboardBtn, 2, 1);
		        
        this.setAlignment(Pos.CENTER);
		
		this.setHgap(10);
		this.setVgap(10);
	}
	
}
