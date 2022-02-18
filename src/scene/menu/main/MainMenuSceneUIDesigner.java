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
//        fxmlmove.scene = loadFxmlFile(fxmlPath);
//        addCss(fxmlmove.scene, cssPath);
    }

    public MainMenuSceneUIDesigner() {
        this(new MainMenuController(new PrepareGameBySelectingMenu()));
    }

    //    public Scene getScene() {
//        return new SceneBuilder().buildScene("/fxmlmove.scene/menu/fxmlmove.main/MainMenu.fxml", "/fxmlmove.resource/menu.css");
//    }
  /*  public Scene getScene() {
//        Scene fxmlmove.scene = new SceneBuilder().buildScene("/fxmlmove.scene/game/Game.fxml", "/fxmlmove.resource/menu.css");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
//            Parent root = fxmlLoader.load();
            MainMenuController mainMenuController = new MainMenuController(new fxmlmove.preparegamebyselectingmenu.PrepareGameBySelectingMenu());
            fxmlLoader.setController(mainMenuController);
//        MainMenuController mainMenuController = fxmlLoader.getController();
            Parent root = fxmlLoader.load();
            Scene fxmlmove.scene = new Scene(root);
            new SceneBuilder().addCss(fxmlmove.scene, cssPath);
            return fxmlmove.scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
