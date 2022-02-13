package scene.menu.selectedgeevalue;

import scene.basescenecontroller.BaseSceneController;
import scene.basescenecontroller.BaseSceneLoader;

public class EdgeValueSceneUIDesigner extends BaseSceneLoader {
    final String fxmlPath = "/scene/menu/selectedgeevalue/EdgeValue.fxml", cssPath = "/resource/menu.css";

    public EdgeValueSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        scene = loadFxmlFile(fxmlPath);
        addCss(scene, cssPath);
    }

    /*public Scene getScene() {
        Scene scene= new SceneBuilder().buildScene("/scene/menu/selectedgeevalue/EdgeValue.fxml", "/resource/menu.css");
//        System.out.println("SCENE : " + scene);
        return scene;
    }*/


}
