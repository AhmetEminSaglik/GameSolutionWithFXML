package scene.menu.main;

import algorithm.Main.ISelectPlayer;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.SwitchNewScene;
import scene.basescenecontroller.BaseSceneController;
import scene.menu.playgame.PlayGameMenuController;
import scene.menu.playgame.PlayGameMenuSceneUIDesigner;
import scene.menu.settings.SettingsUIDesigner;

public class MainMenuController extends BaseSceneController  /*implements Initializable*/ {

   private PrepareGameBySelectingMenu prepareGameBySelectingMenu;
    public MainMenuController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
    }

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


    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }*/
    @FXML
    void openPlayGameMenu(ActionEvent event) {

        new SwitchNewScene().switchScene(anchorPane, new PlayGameMenuSceneUIDesigner(new PlayGameMenuController(prepareGameBySelectingMenu)).getCreatedScene());

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
