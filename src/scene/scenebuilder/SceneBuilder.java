package scene.scenebuilder;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class SceneBuilder {
    public Parent getRoot(String scenePath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource(scenePath));
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
