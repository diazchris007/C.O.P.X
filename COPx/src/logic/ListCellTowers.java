package logic;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;

class ListCellTowers extends ListCell<String> {
    private ImageView imageVi = new ImageView();

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        imageVi.setFitWidth(30);
        imageVi.setFitHeight(30);
        if (empty || item == null) {
        	
        	imageVi.setImage(null);
            setGraphic(null);
            setText(null);
        } else {
        		imageVi.setImage(TowerFactory.getTower(item).getIcon());
       
            setText(item);
            setGraphic(imageVi);
        }
    }
}
