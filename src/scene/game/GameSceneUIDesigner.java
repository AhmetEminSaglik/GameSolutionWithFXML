package scene.game;

import javafx.scene.Scene;
import scene.basescenecontroller.BaseSceneController;
import scene.basescenecontroller.BaseSceneLoader;

public class GameSceneUIDesigner extends BaseSceneLoader {


    public GameSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        fxmlPath = "/scene/game/Game.fxml";
        cssPath = "/resource/menu.css";
        getSceeneWithAddedCss();
    }

    public void addCss(Scene scene, String cssPath) {
        scene.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
    }
}
