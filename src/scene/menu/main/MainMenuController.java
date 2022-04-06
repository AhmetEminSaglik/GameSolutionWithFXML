package scene.menu.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.SwitchNewScene;
import scene.basescenecontroller.BaseSceneController;
import scene.menu.playgame.PlayGameMenuController;
import scene.menu.playgame.PlayGameMenuSceneUIDesigner;
import scene.menu.settings.SettingsController;
import scene.menu.settings.SettingsUIDesigner;

public class MainMenuController extends BaseSceneController  /*implements Initializable*/ {

   private PrepareGameBySelectingMenu prepareGameBySelectingMenu;
    public MainMenuController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
    }
    @FXML
    void openPlayGameMenu(ActionEvent event) {

        new SwitchNewScene().switchScene(anchorPane, new PlayGameMenuSceneUIDesigner(new PlayGameMenuController(prepareGameBySelectingMenu)).getCreatedScene());

    }

    @FXML
    void openSettings(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPane, new SettingsUIDesigner(new SettingsController(prepareGameBySelectingMenu)).getCreatedScene());
    }

    @FXML
    void openHowToPlay(ActionEvent event) {

    }

    @FXML
    void exitFromApplication(ActionEvent event) {
        System.exit(0);
    }


}
