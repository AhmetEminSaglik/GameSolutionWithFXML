package scene.menu.selectedgeevalue;

import scene.basescenecontroller.BaseSceneController;
import scene.basescenecontroller.BaseSceneLoader;

public class EdgeValueSceneUIDesigner extends BaseSceneLoader {

    public EdgeValueSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        fxmlPath = "/scene/menu/selectedgeevalue/EdgeValue.fxml";
        cssPath = "/resource/menu.css";
        getSceeneWithAddedCss();
    }



}
