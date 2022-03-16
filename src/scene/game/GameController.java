package scene.game;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.play.input.PlayerPlayingStyle;
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
    //    public SquareButton squareButtonArray[][];
    public FxmlSquareBtnCommunity squareBtnCommunity = new FxmlSquareBtnCommunity();
    private PrepareGameBySelectingMenu prepareGameBySelectingMenu;

    @FXML
    private Label lblTimeField;
    @FXML
    public Label lblTotalStepValue;
    @FXML
    public Label lblCurrentStepValue;
    Runnable runnable;
    @FXML
    public Label lblScoreValue;
    //TODO buraya person'un buldugu degerleri ayni olmayacak sekilde ayirt etmek icin liste eklenip icine skorlar eklenip karsilastirilabilir
    /*public ExecutorService executorService = Executors.newFixedThreadPool(1, r -> {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    });*/

    public GameController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
        this.edgeValue = prepareGameBySelectingMenu.getEdgeValue();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startTiming();


//        getPrepareGameBySelectingMenu().getPlayer().getTimeKeeper().startTime();
//        Platform.runLater(() -> {
<<<<<<< HEAD
        addSquaresToAnchorPane();
=======
            addSquaresToAnchorPane();
>>>>>>> 21b5af56cce1501002e6dee5571d4eb2c4f0b46c
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//            System.out.println(" player : "+prepareGameBySelectingMenu.getPlayer().getClass().getName());

        prepareGameBySelectingMenu.getPlayerPlayingStyle().setGameController(this);
        prepareGameBySelectingMenu.prepareGame();

        /*ExecutorService executorService = Executors.newFixedThreadPool(1, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
//            while ((!player.getGameRule().isGameOver(game))) {
//                thread.start();
//            }
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return thread;
        });*/

        new Thread(() -> prepareGameBySelectingMenu.getPlayerPlayingStyle().startGame()).start();
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                prepareGameBySelectingMenu.getPlayerPlayingStyle().startGame();
            }
        };
        executorService.execute(runnable);*/

//executorService.ad
//        prepareGameBySelectingMenu.getPlayerPlayingStyle().startGame();

        //            ShowPanel.show(getClass()," 1-) Robot geri adim atamiyor,\n" +
//                    "2-) max sayiya ulasinda  visited area'ya  max degeri koyup true yapmaya calisiyor. ");

//                }
//            }).start();

//        });
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
//        prepareGameBySelectingMenu.getPlayerPlayingStyle().setGameController(this);
        return new EventHandler<>() {
            @Override
            public void handle(Event event) {

                prepareGameBySelectingMenu.getPlayerPlayingStyle().play(button);
//                System.out.println("TIklanilan deger;" + button.getX() + "-" + button.getY());
//                paintHintButtonsOfCurrentBtn();
//                printModel();
//                ShowPanel.show(getClass(),"GUNCELLENDIM I ");

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
    }

    public void printModel() {
        String textWillAppendToFile = " Round Counter : " + prepareGameBySelectingMenu.getGame().getRoundCounter() + "\n";
        textWillAppendToFile += new StringFormat().getStringFormatArray(prepareGameBySelectingMenu.getGame().getModel().getGameSquares());//  print game squares
        System.out.println(textWillAppendToFile);
    }


    public void updateLabelCurrentValue() {
//        runnable = () -> lblCurrentStepValue.setText(prepareGameBySelectingMenu.getPlayer().getStep() + "");

        runnable = () -> {

//            Platform.runLater(() -> {
            lblCurrentStepValue.setText(prepareGameBySelectingMenu.getPlayer().getStep() + "");
//            prepareGameBySelectingMenu.getPlayerPlayingStyle().movementLocked = false;
//            unLocked1 = true;
//            });
        };
//        Callable callable =new Callable() {
//        }
        runFunctionInPlatformThread(runnable);
    }

    public void updateLabelTotalStepValue() {

        runnable = () -> {
            lblTotalStepValue.setText(prepareGameBySelectingMenu.getGame().getRoundCounter() + "");
//            unLocked2 = true;
        };
//        runnable = () -> {
//            Platform.runLater(() -> lblTotalStepValue.setText(prepareGameBySelectingMenu.getGame().getRoundCounter() + ""));
//        };
        runFunctionInPlatformThread(runnable);
    }

    public void updateTotalFinishedScore() {
        runnable = () -> {
            lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "");
//            unLocked2cked3 = true;
        };
//        Callable callable = new Callable() {
//            @Override
//            public Object call() throws Exception {
//                lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "")
//                return "updateTotalFinishedScore calisti";
//            }
//        };
//        runnable = () -> {
//            Platform.runLater(() -> lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + ""));
//        };
        runFunctionInPlatformThread(runnable);
    }

