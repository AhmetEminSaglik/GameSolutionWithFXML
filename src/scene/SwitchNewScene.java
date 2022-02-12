package scene;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SwitchNewScene {

    public void switchScene(AnchorPane anchorPane, Scene scene) {
        Stage stage = fillStageFromAnchorPane(anchorPane);
        stage.setScene(scene);
    }

    Stage fillStageFromAnchorPane(AnchorPane anchorPane) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        return stage;
    }
}
