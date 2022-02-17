package scene.game;

import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.play.input.PlayerPlayingStyle;
import algorithm.printarray.StringFormat;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.SwitchNewScene;
import scene.basescenecontroller.BaseSceneController;
import scene.menu.main.MainMenuSceneUIDesigner;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GameController extends BaseSceneController {
    @FXML
    public AnchorPane anchorPaneForButtons;
    private int edgeValue;
    @FXML
    private VBox vBoxToCenterButtons;
    private PrepareGameBySelectingMenu prepareGameBySelectingMenu;

    @FXML
    public Label lblTotalStepValue;
    @FXML
    public Label lblCurrentStepValue;

    @FXML
    public Label lblScoreValue;
    //TODO buraya person'un buldugu degerleri ayni olmayacak sekilde ayirt etmek icin liste eklenip icine skorlar eklenip karsilastirilabilir

    public GameController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
        this.edgeValue = prepareGameBySelectingMenu.getEdgeValue();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            addSquaresToAnchorPane();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    prepareGameBySelectingMenu.startGame();
//                }
//            }).start();

        });
    }

    @FXML
    void goMainMenu(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPaneForButtons, new MainMenuSceneUIDesigner().getCreatedScene());

    }

    @FXML
    void resetGame(ActionEvent event) {
        resetGame();
    }

    @FXML
    void stepBack(ActionEvent event) {
        prepareGameBySelectingMenu.getPlayerPlayingStyle().stepBack();
    }

    void createSquares() {
        int space = 15;

        vBoxToCenterButtons.setSpacing(space);

        for (int y = edgeValue - 1; y >= 0; y--) {
            HBox hBox = new HBox(space);
            hBox.setAlignment(Pos.CENTER);
            for (int x = 0; x < edgeValue; x++) {
                SquareButton squareButton = new SquareButton(x, y);
                squareButton.setOnAction(getValueOfButton(squareButton));
                hBox.getChildren().add(squareButton);
            }
            vBoxToCenterButtons.getChildren().add(hBox);
        }
    }


    EventHandler getValueOfButton(SquareButton button) {
        prepareGameBySelectingMenu.getPlayerPlayingStyle().setGameController(this);
        return new EventHandler<>() {
            @Override
            public void handle(Event event) {
                updateOldHintButtons();
                prepareGameBySelectingMenu.getPlayerPlayingStyle().play(button);
                System.out.println("TIklanilan deger;" + button.getX() + "-" + button.getY());
                paintHintButton();
                printModel();

            }
        };

    }

    void addSquaresToAnchorPane() {
        createSquares();
    }

    public void resetGame() {
        vBoxToCenterButtons.getChildren().removeAll(vBoxToCenterButtons.getChildren());
        addSquaresToAnchorPane();
        prepareGameBySelectingMenu.getGame().resetRoundCounter();
        prepareGameBySelectingMenu.startGame();
        prepareGameBySelectingMenu.getPlayer().setStep(0);
        updateCurrentValue();
        updateStepValue();
        updateTotalFinishedScore();
    }

    public void printModel() {
        String textWillAppendToFile = new StringFormat().getStringFormatArray(prepareGameBySelectingMenu.getGame().getModel().getGameSquares());//  print game squares
        System.out.println(textWillAppendToFile);
    }

    public void updateCurrentValue() {
        lblCurrentStepValue.setText(prepareGameBySelectingMenu.getPlayer().getStep() + "");
    }

    public void updateStepValue() {
        lblTotalStepValue.setText(prepareGameBySelectingMenu.getGame().getRoundCounter() + "");
    }

    public void updateTotalFinishedScore() {
        lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "");
    }

    public void paintHintButton() {
        vBoxToCenterButtons.getChildren();

        for (int i = vBoxToCenterButtons.getChildren().size() - 1; i >= 0; i--) {
            HBox hBox = (HBox) vBoxToCenterButtons.getChildren().get(i);
            for (int j = 0; j < hBox.getChildren().size(); j++) {
                SquareButton squareButton = (SquareButton) hBox.getChildren().get(j);

                if (isOneOfTheHintButton(squareButton)) {
                    squareButton.setId(PlayerPlayingStyle.HINT_BTN_ID);
                    System.out.println(" hint btn : " + squareButton.getX() + "-" + squareButton.getY());

                }
            }
        }
    }

    boolean isOneOfTheHintButton(SquareButton squareButton) {
        List<DirectionLocation> list = new LocationsList().getListOfLocationsAccordingToPlayerCompass(prepareGameBySelectingMenu.getPlayer().getCompass());
        list.remove(list.size() - 1);// remove last location
        for (int i = 0; i < list.size(); i++) {
            if (prepareGameBySelectingMenu.getPlayer().getLocation().getX() + list.get(i).getX() == squareButton.getX() &&
                    prepareGameBySelectingMenu.getPlayer().getLocation().getY() + list.get(i).getY() == squareButton.getY()
                    && !squareButton.getId().equals(PlayerPlayingStyle.VISITED_BEFORE_BTN_ID)) {

                return true;
            }
        }
        return false;
    }

    public void updateOldHintButtons() {
        vBoxToCenterButtons.getChildren();

        for (int i = vBoxToCenterButtons.getChildren().size() - 1; i >= 0; i--) {
            HBox hBox = (HBox) vBoxToCenterButtons.getChildren().get(i);
            for (int j = 0; j < hBox.getChildren().size(); j++) {
                SquareButton squareButton = (SquareButton) hBox.getChildren().get(j);
                if (isHintBtnId(squareButton)) {
                    squareButton.setId(PlayerPlayingStyle.NORMAL_SQUARE_BTN_ID);
                }
            }
        }
    }

    boolean isHintBtnId(SquareButton squareButton) {
        if (squareButton.getId().equals(PlayerPlayingStyle.HINT_BTN_ID))
            return true;
        return false;
    }

    public PrepareGameBySelectingMenu getPrepareGameBySelectingMenu() {
        return prepareGameBySelectingMenu;
    }
}

