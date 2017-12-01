package logic;

import javafx.geometry.Pos;

import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;

public class SettingMenu extends GridPane {
	
	public SettingMenu() {           
        Label lblSetting = new Label("Settings with a classs:");
        
 	    lblSetting.setPrefWidth(150);
		lblSetting.setAlignment(Pos.CENTER);
			
		this.add(lblSetting, 0, 0);	 
		
		this.setAlignment(Pos.CENTER);
		  
		this.setHgap(10);
		this.setVgap(10);
	}
	
}
