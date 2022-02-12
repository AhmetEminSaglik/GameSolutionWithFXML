package scene.menu.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import scene.SwitchNewScene;
import scene.menu.playgame.PlayGameMenuSceneUIDesigner;
import scene.menu.settings.SettingsUIDesigner;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

//    @FXML
//    private VBox menuVBox;
//    @FXML
//    private Button btnPlayGame;
//
//    @FXML
//    private Button btnSettings;
//
//    @FXML
//    private Button btnExit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    @FXML
    void openPlayGameMenu(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPane, new PlayGameMenuSceneUIDesigner().getScene());
    }

    @FXML
    void openSettings(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPane, new SettingsUIDesigner().getScene());
    }

    @FXML
    void openHowToPlay(ActionEvent event) {

    }

    @FXML
    void exitFromApplication(ActionEvent event) {
        System.exit(0);
    }
}
