package scene.menu.main;

import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.basescenecontroller.BaseSceneLoader;
import scene.basescenecontroller.BaseSceneController;

public class MainMenuSceneUIDesigner extends BaseSceneLoader {


    public MainMenuSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        fxmlPath = "/scene/menu/main/MainMenu.fxml";
        cssPath = "/resource/menu.css";
        getSceeneWithAddedCss();
    }

    public MainMenuSceneUIDesigner() {
        this(new MainMenuController(new PrepareGameBySelectingMenu()));
    }

}
