package scene.menu.playgame;

import javafx.scene.Scene;
import scene.scenebuilder.SceneBuilder;

public class PlayGameMenuSceneUIDesigner {
    public Scene getScene() {
        return new SceneBuilder().buildScene("/scene/menu/playgame/PlayGameMenu.fxml", "/resource/menu.css");
    }
}
