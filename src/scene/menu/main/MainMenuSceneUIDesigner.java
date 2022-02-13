package scene.menu.main;

import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.basescenecontroller.BaseSceneLoader;
import scene.basescenecontroller.BaseSceneController;
import javafx.scene.Scene;

public class MainMenuSceneUIDesigner extends BaseSceneLoader {

    final String fxmlPath = "/scene/menu/main/MainMenu.fxml", cssPath = "/resource/menu.css";

    public MainMenuSceneUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        scene = loadFxmlFile(fxmlPath);
        addCss(scene, cssPath);
    }

    public MainMenuSceneUIDesigner() {
        this(new MainMenuController(new PrepareGameBySelectingMenu()));
    }

    //    public Scene getScene() {
//        return new SceneBuilder().buildScene("/scene/menu/main/MainMenu.fxml", "/resource/menu.css");
//    }
  /*  public Scene getScene() {
//        Scene scene = new SceneBuilder().buildScene("/scene/game/Game.fxml", "/resource/menu.css");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
//            Parent root = fxmlLoader.load();
            MainMenuController mainMenuController = new MainMenuController(new PrepareGameBySelectingMenu());
            fxmlLoader.setController(mainMenuController);
//        MainMenuController mainMenuController = fxmlLoader.getController();
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            new SceneBuilder().addCss(scene, cssPath);
            return scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
