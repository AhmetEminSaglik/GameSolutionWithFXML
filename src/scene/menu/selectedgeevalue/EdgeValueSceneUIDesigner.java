package scene.menu.selectedgeevalue;

import javafx.scene.Scene;
import scene.scenebuilder.SceneBuilder;

public class EdgeValueSceneUIDesigner {
    public Scene getScene() {
        Scene scene= new SceneBuilder().buildScene("/scene/menu/selectedgeevalue/EdgeValue.fxml", "/resource/menu.css");
        System.out.println("SCENE : " + scene);
        return scene;
    }


}
