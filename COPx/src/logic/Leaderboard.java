package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Leaderboard extends GridPane{
	Label lblRegions;
	
	Button localLeaderboardBtn;
	Button globalLeaderboardBtn;
	Button leaderboardExitBtn;
	
	Scene startScene;
	Scene leaderboardScene;
	
	Stage stage;
	
	GridPane leaderboardSceneGrid;
	
	EventHandler<ActionEvent> changeScreens = new EventHandler<ActionEvent>(){
		// handles all events
		public void handle(ActionEvent e) {
			if (e.getSource() == leaderboardExitBtn) {
				stage.setScene(startScene);
				return;
			}
		}
	};
	
	public Leaderboard(Stage pStage) {
		stage = pStage;
		
		lblRegions = new Label("Select Section Below");
		lblRegions.setAlignment(Pos.CENTER);
		
		Image localLeaderboard = new Image("File:./../images/local.png");
		ImageView localLeaderboardIM = new ImageView();
		localLeaderboardIM.setFitWidth(75);
		localLeaderboardIM.setFitHeight(75);
		localLeaderboardIM.setImage(localLeaderboard);

		Image globalLeaderboard = new Image("File:./../images/global.png");
		ImageView globalLeaderboardIM = new ImageView();
		globalLeaderboardIM.setFitWidth(75);
		globalLeaderboardIM.setFitHeight(75);
		globalLeaderboardIM.setImage(globalLeaderboard);
		
		localLeaderboardBtn = new Button("Local", localLeaderboardIM);
		globalLeaderboardBtn = new Button("Global", globalLeaderboardIM);
		leaderboardExitBtn = new Button("Back to Start Screen");
		
		this.setWidth();
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		
		leaderboardSceneGrid = new GridPane();
		leaderboardSceneGrid.setAlignment(Pos.CENTER);
		leaderboardSceneGrid.setHgap(10);
		leaderboardSceneGrid.setVgap(10);

		this.add(lblRegions, 1, 0, 8, 1);

		this.add(localLeaderboardBtn, 0, 1);
		this.add(globalLeaderboardBtn, 1, 1);
		this.add(leaderboardExitBtn, 1, 5);
	}
	
	public void attachCode(Scene startScreen) {
       startScene = startScreen;
       leaderboardExitBtn.setOnAction(changeScreens);
	}
	
	public void setWidth() {
       lblRegions.setPrefWidth(150);
       leaderboardExitBtn.setPrefWidth(150);
	}

}
