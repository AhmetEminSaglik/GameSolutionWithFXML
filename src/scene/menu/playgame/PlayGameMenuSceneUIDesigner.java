package scene.menu.playgame;

import scene.basescenecontroller.BaseSceneController;
import scene.basescenecontroller.BaseSceneLoader;

public class PlayGameMenuSceneUIDesigner extends BaseSceneLoader {



    public PlayGameMenuSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        fxmlPath = "/scene/menu/playgame/PlayGameMenu.fxml";
        cssPath = "/resource/menu.css";
        getSceeneWithAddedCss();
//        scene = loadFxmlFile(fxmlPath);
//        addCss(scene, cssPath);
    }

//    public Scene getScene() {
//        return new SceneBuilder().buildScene("/scene/menu/playgame/PlayGameMenu.fxml", "/resource/menu.css");
//    }
}
