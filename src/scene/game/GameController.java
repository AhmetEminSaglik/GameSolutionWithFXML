package scene.game;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.move.Move;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.play.input.PlayerPlayingStyle;
import algorithm.game.play.input.person.PersonPlayingStyle;
import algorithm.printarray.StringFormat;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.SwitchNewScene;
import scene.basescenecontroller.BaseSceneController;
import scene.menu.main.MainMenuSceneUIDesigner;

import javax.swing.*;
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
    private Label lblTotalStepValue;
    @FXML
    private Label lblCurrentStepValue;

    @FXML
    private Label lblScoreValue;
    //TODO buraya person'un buldugu degerleri ayni olmayacak sekilde ayirt etmek icin liste eklenip icine skorlar eklenip karsilastirilabilir

    public GameController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
        this.edgeValue = prepareGameBySelectingMenu.getEdgeValue();
        System.out.println("edge value : " + edgeValue);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println("initilaize aderken anchor pane : " + anchorPaneForButtons);
//        System.out.println("baslatilirken gelen edge" + edgeValue);
        Platform.runLater(() -> {
            addSquaresToAnchorPane();
//            System.out.println("Once buton sonra bu gelmeli");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    prepareGameBySelectingMenu.startGame();

                }
            }).start();

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
        new SwitchNewScene().switchScene(anchorPaneForButtons, new MainMenuSceneUIDesigner().getCreatedScene());

    }

    @FXML
    void resetGame(ActionEvent event) {
        resetGame();
    }

    @FXML
    void stepBack(ActionEvent event) {

        if (prepareGameBySelectingMenu.getPlayer().getStep() > 1) {
            updateOldHintButtons();
            prepareGameBySelectingMenu.getGame().increaseRoundCounter();
            PlayerPlayingStyle playerPlayingStyle = prepareGameBySelectingMenu.getPlayerPlayingStyle();

//                    listMovedSquareBtn.get(listMovedSquareBtn.size()-1).setId(NORMAL_SQUARE_BTN_ID);
//                    listMovedSquareBtn.get(listMovedSquareBtn.size()-1).setText("");
            SquareButton button = playerPlayingStyle.listMovedSquareBtn.get(playerPlayingStyle.listMovedSquareBtn.size() - 1);
            button.setId(playerPlayingStyle.NORMAL_SQUARE_BTN_ID);
            button.setText("");
//            button.setId(playerPlayingStyle.CURRENT_BTN_ID);

//            Move moveBack = prepareGameBySelectingMenu.getPlayer().getPlayerMove().getMoveBack();
//            moveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(prepareGameBySelectingMenu.getPlayer().getGame(),
//                    prepareGameBySelectingMenu.getPlayer().getCompass().getLastLocation()));
            Move moveBack = prepareGameBySelectingMenu.getPlayer().getPlayerMove().getMoveBack();
            moveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(prepareGameBySelectingMenu.getGame(),
                    prepareGameBySelectingMenu.getPlayer().getCompass().getLastLocation()));

            playerPlayingStyle.listMovedSquareBtn.remove(playerPlayingStyle.listMovedSquareBtn.size() - 1);

//            if (playerPlayingStyle.listMovedSquareBtn.size() > 0) {
            SquareButton squareButton = playerPlayingStyle.listMovedSquareBtn.get(playerPlayingStyle.listMovedSquareBtn.size() - 1);
            squareButton.setId(playerPlayingStyle.CURRENT_BTN_ID);
//            }
            updateCurrentValue();
            updateStepValue();
            paintHintButton();
        }
        printModel();
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
                squareButton.setOnAction(getValueOfButton(squareButton));
                hBox.getChildren().add(squareButton);

            }
            vBoxToCenterButtons.getChildren().add(hBox);
        }
//        vBox.setAlignment(Pos.CENTER);
//        System.out.println(vBoxToCenterButtons.getAlignment());
//        return vBoxToCenterButtons;
//        return vBoxToCenterButtons;
    }


    EventHandler getValueOfButton(SquareButton button) {
        return new EventHandler<>() {
            @Override
            public void handle(Event event) {
                updateOldHintButtons();
                prepareGameBySelectingMenu.getPlayerPlayingStyle().play(button);
                System.out.println("TIklanilan deger;" + button.getX() + "-" + button.getY());

                Platform.runLater(() -> {

                    if (prepareGameBySelectingMenu.getPlayer().getGameRule().isGameOver(prepareGameBySelectingMenu.getPlayer().getGame())) {
                        if (prepareGameBySelectingMenu.getPlayer().getStep() == prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue()) {
                            ShowPanel.show(getClass(), "Tebrikler butun bosluklari doldurdunuz.");
                            prepareGameBySelectingMenu.getPlayer().getScore().increaseTotalGameFinishedScore();
                            lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "");
                        } else {
                            JOptionPane.showMessageDialog(null, " Game Over Step deger i : " + prepareGameBySelectingMenu.getPlayer().getStep());
                            resetGame();
                        }
                    }
                    updateCurrentValue();
                    updateStepValue();

                });

                paintHintButton();
                printModel();
//                String textWillAppendToFile = new StringFormat().getStringFormatArray(prepareGameBySelectingMenu.getGame().getModel().getGameSquares());//  print game squares
//                System.out.println(textWillAppendToFile);
            }
        };

    }

    void addSquaresToAnchorPane() {
//        VBox vBox = createSquares();
        createSquares();
//        allSquares.setPrefSize(anchorPaneForButtons.getPrefWidth(), anchorPaneForButtons.getPrefHeight());
//        double paddingLeftSpace = 520 - (edgeValue - 5) * 35;
//        double paddingTopSpace = 30 + (10 - edgeValue) * 30;
//        vBox.setPadding(new Insets(0, 10, 10, 10));
        //10 --> 320
        // 9 355
        //8 --> 415
        //6-->490
        // 5 --> 535

//        System.out.println("gelen Vbox : " + vBoxToCenterButtons.getAlignment().toString());
//        anchorPaneForButtons.getChildren().add(vBox);
    }


//    public void setEdgeValue(int edgeValue) {
//        this.edgeValue = edgeValue;
//    }

    void resetGame() {
        vBoxToCenterButtons.getChildren().removeAll(vBoxToCenterButtons.getChildren());
        addSquaresToAnchorPane();
        prepareGameBySelectingMenu.getGame().resetRoundCounter();
        prepareGameBySelectingMenu.startGame();
        prepareGameBySelectingMenu.getPlayer().setStep(0);
        updateCurrentValue();
        updateStepValue();
        updateTotalFinishedScore();

    }

    void printModel() {
        String textWillAppendToFile = new StringFormat().getStringFormatArray(prepareGameBySelectingMenu.getGame().getModel().getGameSquares());//  print game squares
        System.out.println(textWillAppendToFile);
    }

    void updateCurrentValue() {
        lblCurrentStepValue.setText(prepareGameBySelectingMenu.getPlayer().getStep() + "");
    }

    void updateStepValue() {
        lblTotalStepValue.setText(prepareGameBySelectingMenu.getGame().getRoundCounter() + "");
    }

    void updateTotalFinishedScore() {
        lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "");
    }

    void paintHintButton() {
        vBoxToCenterButtons.getChildren();

        for (int i = vBoxToCenterButtons.getChildren().size() - 1; i >= 0; i--) {
//            System.out.println(vBoxToCenterButtons.getChildren().toString());
//            System.out.println(vBoxToCenterButtons.toString());
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

    void updateOldHintButtons() {
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
}

