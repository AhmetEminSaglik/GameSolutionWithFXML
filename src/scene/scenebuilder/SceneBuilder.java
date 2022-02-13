package scene.scenebuilder;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneBuilder {
    private Parent getRoot(String scenePath) {
        try {
//            System.out.println("gelen path : "+scenePath);
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource(scenePath));
//            System.out.println("root : "+root);
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("root : "+null);
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
