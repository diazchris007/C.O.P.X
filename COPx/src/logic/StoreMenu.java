package logic;

import java.util.ArrayList;
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

public class StoreMenu extends GridPane{
	Label storeTitleLbl;
	Label balanceDisplay;
	Label msg;
	
	Button storeExitBtn;
	
	List <Button> buttons;
	
	Stage stage;
	Scene startScene;
	
	Profile userAccount;
	
	Inventory storeInventory;
	List<String> storeItems;
	List<String> storeWeapons;
	List<String> storeTowers;
	
	ListView<String> userInvViewer;
    ListView<String> itemList;
    ListView<String> weaponList;
    ListView<String> towerList;
	
	private static final int ITEM = 0;
	private static final int WEAPON = 1;
	private static final int TOWER = 2;
	
		
	private void intializeStoreInv() {
		storeItems = Arrays.asList( "shield", "green Potion", "charge Potion", "HP Potion", "Mana potion", "sword5");
		storeWeapons = Arrays.asList("sword1", "rocket Launcher", "sword2", "staff", "mace", "rifle");
		storeTowers = Arrays.asList("rifle Tower", "rocket Tower", "Blast Tower", "Heavy Tower", "Swat Tower", "Self Destruct Tower");

		storeInventory = new Inventory(storeItems, storeWeapons, storeTowers);
	}
	
	private void initializeButtons() {
		buttons = new ArrayList<>();
		String lbl; 
		Image img;
		ImageView icon;
		String p = "\n Price: ";
		for (int i = 0; i< storeInventory.getItemNum(); i++) {
			lbl = "Buy " + storeInventory.getItem(i).getName() + p + storeInventory.getItem(i).getPrice();
			img = storeInventory.getItem(i).getIcon();
			icon = new ImageView();
			icon.setFitWidth(40);
			icon.setFitHeight(40);
			icon.setImage(img);
			
			buttons.add( new Button( lbl, icon ));
		}
		
		for (int i = 0; i< storeInventory.getWeaponNum(); i++) {
			lbl = "Buy " + storeInventory.getWeapon(i).getName() + p + storeInventory.getWeapon(i).getPrice();
			img = storeInventory.getWeapon(i).getIcon();
			icon = new ImageView();
			icon.setFitWidth(40);
			icon.setFitHeight(40);
			icon.setImage(img);
			
			buttons.add( new Button( lbl, icon ));
		}
		
		for (int i = 0; i< storeInventory.getTowerNum(); i++) {
			lbl = "Buy " + storeInventory.getTower(i).getName() + p + storeInventory.getTower(i).getPrice();
			img = storeInventory.getTower(i).getIcon();
			icon = new ImageView();
			icon.setFitWidth(40);
			icon.setFitHeight(40);
			icon.setImage(img);
			
			buttons.add( new Button( lbl, icon ));
		}
	}
	
	public StoreMenu(Stage pStage, Profile user) {		
		stage = pStage;
		userAccount = user;
		
		intializeStoreInv();
		initializeButtons();
		
		balanceDisplay = new Label ("Current Balance: " + userAccount.getBalance());
		balanceDisplay.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
		
		msg = new Label ("Hello!! What would you like to purchase?");
		msg.setAlignment(Pos.CENTER);
		
		storeTitleLbl = new Label("Welcome to the store");
		storeTitleLbl.setAlignment(Pos.CENTER);
				
		storeExitBtn = new Button("Back to Start Screen");
		
		this.setWidths();
		
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		
		this.add(storeTitleLbl, 0, 0, 3, 1);
		this.add(msg, 0, 1, 3, 1);
		this.add(balanceDisplay, 0, 2, 3, 1);
		
		int j=3;
		int numInv = storeInventory.getInventoryNum();
		
		Label itemLbl = new Label("Items:");
		Label weaponLbl = new Label("Weapons:");
		Label towerLbl = new Label("Towers:");
		this.add(itemLbl, 0, 3, 3, 1);
		
		for (int i = 0; i < numInv; i++) {
			if (i %2  == 0)
				j++;	
			
			if (i == storeInventory.getItemNum()) {	
				j++;
				this.add(weaponLbl, 0, j++, 3, 1);
			} else if (i == (storeInventory.getItemNum() + storeInventory.getWeaponNum())) {
				j++;
				this.add(towerLbl, 0, j++, 3, 1);
			}
			this.add(buttons.get(i), i%2, j);
		}
		
		j+=2;
		this.add(storeExitBtn, 0,  j);
		setUpDisplayInv();
	}
	
	
	private void refreshInvList(int catergory) {
		if (catergory == ITEM) {
			itemList.getItems().removeAll(itemList.getItems());
			itemList.getItems().addAll( userAccount.getInventory().listItemInventory());
		} else if (catergory == WEAPON) {
			weaponList.getItems().removeAll(weaponList.getItems());
			weaponList.getItems().addAll(userAccount.getInventory().listWeaponInventory());
		} else if (catergory == TOWER) {
			towerList.getItems().removeAll(towerList.getItems());
			towerList.getItems().addAll(userAccount.getInventory().listTowerInventory());
		}
	}
	
