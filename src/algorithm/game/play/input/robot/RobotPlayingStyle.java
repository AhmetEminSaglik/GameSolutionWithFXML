package algorithm.game.play.input.robot;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.move.Move;
import algorithm.game.play.input.PlayerPlayingStyle;
import fxmlmove.FxmlMove;
import scene.game.SquareButton;

public class RobotPlayingStyle extends PlayerPlayingStyle {

    int sleepTime = 500;

    @Override
    public void startGame() {
        game = player.getGame();
        fillFxmlMoveForward();
        fillFxmlMoveBack();

        fxmlMoveForwardOrBack = fxmlMoveForward;

        fxmlMoveForwardOrBack.setUpdateValuesInGameModel(player.getPlayerMove().getMoveForward().getUpdateValuesInGameModel());
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
        DirectionLocation directionLocation = new DirectionLocation();
        directionLocation.setCompass(player.getCompass());
        directionLocation.getLocationValueAccordingToEnteredValue(game,choose);
        System.out.println("direction  1 -) :"+directionLocation.toString());
        System.out.println("direction  2 -) :"+directionLocation.getLocationValueAccordingToEnteredValue(game,choose).toString());
        System.out.println("direction  3 -) :"+new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose).toString());
        fxmlMoveForward.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose));
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

        if (player.getStep() == gameController.getPrepareGameBySelectingMenu().getEdgeValue() * gameController.getPrepareGameBySelectingMenu().getEdgeValue()) {
            ShowPanel.show(getClass(), " DURRRRRRRR "+(gameController.getPrepareGameBySelectingMenu().getEdgeValue() * gameController.getPrepareGameBySelectingMenu().getEdgeValue())+" oldu");
        }
        if (player.getStep() == gameController.getPrepareGameBySelectingMenu().getEdgeValue() * gameController.getPrepareGameBySelectingMenu().getEdgeValue()) {
            maxSayioldu = true;
        }
        if (maxSayioldu) {
            System.out.println(" adim sayisi  en az 1 kere max sayiya esit oldu : ");
        }
        gameController.printModel();
//        notify();
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

    FxmlMove getFxmlMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return fxmlMoveBack;
        }
        return fxmlMoveForward;
    }
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
