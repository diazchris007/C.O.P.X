package logic;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;

class ListCellWeapons extends ListCell<String> {
    private ImageView imageView = new ImageView();

    
    
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        imageView.setFitWidth(30);
		imageView.setFitHeight(30);
        
        if (empty || item == null) {
            imageView.setImage(null);

            setGraphic(null);
            setText(null);
        } else {
            imageView.setImage(WeaponFactory.getWeapon(item).getIcon());
       
            setText(item);
            setGraphic(imageView);
        }
    }
}
