package logic;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Board extends GridPane {
    
    private Cell cells[][];
    private final int CELLWIDTH = 30;
    private final int CELLHEIGHT = 30;
    
    public Board(Cell cells[][]) {
        
    	this.cells = cells;
        draw();
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
            	ImageView cell = new ImageView();
            	cell.setFitWidth(CELLWIDTH);
            	cell.setFitHeight(CELLHEIGHT);
        		
        		if (c[j].getEntityInCell() != null)
	            {
	            	cell.setImage(c[j].getEntityInCell().getImg());
	            }
	            add(cell, i,j);
           	}
        }
    }   
}