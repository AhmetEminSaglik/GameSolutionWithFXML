package scene.scenebuilder;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneBuilder {
    private Parent getRoot(String scenePath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource(scenePath));
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Scene buildScene(String scenePath, String cssPath) {
        Scene scene = new Scene(getRoot(scenePath));

        addCss(scene, cssPath);
        return scene;
    }


    public void addCss(Scene scene, String cssPath) {
        scene.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
    }


}
