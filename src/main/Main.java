package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import scene.menu.main.MainMenuSceneUIDesigner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root ``= FXMLLoader.load(getClass().getResource("/fxmlmove.scene.menu.mainmenu/MainMenu.fxml"));
//        primaryStage.setTitle("Reachg");
//        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new MainMenuSceneUIDesigner().getCreatedScene());
//        primaryStage.setScene(new PlayGameMenuSceneUIDesigner(new PlayGameMenuController(new fxmlmove.preparegamebyselectingmenu.PrepareGameBySelectingMenu())).getCreatedScene());
//        primaryStage.setResizable(false);


        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setWidth(1400);
        primaryStage.setHeight(900);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
