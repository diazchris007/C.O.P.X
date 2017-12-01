package logic;

import javafx.geometry.Insets;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Board extends GridPane {
    
    private static Board instance;
	private Cell[][] cells;
    private static final int CELLWIDTH = 30;
    private static final int CELLHEIGHT = 30;
    
    private Board() {
    	
    }
    public static Board getInstance()
    {
    	if(instance == null)
    		instance = new Board();
    	return instance;
    }
    
    
    public Cell[][] getCells(){
        return this.cells;
    }
    
    public void setCells(Cell[][] cells) {
    	this.cells = cells;
    }

    public void draw() {
        
        getChildren().clear();
        
        for(int i = 0 ; i < cells.length; i++)
        {
            Cell[] c = cells[i];
        	for(int j = 0; j < c.length; j++)
            {
        		VBox tempPane = new VBox();
        		tempPane.setMaxHeight(CELLHEIGHT);
        		tempPane.setMinHeight(CELLHEIGHT);
        		tempPane.setMinWidth(CELLWIDTH);
        		tempPane.setMaxWidth(CELLWIDTH);
        		tempPane.setPadding(Insets.EMPTY);
        		tempPane.setSpacing(0);
            	ImageView entityIcon = new ImageView();
            	entityIcon.setFitWidth(CELLWIDTH);
            	entityIcon.setFitHeight(CELLHEIGHT - (double)10);
        		if (c[j].getEntityInCell() != null)
	            {
        			float healthPercent = c[j].getEntityInCell().getHeathPercent();
        			
        			ProgressBar pb = new ProgressBar(healthPercent);
        			
        			pb.setMaxSize(30, 5);
        			tempPane.getChildren().add(pb);
	            	entityIcon.setImage(c[j].getEntityInCell().getImg());
	            }
        		tempPane.getChildren().add(entityIcon);
	            add(tempPane, i,j);
	            
           	}
        }
        
    }   
}