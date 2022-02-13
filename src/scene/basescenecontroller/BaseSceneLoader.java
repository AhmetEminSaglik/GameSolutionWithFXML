package scene.basescenecontroller;

import algorithm.errormessage.ErrorMessage;
import algorithm.errormessage.joptionpanel.ShowPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import scene.scenebuilder.SceneBuilder;

import javax.swing.*;
import java.io.IOException;

public abstract class BaseSceneLoader extends AnchorPane {

    protected Scene scene;
    protected BaseSceneController baseSceneController;

    public BaseSceneLoader(BaseSceneController baseSceneController) {
        this.baseSceneController = baseSceneController;
    }



    public Scene loadFxmlFile(String fxmlPath) {
//        ShowPanel.show(getClass(),"Gelen controller : "+baseSceneController.getClass());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));

        fxmlLoader.setController(baseSceneController);
//        fxmlLoader.setRoot(this);


        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            return scene;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            ErrorMessage.appearFatalError(getClass(), e.getMessage());
        }
        return null;
    }

    public Scene getCreatedScene() {
        return scene;
    }

    public void addCss(Scene scene, String cssPath) {
        new SceneBuilder().addCss(scene, cssPath);
    }
}
