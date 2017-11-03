package logic;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends GridPane {
    private Player player;
    private Cell cells[][];
    private final int CELLWIDTH = 30;
    private final int CELLHEIGHT = 30;
    private final int LMARGIN = 0;
    private Image img1 = new Image("File:./../images/clear.png");
    private Image img2 = new Image("File:./../images/Player.png");
    
    
    public Board(Player p, Cell cells[][]) {
        
    	player = p;
        this.cells = cells;
        paint();
    }

    public Cell[][] getCells(){
        return this.cells;
    }

    public Player getPlayer() {
        return player;
    }

    public void paint() {
        //Clear previous cells, we don't need them now
        getChildren().clear();
        
        //Redraw them
        for(int i = 0 ; i < cells.length; i++)
        {
            Cell[] c = cells[i];
        	for(int j = 0; j < c.length; j++)
            {
            	Rectangle r1 = new Rectangle(coord(i), coord(j), CELLWIDTH, CELLHEIGHT);
	            //r1.setStroke(Color.BLACK);
            	ImageView cell = new ImageView();
            	cell.setFitWidth(CELLWIDTH);
            	cell.setFitHeight(CELLHEIGHT);
        		
        		//We've found a player in the cell, let's color it black
	            if (c[j].getPlayerInCell() != null)
	            {
	            	cell.setImage(img2);
	            	//add(cell,i,j);
	            	//r1.setFill(Color.BLACK);
	            }
	            	//No, player in this cell, white it is
	            else
	            	cell.setImage(img1);
	                //r1.setFill(Color.WHITE);
	            add(cell, i,j);
           	}
        }
    }
    
    private int coord(int col) {
        return LMARGIN + col * CELLWIDTH;
    }
}