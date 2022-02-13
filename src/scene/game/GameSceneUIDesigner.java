package scene.game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import scene.basescenecontroller.BaseSceneController;
import scene.basescenecontroller.BaseSceneLoader;
import scene.scenebuilder.SceneBuilder;

import java.io.IOException;
import java.util.List;

public class GameSceneUIDesigner extends BaseSceneLoader {

    String fxmlPath = "/scene/game/Game.fxml", cssPath = "/resource/menu.css";

    public GameSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        scene=loadFxmlFile(fxmlPath);
        addCss(scene,cssPath);
    }

  /*  public Scene getScene(int edgeValue) {
//        Scene scene = new SceneBuilder().buildScene("/scene/game/Game.fxml", "/resource/menu.css");
        try {
            System.out.println("gonderilecek edge : " + edgeValue);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();
            GameController gameController = fxmlLoader.getController();
            gameController.setEdgeValue(edgeValue);
            Scene scene = new Scene(root);
            addCss(scene, cssPath);
            return scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/


/*
    void createSquares(int edgeValue) {
        VBox vBox = new VBox(edgeValue);

        for (int y = edgeValue - 1; y >= 0; y--) {
            HBox hBox = new HBox(edgeValue);
            for (int x = 0; x < edgeValue; x++) {
                SquareButton squareButton = new SquareButton(x, y);
                hBox.getChildren().add(squareButton);

            }
            vBox.getChildren().add(hBox);
        } */

//        FXMLLoader fxmlLoader = (FXMLLoader) scene.getWindow().get;
//        GameController gameController = fxmlLoader.getController();
//        gameController.anchorPaneForButtons.getChildren().add(vBox);
//}

    public void addCss(Scene scene, String cssPath) {
        scene.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
    }
}
