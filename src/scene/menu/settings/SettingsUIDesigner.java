package scene.menu.settings;

import scene.scenebuilder.SceneBuilder;
import javafx.scene.Scene;

public class SettingsUIDesigner {
    public Scene getScene() {
        return new SceneBuilder().buildScene("/scene/menu/settings/Settings.fxml", "/resource/menu.css");
    }
}
