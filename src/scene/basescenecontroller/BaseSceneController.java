package scene.basescenecontroller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseSceneController implements Initializable {
    protected PrepareGameBySelectingMenu prepareGameBySelectingMenu;

    @FXML
    protected AnchorPane anchorPane;

    public BaseSceneController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
