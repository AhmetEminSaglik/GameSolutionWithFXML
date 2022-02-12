package scene.game;

import javafx.scene.Scene;
import scene.scenebuilder.SceneBuilder;

public class GameSceneUIDesigner {
    public Scene getScene(int edgeValue) {
        Scene scene= new SceneBuilder().buildScene("/scene/game/Game.fxml", "/resource/menu.css");
        System.out.println("SCENE : " + scene);
        return scene;
    }

 

}
