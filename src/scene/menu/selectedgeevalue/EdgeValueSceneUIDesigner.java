package scene.menu.selectedgeevalue;

import scene.basescenecontroller.BaseSceneController;
import scene.basescenecontroller.BaseSceneLoader;

public class EdgeValueSceneUIDesigner extends BaseSceneLoader {

    public EdgeValueSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        fxmlPath = "/scene/menu/selectedgeevalue/EdgeValue.fxml";
        cssPath = "/resource/menu.css";
        getSceeneWithAddedCss();
//        fxmlmove.scene = loadFxmlFile(fxmlPath);
//        addCss(fxmlmove.scene, cssPath);
    }

    /*public Scene getScene() {
        Scene fxmlmove.scene= new SceneBuilder().buildScene("/fxmlmove.scene/menu/selectedgeevalue/EdgeValue.fxml", "/fxmlmove.resource/menu.css");
//        System.out.println("SCENE : " + fxmlmove.scene);
        return fxmlmove.scene;
    }*/


}
