package scene.game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import scene.SwitchNewScene;
import scene.menu.main.MainMenuSceneUIDesigner;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    public AnchorPane anchorPaneForButtons;
    private int edgeValue;
    @FXML
    private VBox vBoxToCenterButtons;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initilaize aderken anchor pane : " + anchorPaneForButtons);
        System.out.println("baslatilirken gelen edge" + edgeValue);
        Platform.runLater(() -> {
            addSquaresToAnchorPane();
            /*System.out.println("platform calisiyor");
            System.out.println(anchorPaneForButtons.getChildren());
            VBox vBox=(VBox) anchorPaneForButtons.getChildren().get(0);
            HBox hBox=(HBox) vBox.getChildren().get(0);
            System.out.println(hBox.getChildren());
            Button button= (Button) vBox.getChildren().get(0);
            button.setPrefSize(500,200);*/
        });

    }


    @FXML
    void goMainMenu(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPaneForButtons, new MainMenuSceneUIDesigner().getScene());

    }

    @FXML
    void resetGame(ActionEvent event) {
        System.out.println("RESET TIKLANDI ");
        System.out.println("reset edge" + edgeValue);
        addSquaresToAnchorPane();
    }

    @FXML
    void stepBack(ActionEvent event) {

    }

    void createSquares() {
        int space = 15;
//        VBox vBox = new VBox(space);
//        vBox.setAlignment(Pos.CENTER);
        vBoxToCenterButtons.setSpacing(space);


//        vBox.setPrefSize(anchorPaneForButtons.getPrefWidth(),anchorPaneForButtons.getPrefHeight());
//        vBox.setMinSize(anchorPaneForButtons.getPrefWidth(),anchorPaneForButtons.getPrefHeight());
//        vBox.setMaxSize(anchorPaneForButtons.getPrefWidth(),anchorPaneForButtons.getPrefHeight());
//        System.out.println("vBox.getWidth()  : "+vBox.getWidth());
//        System.out.println("vBox.getHeight() : "+vBox.getHeight());
//        vBox.setSpacing(space);
//        vBox.setPrefSize(anchorPaneForButtons.getPrefWidth(), anchorPaneForButtons.getPrefHeight());
        for (int y = edgeValue - 1; y >= 0; y--) {
            HBox hBox = new HBox(space);
            hBox.setAlignment(Pos.CENTER);
            for (int x = 0; x < edgeValue; x++) {
                SquareButton squareButton = new SquareButton(x, y);
                hBox.getChildren().add(squareButton);

            }
            vBoxToCenterButtons.getChildren().add(hBox);
        }
//        vBox.setAlignment(Pos.CENTER);
//        System.out.println(vBoxToCenterButtons.getAlignment());
//        return vBoxToCenterButtons;
//        return vBoxToCenterButtons;
    }

    void addSquaresToAnchorPane() {
//        VBox vBox = createSquares();
        createSquares();
//        allSquares.setPrefSize(anchorPaneForButtons.getPrefWidth(), anchorPaneForButtons.getPrefHeight());
        double paddingLeftSpace = 520 - (edgeValue - 5) * 35;
        double paddingTopSpace = 30 + (10 - edgeValue) * 30;
//        vBox.setPadding(new Insets(0, 10, 10, 10));
        //10 --> 320
        // 9 355
        //8 --> 415
        //6-->490
        // 5 --> 535

//        System.out.println("gelen Vbox : " + vBoxToCenterButtons.getAlignment().toString());
//        anchorPaneForButtons.getChildren().add(vBox);
    }


    public void setEdgeValue(int edgeValue) {
        this.edgeValue = edgeValue;
    }

}
