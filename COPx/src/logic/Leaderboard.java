package logic;

import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Leaderboard extends GridPane{
	int dimsW = 1000;
	int dimsH = 600;
	
	Label lblLeaderboardType;
	Label lblLocalLeaderboard;
	
	Button localLeaderboardBtn;
	Button globalLeaderboardBtn;
	Button leaderboardExitBtn;
	Button localBackBtn;
	Button localMenuBtn;
	
	Scene startScene;
	Scene localLeaderboard;
	Scene leaderboardScene;
	
	Stage stage;
	
	GridPane leaderboardSceneGrid;
	GridPane localLeaderboardGrid;
	
	ListView<String> leaderboard;
	List<String> profilesAndScores = Arrays.asList("User: dfalessi\t\t\t\t\t\t\tScore: 1010", "User: lebronJames\t\t\t\t\t\tScore: 918", "User: stephCurry\t\t\t\t\t\tScore: 857", "User: leoMessi\t\t\t\t\t\t\tScore: 712", "User: stevenVong\t\t\t\t\t\tScore: 555");
	
	EventHandler<ActionEvent> changeScreens = new EventHandler<ActionEvent>(){
		// handles all events
		public void handle(ActionEvent e) {
			if (e.getSource() == leaderboardExitBtn) {
				stage.setScene(startScene);
				return;
			}
			if (e.getSource() == localLeaderboardBtn) {
				stage.setScene(localLeaderboard);
				return;
			}
			if (e.getSource() == localBackBtn) {
				stage.setScene(leaderboardScene);
				return;
			}
			if (e.getSource() == localMenuBtn) {
				stage.setScene(startScene);
				return;
			}
		}
	};
	
	public Leaderboard(Stage pStage) {
		stage = pStage;
		
		lblLeaderboardType = new Label("Select Section Below");
		lblLeaderboardType.setAlignment(Pos.CENTER);
		
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
		
		displayLocalLeaderboard();
	
        localLeaderboardBtn.setOnAction(changeScreens);
		
		this.setWidth();
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		
		leaderboardSceneGrid = new GridPane();
		leaderboardSceneGrid.setAlignment(Pos.CENTER);
		leaderboardSceneGrid.setHgap(10);
		leaderboardSceneGrid.setVgap(10);

		this.add(lblLeaderboardType, 0, 0);
		
		this.add(localLeaderboardBtn, 0, 1);
		this.add(globalLeaderboardBtn, 1, 1);
		this.add(leaderboardExitBtn, 0, 5);
	}
	
	public void displayLocalLeaderboard() {
		localLeaderboardGrid = new GridPane();
		
		localLeaderboardGrid.setAlignment(Pos.CENTER);
		localLeaderboardGrid.setHgap(10);
		localLeaderboardGrid.setVgap(10);
		
		localBackBtn = new Button("Back");
		localMenuBtn = new Button("Back to Start Screen");
		
	    localLeaderboardBtn.setPrefWidth(150);
        localBackBtn.setPrefWidth(150);
        localMenuBtn.setPrefWidth(150);
        
        localBackBtn.setOnAction(changeScreens);
        localMenuBtn.setOnAction(changeScreens);
		
		localLeaderboardGrid.add(localBackBtn, 0, 5);
		localLeaderboardGrid.add(localMenuBtn, 1, 5);
		
		setupLeaderboardTable();
		
		localLeaderboard = new Scene(localLeaderboardGrid, dimsW, dimsH);
	}
	
	public void attachCode(Scene startScreen) {
       startScene = startScreen;
       leaderboardExitBtn.setOnAction(changeScreens);
	}
	
	public void setWidth() {
       lblLeaderboardType.setPrefWidth(150);
       leaderboardExitBtn.setPrefWidth(150);
       localLeaderboardBtn.setPrefWidth(150);
	}
	
	public void pushLeaderboardScene(Scene scene) {
		leaderboardScene = scene;
	}
	
	public void setupLeaderboardTable() {
		Label LocalLeaderboard = new Label("Local Leaderboard");
		
		leaderboard = setListView(profilesAndScores);
		
		VBox pBox = new VBox(LocalLeaderboard, leaderboard);
		
		localLeaderboardGrid.add(pBox, 0, 0, 3, 3);
	}
	
	public ListView<String> setListView(List<String> listCategory) {		
		ObservableList<String> items = FXCollections.observableArrayList(listCategory);
		
        ListView<String> list = new ListView<>(items);
        list.setCellFactory(TextFieldListCell.forListView());
        
        list.setEditable(true);
        return list;
	}
}
