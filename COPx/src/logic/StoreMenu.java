package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class StoreMenu extends GridPane{
	Label storeTitleLbl;
	Label balanceDisplay;
	Label msg;
	
	Button buyGun;
	Button buyShield;
	Button buyItem;
	Button storeExitBtn;
	
	List <Button> buttons;
	
	Stage stage;
	Scene startScene;
	
	Profile userAccount;
	
	Inventory storeInventory;
	List<String> storeItems;
	
	public StoreMenu(Stage pStage, Profile user) {
		stage = pStage;
		userAccount = user;
		
		storeItems = Arrays.asList("sword1", "sword2", "sword3", "sword4", "sword5", "sword2", "sword3");
		storeInventory = new Inventory(storeItems);
		
		buttons = new ArrayList<Button>();
		for (int i = 0; i< storeInventory.getItemNum(); i++) {
			String lbl = "Buy " + storeInventory.getItem(i).getName() + "\n Price: " + storeInventory.getItem(i).getPrice();
			Image img = storeInventory.getItem(i).getIcon();
			ImageView icon = new ImageView();
			icon.setFitWidth(40);
			icon.setFitHeight(40);
			icon.setImage(img);
			
			buttons.add( new Button( lbl, icon ));
		}
		
		balanceDisplay = new Label ("Current Balance: " + userAccount.getBalance());
		balanceDisplay.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
		
		msg = new Label ("Hello!!");
		msg.setAlignment(Pos.CENTER);
		
		storeTitleLbl = new Label("Welcome to the store");
		storeTitleLbl.setAlignment(Pos.CENTER);
		
		Image gun = new Image("File:./../images/gunIcon.png");
		ImageView gunIM = new ImageView();
		gunIM.setFitWidth(50);
		gunIM.setFitHeight(40);
		gunIM.setImage(gun);
		
		Image shield = new Image("File:./../images/shieldIcon.png");
		ImageView shieldIM = new ImageView();
		shieldIM.setFitWidth(50);
		shieldIM.setFitHeight(40);
		shieldIM.setImage(shield);
		
		buyGun = new Button("Buy Gun", gunIM);
		buyShield = new Button("Buy Shield", shieldIM);
		buyItem = new Button("Buy Item");
		storeExitBtn = new Button("Back to Start Screen");
		
		this.setWidths();
		
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		
		this.add(storeTitleLbl, 0, 0, 3, 1);
		this.add(msg, 0, 1, 3, 1);
		this.add(balanceDisplay, 0, 2, 3, 1);
		
		int j=2;
		for (int i = 0; i < storeInventory.getItemNum(); i++) {
			if (i %3  == 0)
				j++;	
			
			this.add(buttons.get(i), i%3, j);
		}

		this.add(storeExitBtn, 1,  storeInventory.getItemNum()/3 +6);
		
	}
	
	EventHandler<ActionEvent> changeScreens = new EventHandler<ActionEvent>() {
		// handles all events
		public void handle(ActionEvent e) {
			if (e.getSource() == storeExitBtn) {
				stage.setScene(startScene);
				return;
			}

		}
	};
	
	EventHandler<ActionEvent> purchaseItem = new EventHandler<ActionEvent>() {
		// handles all events
		public void handle(ActionEvent e) {
			if (e.getSource() == buyGun) {
				userAccount.purchaseItem("Sword1");
				balanceDisplay.setText("Current Balance: " + userAccount.getBalance());
				return;
			}

			if (e.getSource() == buyShield) {
				userAccount.purchaseItem("Sword2");
				balanceDisplay.setText("Current Balance: " + userAccount.getBalance());
				return;
			}
			
			int stat = -1;
			for (int i = 0; i < storeInventory.getItemNum(); i++) {
				if (e.getSource() == buttons.get(i)) {
					stat = userAccount.purchaseItem(  storeInventory.getItem(i).getName() );
					balanceDisplay.setText("Current Balance: " + userAccount.getBalance());
					if (stat == 0) // bought
						msg.setText("You just purchased " + storeInventory.getItem(i).getName());
					else
						msg.setText("You did not have enough for " + storeInventory.getItem(i).getName());
					return;
				}
			}	
		}
	};
	
	public void attachCode(Scene startScreen) {
		startScene = startScreen;
		storeExitBtn.setOnAction(changeScreens);
		buyGun.setOnAction(purchaseItem);
		buyShield.setOnAction(purchaseItem);
		
	   for (int i =0 ; i < storeInventory.getItemNum(); i++) {
		   buttons.get(i).setOnAction(purchaseItem);
	   }
	}
	
	private void setWidths() {
	   storeExitBtn.setPrefWidth(150);
	   buyGun.setPrefWidth(150);
	   buyGun.setPrefHeight(80);
	   buyShield.setPrefWidth(150);
	   buyShield.setPrefHeight(80);
	   buyItem.setPrefWidth(150);
	   buyItem.setPrefHeight(80);
	   storeTitleLbl.setPrefWidth(470);
	   balanceDisplay.setPrefWidth(200);
	   msg.setPrefWidth(470);
	   
	   for (int i =0 ; i < storeInventory.getItemNum(); i++) {
		   buttons.get(i).setPrefWidth(150);
		   buttons.get(i).setPrefHeight(80);
	   }
	   
	}

}
