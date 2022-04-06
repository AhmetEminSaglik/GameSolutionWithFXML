package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import scene.menu.main.MainMenuSceneUIDesigner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.centerOnScreen();
        primaryStage.setScene(new MainMenuSceneUIDesigner().getCreatedScene());

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setWidth(1400);
        primaryStage.setHeight(900);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
