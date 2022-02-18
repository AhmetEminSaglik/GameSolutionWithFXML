package scene.game;

import javafx.scene.Scene;
import scene.basescenecontroller.BaseSceneController;
import scene.basescenecontroller.BaseSceneLoader;

public class GameSceneUIDesigner extends BaseSceneLoader {


    public GameSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        fxmlPath = "/scene/game/Game.fxml";
        cssPath = "/resource/menu.css";
        getSceeneWithAddedCss();
//        fxmlmove.scene=loadFxmlFile(fxmlPath);
//        addCss(fxmlmove.scene,cssPath);
    }

  /*  public Scene getScene(int edgeValue) {
//        Scene fxmlmove.scene = new SceneBuilder().buildScene("/fxmlmove.scene/game/Game.fxml", "/fxmlmove.resource/menu.css");
        try {
            System.out.println("gonderilecek edge : " + edgeValue);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();
            GameController gameController = fxmlLoader.getController();
            gameController.setEdgeValue(edgeValue);
            Scene fxmlmove.scene = new Scene(root);
            addCss(fxmlmove.scene, cssPath);
            return fxmlmove.scene;
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

//        FXMLLoader fxmlLoader = (FXMLLoader) fxmlmove.scene.getWindow().get;
//        GameController gameController = fxmlLoader.getController();
//        gameController.anchorPaneForButtons.getChildren().add(vBox);
//}

    public void addCss(Scene scene, String cssPath) {
        scene.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
    }
}
