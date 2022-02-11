package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import scene.menu.mainmenu.MainMenuSceneUIDesigner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/scene.menu.mainmenu/MainMenu.fxml"));
        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new MainMenuSceneUIDesigner().getScene());
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