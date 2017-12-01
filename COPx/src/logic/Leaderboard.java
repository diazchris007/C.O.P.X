package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Leaderboard extends GridPane{

	Label lblRegions;
	Label lblAmerica;
	Label lblEurope;
	Label lblAsia;
	
	Button exitBtnPlayGame;
	
	Scene startScene;
	
	Stage currentStage;
	
	EventHandler<ActionEvent> changeScreens = new EventHandler<ActionEvent>(){
		// handles all events
		public void handle(ActionEvent e) {
			
			if (e.getSource() == exitBtnPlayGame) {
				currentStage.setScene(startScene);
				return;
			}
		}
	};
	
	public Leaderboard() {
		exitBtnPlayGame = new Button("Back to Start Screen");

		
		lblRegions = new Label("Select Region Below");
		lblRegions.setAlignment(Pos.CENTER);
		
		lblAmerica = new Label("America");
		lblAmerica.setAlignment(Pos.CENTER);
		
		lblEurope = new Label("Europe");
		lblEurope.setAlignment(Pos.CENTER);
		
		lblAsia = new Label("Asia");
		lblAsia.setAlignment(Pos.CENTER);
		
		this.setAlignment(Pos.CENTER);
		
		this.setHgap(10);
		this.setVgap(10);
		
		this.add(lblRegions, 0, 0);
		this.add(lblAmerica, 2, 2);
		this.add(lblEurope, 4, 2);
		this.add(lblAsia, 6, 2);
		this.add(exitBtnPlayGame, 0, 25);
	}
	
	public void attachCode(Stage stage) {
		currentStage = stage;
		   exitBtnPlayGame.setOnAction(changeScreens);

	}
	
	public void setStartScene(Scene start) {
		startScene = start;
	}
	
	public void setWidth() {
		   lblRegions.setPrefWidth(150);
		   exitBtnPlayGame.setPrefWidth(150);
	}

}
