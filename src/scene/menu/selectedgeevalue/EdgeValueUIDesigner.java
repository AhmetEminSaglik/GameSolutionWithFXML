package scene.menu.selectedgeevalue;

import javafx.scene.Scene;
import scene.scenebuilder.SceneBuilder;

public class EdgeValueUIDesigner {
    public Scene getScene() {
        return new SceneBuilder().buildScene("/scene/menu/selectedgeevalue/EdgeValue.fxml", "/resource/menu.css");
    }


}
