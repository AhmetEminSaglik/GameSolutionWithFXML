package scene.menu.playgame.solutionChoice;

import scene.basescenecontroller.BaseSceneController;
import scene.basescenecontroller.BaseSceneLoader;

public class SolutionChoiceSceneUIDesigner extends BaseSceneLoader {

    final String fxmlPath = "/scene/menu/playgame/solutionChoice/SolutionChoice.fxml", cssPath = "/resource/menu.css";

    public SolutionChoiceSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        scene = loadFxmlFile(fxmlPath);
        addCss(scene, cssPath);
    }
}
