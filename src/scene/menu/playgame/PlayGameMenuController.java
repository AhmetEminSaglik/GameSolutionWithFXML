package scene.menu.playgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import scene.SwitchNewScene;
import scene.menu.main.MainMenuSceneUIDesigner;
import scene.menu.selectedgeevalue.EdgeValueUIDesigner;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayGameMenuController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private VBox menuVBox;

    @FXML
    private Button btnPersonWantToPlay;

    @FXML
    private Button btnRobotWillPlay;

    @FXML
    private Button btnPersonvsRobot;

    @FXML
    private Button btnGoBack;

    @FXML
    void playGameByPerson(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPane,new EdgeValueUIDesigner().getScene());
    }

    @FXML
    void playGameByRobot(ActionEvent event) {

    }

    @FXML
    void playBothPersonAndRobot(ActionEvent event) {

    }

    @FXML
    void goBackMenu(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPane, new MainMenuSceneUIDesigner().getScene());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
