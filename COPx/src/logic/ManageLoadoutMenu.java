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
//import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.geometry.Insets;

public class ManageLoadoutMenu extends GridPane {

	
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
	
	Inventory playerInventory;
	List<String> storeItems;
	
	public ManageLoadoutMenu(Stage pStage, Profile user) 
	{
		stage = pStage;
		playerInventory = user.getInventory();
		
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
	
		String s = "Select";
		ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
		choiceBox1.getItems().addAll(playerInventory.listWeaponInventory());
		choiceBox1.setValue(s);
		
		
		ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
		choiceBox2.getItems().addAll("Select", "U1", "U2", "U3");
		choiceBox2.setValue(s);
		
		ChoiceBox<String> choiceBox3 = new ChoiceBox<>();
		choiceBox3.getItems().addAll("Select", "U1", "U2", "U3");
		choiceBox3.setValue(s);
		
		ChoiceBox<String> choiceBox4 = new ChoiceBox<>();
		choiceBox4.getItems().addAll("Select", "U1", "U2", "U3");
		choiceBox4.setValue(s);
		
		ChoiceBox<String> loadoutMenu = new ChoiceBox<>();
		loadoutMenu.getItems().add("Select Loadout");
		loadoutMenu.getItems().addAll("Loadout 1", "Loadout 2", "Loadout 3");
		loadoutMenu.setValue("Select Loadout");
		
        this.setWidths();
		
		this.setAlignment(Pos.TOP_CENTER);
		this.setHgap(10);
		this.setVgap(10); 
		
	    
		
		this.add(manageLoadoutLbl, 0, 0, 4, 10);
		this.add(manageLoadoutExitBtn, 0, 40, 4, 1);
		
		
		this.add(lblTower1, 0, 30);
		this.add(lblTower2, 1, 30);
		this.add(lblTower3, 2, 30);
		this.add(lblTower4, 3, 30);
		
		
		this.add(choiceBox1, 0, 31);
	    this.add(choiceBox2, 1, 31);
		this.add(choiceBox3, 2, 31);
		this.add(choiceBox4, 3, 31);
		
		this.add(loadoutMenu, 0, 10, 4, 7);
		
		
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
	
	
}
