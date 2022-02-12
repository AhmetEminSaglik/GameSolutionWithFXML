package scene.game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    public AnchorPane anchorPaneForButtons;
    private int edgeValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initilaize aderken anchor pane : " + anchorPaneForButtons);
        System.out.println("baslatilirken gelen edge" + edgeValue);
        Platform.runLater(() -> addSquaresToAnchorPane());
    }


    @FXML
    void goMainMenu(ActionEvent event) {

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

    VBox createSquares() {
        VBox vBox = new VBox(edgeValue);

        for (int y = edgeValue - 1; y >= 0; y--) {
            HBox hBox = new HBox(edgeValue);
            for (int x = 0; x < edgeValue; x++) {
                SquareButton squareButton = new SquareButton(x, y);
                hBox.getChildren().add(squareButton);

            }
            vBox.getChildren().add(hBox);
        }
        return vBox;
    }

    void addSquaresToAnchorPane() {
        VBox allSquares = createSquares();
        anchorPaneForButtons.getChildren().add(allSquares);
    }


    public void setEdgeValue(int edgeValue) {
        this.edgeValue = edgeValue;
    }

/*    void createSquares(int edgeValue) {
        VBox vBox = new VBox(edgeValue);

        for (int y = edgeValue - 1; y >= 0; y--) {
            HBox hBox = new HBox(edgeValue);
            for (int x = 0; x < edgeValue; x++) {
                SquareButton squareButton = new SquareButton(x, y);
                hBox.getChildren().add(squareButton);

            }
            vBox.getChildren().add(hBox);
        }
    }*/
}
