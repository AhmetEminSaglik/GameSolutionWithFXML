package scene.menu.selectedgeevalue;

import algorithm.game.gamerepo.IDetermineEdgeValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.SwitchNewScene;
import scene.basescenecontroller.BaseSceneController;
import scene.game.GameController;
import scene.game.GameSceneUIDesigner;
import scene.menu.playgame.PlayGameMenuController;
import scene.menu.playgame.PlayGameMenuSceneUIDesigner;

import java.net.URL;
import java.util.ResourceBundle;

public class EdgeValueController extends BaseSceneController implements IDetermineEdgeValue {

    int UNSELECTED_VALUE = -1;
    private PrepareGameBySelectingMenu prepareGameBySelectingMenu;

    public EdgeValueController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
    }

//    @FXML
//    private AnchorPane anchorPane;

    @FXML
    private VBox menuFirstDeepVBox;

    int squareEdgeValue = UNSELECTED_VALUE;

    @FXML
    private Button btnStart;
    @FXML
    private ToggleGroup edgeValueGroup;
    @FXML
    private RadioButton radioBtnSquareEdge5x5;
    @FXML
    private RadioButton radioBtnSquareEdge6x6;
    @FXML
    private RadioButton radioBtnSquareEdge7x7;
    @FXML
    private RadioButton radioBtnSquareEdge8x8;
    @FXML
    private RadioButton radioBtnSquareEdge9x9;
    @FXML
    private RadioButton radioBtnSquareEdge10x10;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    @FXML
    void getSelectedRadioBtnItem(ActionEvent event) {
//        System.out.println("Secilen toggle " + edgeValueGroup.getSelectedToggle());
//        System.out.println(edgeValueGroup.getSelectedToggle() == radioBtnSquareEdge5x5);
//        System.out.println(edgeValueGroup.getSelectedToggle());

        if (radioBtnSquareEdge5x5.equals(edgeValueGroup.getSelectedToggle())) {
            squareEdgeValue = 5;
        } else if (radioBtnSquareEdge6x6.equals(edgeValueGroup.getSelectedToggle())) {
            squareEdgeValue = 6;
        } else if (radioBtnSquareEdge7x7.equals(edgeValueGroup.getSelectedToggle())) {
            squareEdgeValue = 7;
        } else if (radioBtnSquareEdge8x8.equals(edgeValueGroup.getSelectedToggle())) {
            squareEdgeValue = 8;
        } else if (radioBtnSquareEdge9x9.equals(edgeValueGroup.getSelectedToggle())) {
            squareEdgeValue = 9;
        } else if (radioBtnSquareEdge10x10.equals(edgeValueGroup.getSelectedToggle())) {
            squareEdgeValue = 10;
        }
//        prepareGameBySelectingMenu.setEdgeValue(squareEdgeValue);

    }

    @FXML
    void startGame(ActionEvent event) {
        if (squareEdgeValue != UNSELECTED_VALUE) {
            prepareGameBySelectingMenu.buildGameModel(this);
            prepareGameBySelectingMenu.getPlayerSpecialStuffToPrepareBeforeStartGame().prepare();
            new SwitchNewScene().switchScene(anchorPane, new GameSceneUIDesigner(new GameController(prepareGameBySelectingMenu)).getCreatedScene());
        } else {
            //TODO hata message bastirilacak : Edge Value Controller
            System.out.println("HATA MESAJI BASTIRILACAK");
        }
    }

    @FXML
    void goBack(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPane, new PlayGameMenuSceneUIDesigner(new PlayGameMenuController(prepareGameBySelectingMenu)).getCreatedScene());
    }

    @Override
    public int determineEdgeValue() {
        return squareEdgeValue;
    }
}