//    private boolean unLocked1 = false, unLocked2 = false, unLocked3 = false, unLocked4 = false, unLocked5 = false, unLocked6 = false;

    /*void decidePlayerMovementLockResult() {
        if (unLocked1 && unLocked2 && unLocked3 && unLocked4 && unLocked5 && unLocked6 ) {
            getPrepareGameBySelectingMenu().getPlayerPlayingStyle().movementLocked = false;
        } else {
            System.out.println("unLocked6 : " + unLocked6);
            System.out.println("unLocked5 : " + unLocked5);
            System.out.println("unLocked4 : " + unLocked4);
            System.out.println("unLocked3 : " + unLocked3);
            System.out.println("unLocked2 : " + unLocked2);
            System.out.println("unLocked1 : " + unLocked1);
        }

        System.out.println("Sonuc : " + getPrepareGameBySelectingMenu().getPlayerPlayingStyle().movementLocked);

    }
*/
//    static int counter = 0;

    public void runFunctionInPlatformThread(Runnable runnable) {
//        try {
//            callable.call();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//Runnable        Platform.setImplicitExit(false);
//        Runnable runnableForExecuteService = new Runnable() {
//            @Override
//            public void run() {
        Platform.runLater(() -> {
            runnable.run();
//            if (counter % 3 == 0)
//                getPrepareGameBySelectingMenu().getPlayerPlayingStyle().movementLocked = false;
//            System.out.println("geldi : " + counter++);
//            System.out.println( "GELDII");
//            decidePlayerMovementLockResult();
        });

//            }
//        };

//        executorService.execute(runnable);
    }

    boolean timerStarted = false;

    public void startTiming() {
        if (timerStarted == false) {
            Timer timer = new Timer();
            TimerTask printElapsedTime = new ElapsedTimePrinter(lblTimeField);
            timer.schedule(printElapsedTime, 0, 1);
            timerStarted = true;
        }
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
//            unLocked4 = true;
        } catch (ConcurrentModificationException e) {
            System.err.println(e.getMessage());

<<<<<<< HEAD

            /*runnable = new Runnable() {
                @Override
                public void run() {

                }
            };*/
        /*Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                squareButton.setId(btnId);
                return "paintSquareBtn calisti";
            }
        };*/
=======
//
//            runnable = new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            };
//            runFunctionInPlatformThread(runnable);
>>>>>>> 21b5af56cce1501002e6dee5571d4eb2c4f0b46c
            runnable = new Runnable() {
                @Override
                public void run() {
                    squareButton.setId(btnId);
//                    unLocked4 = true;

                }
            };
//            runnable = () -> {
//                Platform.runLater(() -> squareButton.setId(btnId));
//            };
            runFunctionInPlatformThread(runnable);
//            runFunctionInPlatformThread(runnable);
        }

    }

    public void setStepValueToSquareBtnAsAText(SquareButton squareButton) {
        runnable = () -> {
            squareButton.setText(prepareGameBySelectingMenu.getPlayer().getStep() + "");
//            unLocked5 = true;
        };
//        runnable = () -> {
//            Platform.runLater(() -> squareButton.setText(prepareGameBySelectingMenu.getPlayer().getStep() + ""));
//            ShowPanel.show(getClass()," btn text degismeli");
//
//        };

//        Callable callable=new Callable() {
//            @Override
//            public Object call() throws Exception {
//                squareButton.setText(prepareGameBySelectingMenu.getPlayer().getStep() + "");
//                return  "setStepValueToSquareBtnAsAText calisti";
//            }
//        };
        runFunctionInPlatformThread(runnable);
    }

    public void clearStepValueOfSquareBtnAsAText(SquareButton squareButton) {
        runnable = () -> {
            squareButton.setText("");
//            unLocked6 = true;
//            System.out.println("6. lock acildiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        };
//        runnable = () -> {
//            Platform.runLater(() -> squareButton.setText(""));
//        };
//        Callable callable = new Callable() {
//            @Override
//            public Object call() throws Exception {
//                squareButton.setText("");
//                return "clearStepValueOfSquareBtnAsAText calisti";
//            }
//        };
        runFunctionInPlatformThread(runnable);
    }

    public void paintHintButtonsOfCurrentBtn() {
//        vBoxToCenterButtons.getChildren();
/*
        for (int i = vBoxToCenterButtons.getChildren().size() - 1; i >= 0; i--) {
            HBox hBox = (HBox) vBoxToCenterButtons.getChildren().get(i);
            for (int j = 0; j < hBox.getChildren().size(); j++) {
                SquareButton squareButton = (SquareButton) hBox.getChildren().get(j);

                if (isOneOfTheHintButton(squareButton)) {
                    squareButton.setId(PlayerPlayingStyle.HINT_BTN_ID);
                    System.out.println(" hint btn : " + squareButton.getX() + "-" + squareButton.getY());

                }
            }
        }*/
        List<DirectionLocation> list = new LocationsList().getListOfLocationsAccordingToPlayerCompass(prepareGameBySelectingMenu.getPlayer().getCompass());
        list.remove(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            int x = prepareGameBySelectingMenu.getPlayer().getLocation().getX() + list.get(i).getX();
            int y = prepareGameBySelectingMenu.getPlayer().getLocation().getY() + list.get(i).getY();
            if (x >= 0 && x < edgeValue && y >= 0 && y < edgeValue) {
                determineHintBtn(x, y);
//                ShowPanel.show(getClass(),"Buraya geldi");
            }
        }
    }

    public void paintCurrentButton() {
//        paintButton(PlayerPlayingStyle.CURRENT_BTN_ID);
        squareBtnCommunity.squareButtonArray
                [prepareGameBySelectingMenu.getPlayer().getLocation().getX()]
                [prepareGameBySelectingMenu.getPlayer().getLocation().getY()]
                .setId(PlayerPlayingStyle.CURRENT_BTN_ID);
    }
  /*  public void paintButton(String btnId) {
        squareButtonArray
                [prepareGameBySelectingMenu.getPlayer().getLocation().getX()]
                [prepareGameBySelectingMenu.getPlayer().getLocation().getY()]
                .setId(btnId);
    }
*/

    void determineHintBtn(int x, int y) {
        if (!squareBtnCommunity.squareButtonArray[x][y].getId().equals(PlayerPlayingStyle.VISITED_BEFORE_BTN_ID))
            paintSquareBtnTo_HintBtn(squareBtnCommunity.squareButtonArray[x][y]);
//            squareBtnCommunity.squareButtonArray[x][y].setId(PlayerPlayingStyle.HINT_BTN_ID);

    }

   /* boolean isOneOfTheHintButton(SquareButton squareButton) {
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
    }*/

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
}

