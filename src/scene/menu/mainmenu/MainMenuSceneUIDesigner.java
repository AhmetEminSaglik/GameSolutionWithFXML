package scene.menu.mainmenu;

import scene.scenebuilder.SceneBuilder;
import javafx.scene.Scene;

public class MainMenuSceneUIDesigner {

    public Scene getScene() {
        Scene scene = new Scene(new SceneBuilder().getRoot("/scene/menu/mainmenu/MainMenu.fxml"));
        addCss(scene);

        return scene;
    }

    void addCss(Scene scene) {
        scene.getStylesheets().add(getClass().getResource("/resource/mainmenu.css").toExternalForm());
    }

}
