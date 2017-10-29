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
	Scene settingScene;
	Scene startGameScene;
	Scene startScene;
	Stage stage;
	
	
	
	Label lbl_Setting;
	Label lblLoading;
	
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
		}
	};

	public static void main( String[] args) {
		launch(args);
	}
	
	private void setWidths() {
	   settingBtn.setPrefWidth(70);
	   btnStartGameBtn.setPrefWidth(150);
	   
	   exitBtn_PlayGame.setPrefWidth(150);
		
	   btnClear.setPrefWidth(150);
	   lblLoading.setPrefWidth(150);
	   lbl_Setting.setPrefWidth(150);
	}
	 
	// sets handler
	public void attachCode() {
	   //have each button run BTNCODE when clicked
	   settingBtn.setOnAction(changeScreens);
	   btnStartGameBtn.setOnAction(changeScreens);
	   exitBtn_PlayGame.setOnAction(changeScreens);

	   btnClear.setOnAction(changeScreens);
	}
	
	
	
	@Override 
	public void start(Stage stagep) throws Exception {
		stage = stagep;
		btnClear = new Button("Clear");
		
		lblLoading = new Label("Loading...");
		lblLoading.setAlignment(Pos.CENTER);
		
		lbl_Setting = new Label("Settings:");
		lbl_Setting.setAlignment(Pos.CENTER);

		settingBtn = new Button("Settings");
		btnStartGameBtn = new Button("Start Game");
		exitBtn_PlayGame = new Button("Back to Start Screen");
		
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


		
		GridPane settingSceneGrid = new GridPane(); 
		settingSceneGrid.setAlignment(Pos.CENTER);
		
		settingSceneGrid.setHgap(10);
		settingSceneGrid.setVgap(10);
		
		settingSceneGrid.add(lbl_Setting, 0, 0);
		settingSceneGrid.add(btnClear , 0,1);

		
		GridPane startGameSceneGrid = new GridPane(); 
		startGameSceneGrid.setAlignment(Pos.CENTER);
		
		startGameSceneGrid.setHgap(10);
		startGameSceneGrid.setVgap(10);
		
		// elements can only be added to one grid at a time
		//startGameSceneGrid.add(pic, 0,0);
		startGameSceneGrid.add(lblLoading, 0, 0);
		startGameSceneGrid.add(exitBtn_PlayGame, 0, 1);


		setWidths();
		attachCode();
		
		startScene = new Scene(startSceneGrid, 1000, 800);
		settingScene = new Scene(settingSceneGrid, 1000, 800);
		startGameScene = new Scene(startGameSceneGrid, 1000, 800);
		 
		stage.setScene(startScene);
		stage.setTitle("COPX");
		stage.show();

	}
}
