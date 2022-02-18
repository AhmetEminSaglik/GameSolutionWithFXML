package scene.menu.playgame.solutionChoice;

import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.gamerepo.player.robot.solution.BaseSolution;
import algorithm.game.gamerepo.player.robot.solution.first.FirstSolution_Combination;
import algorithm.game.gamerepo.player.robot.solution.second.SecondSolution_CalculateForwardAvailableWays;
import algorithm.game.play.PlayerMove;
import algorithm.game.play.input.robot.RobotInput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.SwitchNewScene;
import scene.basescenecontroller.BaseSceneController;
import scene.menu.playgame.PlayGameMenuController;
import scene.menu.playgame.PlayGameMenuSceneUIDesigner;
import scene.menu.selectedgeevalue.EdgeValueController;
import scene.menu.selectedgeevalue.EdgeValueSceneUIDesigner;

public class SolutionChoiceController extends BaseSceneController {
    public SolutionChoiceController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
    }

    @FXML
    private RadioButton solutionFirst;

    @FXML
    private ToggleGroup solutionGroup;

    @FXML
    private RadioButton solutionSecond;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnGoBack;

    BaseSolution baseSolution;

    @FXML
    void getSelectedSolution(ActionEvent event) {
        if (solutionFirst.equals(solutionGroup.getSelectedToggle())) {
            baseSolution = new FirstSolution_Combination(prepareGameBySelectingMenu.getGame());
        } else if (solutionSecond.equals(solutionGroup.getSelectedToggle())) {
            baseSolution = new SecondSolution_CalculateForwardAvailableWays(prepareGameBySelectingMenu.getGame());
        }
    }

    @FXML
    void goBack(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPane, new PlayGameMenuSceneUIDesigner(new PlayGameMenuController(prepareGameBySelectingMenu)).getCreatedScene());
    }

    @FXML
    void startGame(ActionEvent event) {

        if (baseSolution != null) {
            Robot robot = (Robot) prepareGameBySelectingMenu.getPlayer();
            robot.setSolution(baseSolution);
            robot.setIPlayerInput(new RobotInput(robot.getSolution()));
            robot.setPlayerMove(new PlayerMove(robot.getSolution().getMoveForward(), robot.getSolution().getMoveBack()));

            new SwitchNewScene().switchScene(anchorPane, new EdgeValueSceneUIDesigner(new EdgeValueController(prepareGameBySelectingMenu)).getCreatedScene());

        } else {
            //TODO hata message bastirilacak : Solution Choice Controller
            System.out.println("HATA MESAJI BASTIRILACAK");
        }
    }

}
