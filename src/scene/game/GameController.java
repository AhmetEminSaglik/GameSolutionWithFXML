package scene.game;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.play.input.PlayerPlayingStyle;
import algorithm.print.EasylyReadNumber;
import algorithm.printarray.StringFormat;
import fxmlmove.FxmlSquareBtnCommunity;
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
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameController extends BaseSceneController {
    @FXML
    public AnchorPane anchorPaneForButtons;
    private int edgeValue;
    @FXML
    private VBox vBoxToCenterButtons;
    public FxmlSquareBtnCommunity squareBtnCommunity = new FxmlSquareBtnCommunity();
    private PrepareGameBySelectingMenu prepareGameBySelectingMenu;

    @FXML
    private Label lblTimeField;
    @FXML
    private Label lblPlayerName;
    @FXML
    public Label lblTotalStepValue;
    @FXML
    public Label lblCurrentStepValue;
    Runnable runnable;
    ElapsedTimePrinter elapsedTime;
    Timer timer;
    @FXML
    public Label lblScoreValue;
    private EasylyReadNumber easylyReadNumber = new EasylyReadNumber();

    public GameController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
        this.edgeValue = prepareGameBySelectingMenu.getEdgeValue();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startTiming();

        lblPlayerName.setText(getPrepareGameBySelectingMenu().getPlayer().getName());

        addSquaresToAnchorPane();
        prepareGameBySelectingMenu.getPlayerPlayingStyle().setGameController(this);
        prepareGameBySelectingMenu.prepareGame();



        new Thread(() -> prepareGameBySelectingMenu.getPlayerPlayingStyle().startGame()).start();

    }

    @FXML
    void goMainMenu(ActionEvent event) {
        stopTiming();
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

        squareBtnCommunity.squareButtonArray = new SquareButton[edgeValue][edgeValue];
        for (int y = edgeValue - 1; y >= 0; y--) {
            HBox hBox = new HBox(space);
            hBox.setAlignment(Pos.CENTER);
            for (int x = 0; x < edgeValue; x++) {
                SquareButton squareButton = new SquareButton(x, y);
                squareButton.setOnAction(getValueOfButton(squareButton));
                hBox.getChildren().add(squareButton);
                squareBtnCommunity.squareButtonArray[x][y] = squareButton;
            }
            vBoxToCenterButtons.getChildren().add(hBox);
        }
    }


    EventHandler getValueOfButton(SquareButton button) {
        return new EventHandler<>() {
            @Override
            public void handle(Event event) {

                prepareGameBySelectingMenu.getPlayerPlayingStyle().play(button);
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
        prepareGameBySelectingMenu.prepareGame();
        prepareGameBySelectingMenu.getPlayer().setStep(0);
        updateLabelCurrentValue();
        updateLabelTotalStepValue();
        updateTotalFinishedScore();
        stopTiming();
        startTiming();
    }

    public void printModel() {
        String textWillAppendToFile = " Round Counter : " + prepareGameBySelectingMenu.getGame().getRoundCounter() + "\n";
        textWillAppendToFile += new StringFormat().getStringFormatArray(prepareGameBySelectingMenu.getGame().getModel().getGameSquares());//  print game squares
        System.out.println(textWillAppendToFile);
    }


    public void updateLabelCurrentValue() {

        runnable = () -> {
            lblCurrentStepValue.setText(getEasyReadyNumber(prepareGameBySelectingMenu.getPlayer().getStep()));
        };
        runFunctionInPlatformThread(runnable);
    }

    public void updateLabelTotalStepValue() {

        runnable = () -> {

            lblTotalStepValue.setText(getEasyReadyNumber(prepareGameBySelectingMenu.getGame().getRoundCounter()));
        };
        runFunctionInPlatformThread(runnable);
    }

    public void updateTotalFinishedScore() {
        runnable = () -> {
            lblScoreValue.setText(getEasyReadyNumber(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore()));
        };
        runFunctionInPlatformThread(runnable);
    }



    public void runFunctionInPlatformThread(Runnable runnable) {
        Platform.runLater(() -> {
            runnable.run();
        });
    }

    boolean timerStarted = false;

    public void startTiming() {
        if (timerStarted == false) {
            timer = new Timer();
            elapsedTime = new ElapsedTimePrinter(lblTimeField);
            timer.schedule(elapsedTime, 0, 1);
            timerStarted = true;
        }
    }

    public void stopTiming() {
        timerStarted = false;
        timer.cancel();
    }

    public void paintNormalBtn() {
        squareBtnCommunity.squareButtonArray
                [prepareGameBySelectingMenu.getPlayer().getLocation().getX()]
                [prepareGameBySelectingMenu.getPlayer().getLocation().getY()]
                .setId(PlayerPlayingStyle.NORMAL_SQUARE_BTN_ID);
    }


    public void paintSquareBtnTo_CurrentBtn(SquareButton squareButton) {
        paintSquareBtn(squareButton, PlayerPlayingStyle.CURRENT_BTN_ID);
    }

    public void paintSquareBtnTo_NormalSquareBtn(SquareButton squareButton) {
        paintSquareBtn(squareButton, PlayerPlayingStyle.NORMAL_SQUARE_BTN_ID);
    }

    public void paintSquareBtnTo_VisitedBeforeBtn(SquareButton squareButton) {
        paintSquareBtn(squareButton, PlayerPlayingStyle.VISITED_BEFORE_BTN_ID);
    }

    public void paintSquareBtnTo_HintBtn(SquareButton squareButton) {
        paintSquareBtn(squareButton, PlayerPlayingStyle.HINT_BTN_ID);
    }

    public void paintSquareBtn(SquareButton squareButton, String btnId) {
        try {
            squareButton.setId(btnId);
        } catch (ConcurrentModificationException e) {
            System.err.println(e.getMessage());
            runnable = new Runnable() {
                @Override
                public void run() {
                    squareButton.setId(btnId);
                }
            };
            runFunctionInPlatformThread(runnable);
        }

    }

    public void setStepValueToSquareBtnAsAText(SquareButton squareButton) {
        runnable = () -> {
            squareButton.setText(prepareGameBySelectingMenu.getPlayer().getStep() + "");
        };
        runFunctionInPlatformThread(runnable);
    }

    public void clearStepValueOfSquareBtnAsAText(SquareButton squareButton) {
        runnable = () -> {
            squareButton.setText("");
        };
        runFunctionInPlatformThread(runnable);
    }

    public void paintHintButtonsOfCurrentBtn() {
        List<DirectionLocation> list = new LocationsList().getListOfLocationsAccordingToPlayerCompass(prepareGameBySelectingMenu.getPlayer().getCompass());
        list.remove(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            int x = prepareGameBySelectingMenu.getPlayer().getLocation().getX() + list.get(i).getX();
            int y = prepareGameBySelectingMenu.getPlayer().getLocation().getY() + list.get(i).getY();
            if (x >= 0 && x < edgeValue && y >= 0 && y < edgeValue) {
                determineHintBtn(x, y);
            }
        }
    }

    public void paintCurrentButton() {
        squareBtnCommunity.squareButtonArray
                [prepareGameBySelectingMenu.getPlayer().getLocation().getX()]
                [prepareGameBySelectingMenu.getPlayer().getLocation().getY()]
                .setId(PlayerPlayingStyle.CURRENT_BTN_ID);
    }

    void determineHintBtn(int x, int y) {
        if (!squareBtnCommunity.squareButtonArray[x][y].getId().equals(PlayerPlayingStyle.VISITED_BEFORE_BTN_ID))
            paintSquareBtnTo_HintBtn(squareBtnCommunity.squareButtonArray[x][y]);

    }

    public void clearOldHintButtons() {
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

    String getEasyReadyNumber(long number) {
        return easylyReadNumber.getReadableNumberInStringFormat(number);
    }

    public ElapsedTimePrinter getElapsedTime() {
        return elapsedTime;
    }
}

