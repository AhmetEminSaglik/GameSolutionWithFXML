package scene.menu.mainmenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import scene.menu.settings.SettingsUIDesigner;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private AnchorPane anchorPane;


    @FXML
    private Button btnPlayGame;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnExit;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//btnPlayGame.
    }




    @FXML
    void playGame(ActionEvent event) {
    }

    @FXML
    void openSettings(ActionEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new SettingsUIDesigner().getScene());
    }


    @FXML
    void exitFromApplication(ActionEvent event) {
        System.exit(0);
    }

    void desingButtons() {


    }

}
