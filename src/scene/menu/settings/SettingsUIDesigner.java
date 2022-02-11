package scene.menu.settings;

import scene.scenebuilder.SceneBuilder;
import javafx.scene.Scene;

public class SettingsUIDesigner {
    public Scene getScene() {
        Scene scene = new Scene(new SceneBuilder().getRoot("/scene/menu/settings/Settings.fxml"));
        return scene;
    }
}
