package logic;

import javafx.geometry.Pos;

import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;

public class SettingMenu extends GridPane {
	
	public SettingMenu() {           
        Label lbl_Setting = new Label("Settings with a classs:");
        
 	    lbl_Setting.setPrefWidth(150);
		lbl_Setting.setAlignment(Pos.CENTER);
			
		this.add(lbl_Setting, 0, 0);	 
		
		this.setAlignment(Pos.CENTER);
		
		this.setHgap(10);
		this.setVgap(10);
	}
	
}
