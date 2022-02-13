package scene.basescenecontroller;

import javafx.fxml.Initializable;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseSceneController implements Initializable {
    protected PrepareGameBySelectingMenu prepareGameBySelectingMenu;

    public BaseSceneController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
