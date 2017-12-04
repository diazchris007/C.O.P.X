package logic;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;

class ListCellItems extends ListCell<String> {
    private ImageView imageV = new ImageView();
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        imageV.setFitWidth(30);
        imageV.setFitHeight(30);
        if (empty || item == null) {
        	imageV.setImage(null);

            setGraphic(null);
            setText(null);
        } else {
        	imageV.setImage(ItemFactory.getItem(item).getIcon());
       
            setText(item);
            setGraphic(imageV);
        }
    }
}
