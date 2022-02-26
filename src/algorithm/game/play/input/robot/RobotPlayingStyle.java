package algorithm.game.play.input.robot;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.move.Move;
import algorithm.game.play.input.PlayerPlayingStyle;
import fxmlmove.FxmlMove;
import scene.game.SquareButton;

public class RobotPlayingStyle extends PlayerPlayingStyle {

    int sleepTime = 100;

    @Override
    public void startGame() {
        game = player.getGame();
        fillFxmlMoveForward();


        fxmlMoveForwardOrBack = fxmlMoveForward;

//        fxmlMoveForwardOrBack.setUpdateValuesInGameModel(player.getPlayerMove().getMoveForward().getUpdateValuesInGameModel());
        fxmlMoveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocation(player));
        System.out.println(fxmlMoveForwardOrBack.getChangePlayerLocation());

        DirectionLocation directionLocation = new DirectionLocation();
        directionLocation.setX(0);
        directionLocation.setY(0);

        fxmlMoveForwardOrBack.move(directionLocation);


        updateChangePlayerLocationFunctionOfFxmlMove(fxmlMoveForward, new ChangeLocationByAdding(player));
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ShowPanel.show(getClass()," person da create last location id -1 donuyor sorun yok ama robotta -1 donunce patliiyor");

        fillFxmlMoveForward();
        fillFxmlMoveBack();
        while (!player.getGameRule().isGameOver(game)) {

            playRobot();

        }


    }

    synchronized void playRobot() {
//            squareBtnCommunity.listMovedSquareBtn.get(listLastIndex()).setId(VISITED_BEFORE_BTN_ID);
        int choose = player.getInput(game);
        System.out.println("GELEN CHOOSE : " + choose);
//            fxmlMoveForwardOrBack = getMoveBackOrForward(choose);
//        fxmlMoveForwardOrBack = getMoveBackOrForward(choose);
        /*Move moveForwardOrBack = getMoveBackOrForward(choose);
        moveForwardOrBack.move(new DirectionLocation().
                getLocationValueAccordingToEnteredValue(game, choose));*/
        fxmlMoveForwardOrBack = getFxmlMoveBackOrForward(choose);
//        ShowPanel.show(getClass(),"gelen yon > "+fxmlMoveForwardOrBack.toString());
        System.out.println("gelen deger  toString() : " + fxmlMoveForwardOrBack.toString());
        System.out.println("gelen deger  name : " + fxmlMoveForwardOrBack.getClass().getName());
//        System.out.println(fxmlMoveForwardOrBack.toString());
//        DirectionLocation directionLocation = new DirectionLocation();
//        directionLocation.setCompass(player.getCompass());
//        directionLocation.getLocationValueAccordingToEnteredValue(game, choose);
//        System.out.println("choose : " + choose);
//        System.out.println("direction  1 -) :"+directionLocation.toString());
//        System.out.println("direction  2 -) :"+directionLocation.getLocationValueAccordingToEnteredValue(game,choose).toString());
//        System.out.println("direction  3 -) :"+new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose).toString());
        fxmlMoveForwardOrBack = getFxmlMoveBackOrForward(choose);
        System.out.print("islem yapilacak game  :");
        game.printGameAdress();
//        if (fxmlMoveForwardOrBack == fxmlMoveBack) {
//            ShowPanel.show(getClass(), " GERI ADIM ATRACKA gelen chose : " + choose);
//        }
        System.out.println("gelen choose : " + choose);
        DirectionLocation directionLocationToMove = new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose);
        fxmlMoveForwardOrBack.move(directionLocationToMove);
//        if (choose == player.getCompass().getLastLocation()) {
//            fxmlMoveBack.move(directionLocationToMove);
//        } else {
//            fxmlMoveForward.move(directionLocationToMove);
//        }
        /*fxmlMoveForwardOrBack.move(
                new DirectionLocation().
                        getLocationValueAccordingToEnteredValue(game, choose));*/
