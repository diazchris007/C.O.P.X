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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StoreMenu extends Scene {
	GridPane btnDisplay = new GridPane();
	
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
		String description = "Description: \n";
		buttons = new ArrayList<>();
		String lbl; 
		Image img;
		ImageView icon;
		String p = "\n Price: ";
		for (int i = 0; i< storeInventory.getItemNum(); i++) {
			lbl = "Buy " + storeInventory.getItem(i).getName() + p + storeInventory.getItem(i).getPrice();
			img = storeInventory.getItem(i).getIcon();
			icon = new ImageView();
			icon.setFitWidth(50);
			icon.setFitHeight(50);
			icon.setImage(img);
			
			Button temp = new Button(lbl, icon);
			temp.setTooltip(new Tooltip(description + storeInventory.getItem(i).getDescription() ));
			
			buttons.add(temp);
		}
		
		for (int i = 0; i< storeInventory.getWeaponNum(); i++) {
			lbl = "Buy " + storeInventory.getWeapon(i).getName() + p + storeInventory.getWeapon(i).getPrice();
			img = storeInventory.getWeapon(i).getIcon();
			icon = new ImageView();
			icon.setFitWidth(60);
			icon.setFitHeight(60);
			icon.setImage(img);
			
			Button temp = new Button(lbl, icon);
			temp.setTooltip(new Tooltip(description + storeInventory.getWeapon(i).getDescription() ));
			
			buttons.add( temp);
		}
		
		for (int i = 0; i< storeInventory.getTowerNum(); i++) {
			lbl = "Buy " + storeInventory.getTower(i).getName() + p + storeInventory.getTower(i).getPrice();
			img = storeInventory.getTower(i).getIcon();
			icon = new ImageView();
			icon.setFitWidth(50);
			icon.setFitHeight(50);
			icon.setImage(img);
			
			Button temp = new Button(lbl, icon);
			temp.setTooltip(new Tooltip(description + storeInventory.getTower(i).getDescription() ));

			buttons.add( temp);
		}
	}
	
	static GridPane totalDisplay = new GridPane();
	
	public StoreMenu(Stage pStage, Profile user, int dimsW, int dimsH) {	
		super(totalDisplay, dimsW, dimsH);
		
		totalDisplay.setAlignment(Pos.CENTER);
		totalDisplay.setHgap(10);
		totalDisplay.setVgap(10);
		stage = pStage;
		userAccount = user;
		
		intializeStoreInv();
		initializeButtons();
		
		
		balanceDisplay = new Label ("Current Balance: " + userAccount.getBalance());
		balanceDisplay.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
		balanceDisplay.setAlignment(Pos.CENTER);
		
		msg = new Label ("Hello!! What would you like to purchase?");
		msg.setAlignment(Pos.CENTER);
		
		storeTitleLbl = new Label("Welcome to the Store!");
		storeTitleLbl.setAlignment(Pos.CENTER);
				
		storeExitBtn = new Button("Back to Start Screen");
		storeExitBtn.setAlignment(Pos.CENTER);
		
		this.setWidths();
		
		btnDisplay.setAlignment(Pos.CENTER);
		btnDisplay.setHgap(10);
		btnDisplay.setVgap(10);
		
		totalDisplay.add(storeTitleLbl, 0, 0, 1, 1);
		totalDisplay.add(msg, 0, 1, 1, 1);
		totalDisplay.add(balanceDisplay, 0, 2, 1, 1);
		
		int j=3;
		int numInv = storeInventory.getInventoryNum();
		
		Label itemLbl = new Label("Items:");
		Label weaponLbl = new Label("Weapons:");
		Label towerLbl = new Label("Towers:");
		btnDisplay.add(itemLbl, 0, 3, 3, 1);
		
		for (int i = 0; i < numInv; i++) {
			if (i %2  == 0)
				j++;	
			
			if (i == storeInventory.getItemNum()) {	
				j++;
				btnDisplay.add(weaponLbl, 0, j++, 3, 1);
			} else if (i == (storeInventory.getItemNum() + storeInventory.getWeaponNum())) {
				j++;
				btnDisplay.add(towerLbl, 0, j++, 3, 1);
			}
			btnDisplay.add(buttons.get(i), i%2, j);
		}
		
		j+=2;
		
		setUpDisplayInv();
		
//		this.getChildren().add(grid);
		
		
		

		
        ScrollPane sp = new ScrollPane();
        sp.setContent(btnDisplay);
        sp.setFitToWidth(true);
        sp.setPrefSize(dimsW -40, dimsH - 40);
        sp.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        
        totalDisplay.add(sp, 0, 3);
        totalDisplay.add(storeExitBtn, 0,  4);
//        storeScene = new Scene(grid, dimsW, dimsH);
//        this.add(grid, columnIndex, rowIndex);
		
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
        
        btnDisplay.add(iVbox, 2, 4, 3, 3);
        btnDisplay.add(wVbox, 2, 9, 3, 3);
        btnDisplay.add(tVbox, 2, 14, 3, 3);
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
						
						if (userAccount.itemInInv(storeInventory.getItem(itemNum).getName())) {
							msg.setText(s4 + storeInventory.getItem(itemNum).getName());
							msg.setTextFill(Color.RED);
						} else {
							stat = userAccount.purchaseItem(  storeInventory.getItem(itemNum) );
							balanceDisplay.setText(s3 + userAccount.getBalance());
							if (stat == 0) {// bought
								msg.setText(s1 + storeInventory.getItem(itemNum).getName());
								msg.setTextFill(Color.BLACK);
							} else {
								msg.setText(s2 + storeInventory.getItem(itemNum).getName());
								msg.setTextFill(Color.RED);
							}
								
						}

					} else if (objectType == WEAPON) {
						int weaponNum = i - storeInventory.getWeaponNum();

						if (userAccount.weaponInInv(storeInventory.getWeapon(weaponNum).getName())) {
							msg.setText(s4 + storeInventory.getWeapon(weaponNum).getName());
							msg.setTextFill(Color.RED);
						} else {
							stat = userAccount.purchaseWeapon(  storeInventory.getWeapon(weaponNum) );
							balanceDisplay.setText(s3 + userAccount.getBalance());
							if (stat == 0) {// bought
								msg.setText(s1 + storeInventory.getWeapon(weaponNum).getName());
								msg.setTextFill(Color.BLACK);
							} else {
								msg.setText(s2 + storeInventory.getWeapon(weaponNum).getName());
								msg.setTextFill(Color.RED);
							}
								
						}
					} else if (objectType == TOWER) {
						int towerNum = i - storeInventory.getWeaponNum() - storeInventory.getItemNum();
						
						if (userAccount.towerInInv(storeInventory.getTower(towerNum).getName())) {
							msg.setText(s4 + storeInventory.getTower(towerNum).getName());
							msg.setTextFill(Color.RED);
						} else {
							stat = userAccount.purchaseTower(storeInventory.getTower(towerNum) );
							balanceDisplay.setText(s3 + userAccount.getBalance());
							if (stat == 0) {// bought
								msg.setText(s1 + storeInventory.getTower(towerNum ).getName());
								msg.setTextFill(Color.BLACK);
							} else {
								msg.setText(s2 + storeInventory.getTower(towerNum).getName());
								msg.setTextFill(Color.RED);
							}
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
