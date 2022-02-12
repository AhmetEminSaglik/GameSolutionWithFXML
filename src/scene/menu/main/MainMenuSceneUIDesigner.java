package scene.menu.main;

import scene.scenebuilder.SceneBuilder;
import javafx.scene.Scene;

public class MainMenuSceneUIDesigner {

    public Scene getScene() {
        return new SceneBuilder().buildScene("/scene/menu/main/MainMenu.fxml", "/resource/menu.css");
    }
}