//        System.out.println("while ici  moveForwardOrBack (move sonrasi)  : " + fxmlMoveForwardOrBack.getClass().getName());
//            ShowPanel.show(getClass(), "moveForwardOrBack.getClass().3getTypeName().equals(MoveForward.class.getTypeName()) : " + moveForwardOrBack.getClass().getTypeName().equals(MoveForward.class.getTypeName()) + "\n" +
//                    "moveForwardOrBack.getClass().getTypeName() : " + moveForwardOrBack.getClass().getTypeName());
           /* if (moveForward) {
                gameController.paintCurrentButton();
                gameController.setStepValueToSquareBtnAsAText(getCurrentSquareBtn());
                gameController.paintHintButtonsOfCurrentBtn();
                game.increaseRoundCounter();
                squareBtnCommunity.listMovedSquareBtn.add(getCurrentSquareBtn());

            } else {
                ShowPanel.show(getClass(), "GERI ADIM ATIYOR");
                squareBtnCommunity.listMovedSquareBtn.remove(getCurrentSquareBtn());
                gameController.paintNormalBtn();
                Platform.runLater(() -> {
                    getCurrentSquareBtn().setText("");

                });
                squareBtnCommunity.listMovedSquareBtn.get(listLastIndex()).setId(CURRENT_BTN_ID);
            }*/

        checkStatus();
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//            gameController.printModel();
          /*  Platform.runLater(() -> {
                getCurrentSquareBtn().setText(player.getStep() + "");
                gameController.updateLabelTotalStepValue();
                gameController.updateLabelCurrentValue();
                gameController.clearOldHintButtons();
            });*/

//        if (player.getStep() == gameController.getPrepareGameBySelectingMenu().getEdgeValue() * gameController.getPrepareGameBySelectingMenu().getEdgeValue()) {
//            ShowPanel.show(getClass(), " DURRRRRRRR " + (gameController.getPrepareGameBySelectingMenu().getEdgeValue() * gameController.getPrepareGameBySelectingMenu().getEdgeValue()) + " oldu");
//        }
        if (player.getStep() == gameController.getPrepareGameBySelectingMenu().getEdgeValue() * gameController.getPrepareGameBySelectingMenu().getEdgeValue()) {
            maxSayioldu = true;
        }
        if (maxSayioldu) {
            System.out.println(" adim sayisi  en az 1 kere max sayiya esit oldu : ");
        }
        gameController.printModel();
//        notify();
    }

    public void checkStatus() {
        Runnable runnable = () -> {
            if (prepareGameBySelectingMenu.getPlayer().getStep() == prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue()) {
//                    ShowPanel.show(getClass(), "Tebrikler butun bosluklari doldurdunuz.");

                game.getPlayer().getScore().increaseTotalGameFinishedScore();
                gameController.updateTotalFinishedScore();

//                gameController.lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "");
            }
//                else {
//                    ShowPanel.show(getClass(), " Game Over Step deger i : " + prepareGameBySelectingMenu.getPlayer().getStep());
//                    gameController.resetGame();
//                }
//            if (prepareGameBySelectingMenu.getPlayer().getStep() == 100) {
//                ShowPanel.show(getClass(), " 100 oldu deger artmis olmasi lazim\n" +
//                        "prepareGameBySelectingMenu.getPlayer().getStep()  : " + prepareGameBySelectingMenu.getPlayer().getStep() + "\n" +
//                        "prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue() : " + prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue());
//            }
        };
        gameController.runFunctionInPlatformThread(runnable);
    }

    boolean maxSayioldu = false;

    SquareButton getCurrentSquareBtn() {
        return squareBtnCommunity.squareButtonArray[player.getLocation().getX()][player.getLocation().getY()];
    }

    public RobotPlayingStyle(Player player) {
        super(player);
    }

    @Override
    public void play(SquareButton button) {
        System.out.println("robot burada oynicak");
    }

    @Override
    public void stepBack() {
        System.out.println("bu buton calismicak");
    }

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return player.getPlayerMove().getMoveBack();
        }
        return player.getPlayerMove().getMoveForward();
    }

  /*  FxmlMove getFxmlMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
//            fxmlMoveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(player.getGame(),
//                    new LocationsList().getLastLocation(player.getCompass()).getId()));
            return fxmlMoveBack;
        }
        return fxmlMoveForward;
    }*/
/*
    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
//            moveForward = false;
            return player.getPlayerMove().getMoveBack();
        }
//        DirectionLocation directionLocation= new DirectionLocation();
//        directionLocation.setCompass(player.getCompass());
//        System.out.println(directionLocation.getLocationValueAccordingToEnteredValue(game,index));
//        moveForward = true;

        return player.getPlayerMove().getMoveForward();
    }*/


}
