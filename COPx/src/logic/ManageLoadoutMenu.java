package logic;


import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import javafx.geometry.Insets;

public class ManageLoadoutMenu extends Scene {
	static GridPane grid = new GridPane();
	
	Label manageLoadoutLbl;
	
	Label lblTower1;
	Label lblTower2;
	Label lblTower3;
	Label lblTower4;
	
	Button manageLoadoutExitBtn; 
	Button menuBtn;
	
	GridPane manageLoadoutSceneGrid;
	List <Button> buttons;
	
	Stage stage;
	Scene startScene;
	
	Profile userAccount;
	
	Profile profile;
	List<String> storeItems;
	
	ChoiceBox<String> choiceBox1;
	ChoiceBox<String> choiceBox2;
	ChoiceBox<String> choiceBox3;
	ChoiceBox<String> choiceBox4;
	
	public ManageLoadoutMenu(Stage pStage, Profile user, int  dimsW, int dimsH) 
	{
		super(grid,  dimsW, dimsH);
		stage = pStage;
		profile = user;
		
		menuBtn = new Button("Choose Combo");
		
		manageLoadoutLbl = new Label("Manage Loadout");
		manageLoadoutLbl.setAlignment(Pos.CENTER);
		
		manageLoadoutExitBtn = new Button("Back to Start Screen");
		
		lblTower1 = new Label("Tower 1");
		lblTower2 = new Label("Tower 2");
		lblTower3 = new Label("Tower 3");
		lblTower4 = new Label("Tower 4");
		
		
		lblTower1.setPadding(new Insets(30,30,0,30));
		lblTower2.setPadding(new Insets(30,30,0,30));
		lblTower3.setPadding(new Insets(30,30,0,30));
		lblTower4.setPadding(new Insets(30,30,0,30));
	
		refreshInventory();
		
		ChoiceBox<String> loadoutMenu = new ChoiceBox<>();
		loadoutMenu.getItems().add("Select Loadout");
		loadoutMenu.getItems().addAll("Loadout 1", "Loadout 2", "Loadout 3");
		loadoutMenu.setValue("Select Loadout");
		
        this.setWidths();
		
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10); 

		grid.add(manageLoadoutLbl, 0, 0, 4, 10);
		grid.add(manageLoadoutExitBtn, 0, 40, 4, 1);

		grid.add(lblTower1, 0, 30);
		grid.add(lblTower2, 1, 30);
		grid.add(lblTower3, 2, 30);
		grid.add(lblTower4, 3, 30);
		
		
		grid.add(loadoutMenu, 0, 10, 4, 7);
		
	}
	
	EventHandler<ActionEvent> changeScreens = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) { 
			if (e.getSource() == manageLoadoutExitBtn) {
				stage.setScene(startScene);
				return;
			}
		}
	};

	
	public void attachCode(Scene startScreen) {
		startScene = startScreen;
		manageLoadoutExitBtn.setOnAction(changeScreens);
	}
	
	private void setWidths() {
		manageLoadoutExitBtn.setPrefWidth(150);
		manageLoadoutLbl.setPrefWidth(470);
	}
	
	public void refreshInventory () {
		
		List<String> current = profile.getInventory().listTowerInventory();
		current.add(s);

		refreshChoice1(current);
		refreshChoice2(current);
		refreshChoice3(current);
		refreshChoice4(current);
		
		grid.add(choiceBox1, 0, 31);
		grid.add(choiceBox2, 1, 31);
		grid.add(choiceBox3, 2, 31);
		grid.add(choiceBox4, 3, 31);
	}
	String s = "Select";
	private void refreshChoice1(List<String> current) {
		choiceBox1 = new ChoiceBox<>();
		choiceBox1.getItems().addAll(current);
		choiceBox1.setValue(s);
	}
	
	private void refreshChoice2( List<String> current ) {		
		choiceBox2 = new ChoiceBox<>();
		choiceBox2.getItems().addAll(current);
		choiceBox2.setValue(s);
	}
	
	private void refreshChoice3(List<String> current) {
		choiceBox3 = new ChoiceBox<>();
		choiceBox3.getItems().addAll(current);
		choiceBox3.setValue(s);
	}
	
	private void refreshChoice4(List<String> current) {
		choiceBox4 = new ChoiceBox<>();
		choiceBox4.getItems().addAll(current);
		choiceBox4.setValue(s);
	}

}