	private void setUpDisplayInv() {
		Label i = new Label("Items in Inventory:");
		Label w = new Label("Weapons in Inventory:");
		Label t = new Label("Towers in Inventory:");
		
        itemList = setListView( userAccount.getInventory().listItemInventory(), ITEM );
        itemList.setPrefHeight(250);
	
        weaponList = setListView( userAccount.getInventory().listWeaponInventory(), WEAPON );
        	weaponList.setPrefHeight(250);
        	
        towerList = setListView( userAccount.getInventory().listTowerInventory(), TOWER );
        towerList.setPrefHeight(250);
        
        
        VBox iVbox = new VBox(i, itemList);
        VBox wVbox = new VBox(w, weaponList);
        VBox tVbox = new VBox(t, towerList);
        
        this.add(iVbox, 2, 4, 3, 3);
        this.add(wVbox, 2, 9, 3, 3);
        this.add(tVbox, 2, 14, 3, 3);
	}
	


	
	public ListView<String> setListView(List<String> listCategory, int category) {		
		ObservableList<String> items = FXCollections.observableArrayList(listCategory);
		
        ListView<String> list = new ListView<>(items);
        list.setCellFactory(TextFieldListCell.forListView());
        if (category == ITEM) {
        		list.setCellFactory(param -> new ListCellItems());
        } else if (category == WEAPON) {
        		list.setCellFactory(param -> new ListCellWeapons());
        } else if (category == TOWER) {
    			list.setCellFactory(param -> new ListCellTowers());
        }
        
        list.setEditable(true);
        return list;
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
			int stat = -1;
			String s1 = "You just purchased ";
			String s2 = "You did not have enough for ";
			String s3 = "Current Balance: ";
			String s4 = "You already have ";

			
			for (int i = 0; i < storeInventory.getInventoryNum(); i++) {
				
				if (e.getSource() == buttons.get(i)) {
					int objectType = storeInventory.getIWT(i);
					
					if (objectType == ITEM ) {
						int itemNum = i;
						
						if (userAccount.itemInInv(storeInventory.getItem(itemNum).getName()))
							msg.setText(s4 + storeInventory.getItem(itemNum).getName());
						else {
							stat = userAccount.purchaseItem(  storeInventory.getItem(itemNum) );
							balanceDisplay.setText(s3 + userAccount.getBalance());
							if (stat == 0) // bought
								msg.setText(s1 + storeInventory.getItem(itemNum).getName());
							else
								msg.setText(s2 + storeInventory.getItem(itemNum).getName());							
						}

					} else if (objectType == WEAPON) {
						int weaponNum = i - storeInventory.getWeaponNum();

						if (userAccount.weaponInInv(storeInventory.getWeapon(weaponNum).getName()))
							msg.setText(s4 + storeInventory.getWeapon(weaponNum).getName());
						else {
							stat = userAccount.purchaseWeapon(  storeInventory.getWeapon(weaponNum) );
							balanceDisplay.setText(s3 + userAccount.getBalance());
							if (stat == 0) // bought
								msg.setText(s1 + storeInventory.getWeapon(weaponNum).getName());
							else
								msg.setText(s2 + storeInventory.getWeapon(weaponNum).getName());
						}
					} else if (objectType == TOWER) {
						int towerNum = i - storeInventory.getWeaponNum() - storeInventory.getItemNum();
						
						if (userAccount.towerInInv(storeInventory.getTower(towerNum).getName()))
							msg.setText(s4 + storeInventory.getTower(towerNum).getName());
						else {
							stat = userAccount.purchaseTower(storeInventory.getTower(towerNum) );
							balanceDisplay.setText(s3 + userAccount.getBalance());
							if (stat == 0) // bought
								msg.setText(s1 + storeInventory.getTower(towerNum ).getName());
							else
								msg.setText(s2 + storeInventory.getTower(towerNum).getName());
						}
					}
					
					refreshInvList(objectType);
					return;
				}
			}	
		}
	};
	
	public void attachCode(Scene startScreen) {
		startScene = startScreen;
		storeExitBtn.setOnAction(changeScreens);
	   for (int i = 0 ; i < storeInventory.getInventoryNum(); i++) {
		   buttons.get(i).setOnAction(purchaseItem);
	   }
	}
	
	private void setWidths() {
	   storeExitBtn.setPrefWidth(150);
	   storeTitleLbl.setPrefWidth(470);
	   balanceDisplay.setPrefWidth(200);
	   msg.setPrefWidth(470);
	   
	   for (int i =0 ; i < storeInventory.getInventoryNum(); i++) {
		   buttons.get(i).setPrefWidth(240);
		   buttons.get(i).setPrefHeight(80);
	   }
	}

}
