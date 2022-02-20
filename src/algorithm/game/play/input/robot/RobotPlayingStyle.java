package algorithm.game.play.input.robot;

import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.Move;
import algorithm.game.play.input.PlayerPlayingStyle;
import fxmlmove.FxmlMove;
import scene.game.SquareButton;

public class RobotPlayingStyle extends PlayerPlayingStyle {

    int sleepTime = 2000;
//    PrepareGame prepareGame;
//    boolean moveForward = true;

    Move moveForwardOrBack;

    @Override
    public void startGame() {
        game = player.getGame();
        fillFxmlMoveForward();
        fillFxmlMoveBack();
//        setFxmlMoveBack(new FxmlMoveBack(gameController));
//        getFxmlMoveBack().setChangePlayerLocation(new ChangeLocationByAdding(player));
//        setFxmlMoveForward(new FxmlMoveForward(gameController));
//        getFxmlMoveForward().setChangePlayerLocation(new ChangeLocationByAdding(player));
//        Robot robot = (Robot) player;
//        fillForwardAndBackMoveReferances(new FxmlMoveForward<MoveForwardSecondSolution>(gameController), new FxmlMoveBack<MoveBackSecondSolution>(gameController));

//        fillForwardAndBackMoveReferances();
//        player.setPlayerMove(new );



     /*   System.out.println("start game geldi");
        prepareGame = new PrepareGame(player.getGame());
        prepareGame.prepareToPlay(0, 0);
        prepareGameBySelectingMenu.getGame().increaseRoundCounter();

        Game game = player.getGame();
        gameController.printModel();
        gameController.setStepValueToSquareBtnAsAText(getCurrentSquareBtn());
        gameController.paintCurrentButton();
        squareBtnCommunity.listMovedSquareBtn.add(getCurrentSquareBtn());
        gameController.paintHintButtonsOfCurrentBtn();
        gameController.clearOldHintButtons();*/

//        squareBtnCommunity.listMovedSquareBtn.add(getCurrentSquareBtn());
//        moveForwardOrBack = player.getPlayerMove().getMoveForward();
//        System.out.println("while oncesi moveForwardOrBack : "+moveForwardOrBack.getClass().getName());
//        moveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocation(player));
//        DirectionLocation directionLocation = new DirectionLocation();
//        directionLocation.setX(0);
//        directionLocation.setY(0);
//        moveForwardOrBack.move(directionLocation);
//        try {
//                gameController
//            Thread.sleep(sleepTime);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while (!player.getGameRule().isGameOver(game)) {


//            squareBtnCommunity.listMovedSquareBtn.get(listLastIndex()).setId(VISITED_BEFORE_BTN_ID);


            int choose = player.getInput(game);
            System.out.println("GELEN CHOOSE : " + choose);
//            fxmlMoveForwardOrBack = getMoveBackOrForward(choose);
            moveForwardOrBack = getMoveBackOrForward(choose);
            moveForwardOrBack.move(
                    new DirectionLocation().
                            getLocationValueAccordingToEnteredValue(game, choose));
            System.out.println("while ici  moveForwardOrBack (move sonrasi)  : " + moveForwardOrBack.getClass().getName());
//            ShowPanel.show(getClass(), "moveForwardOrBack.getClass().getTypeName().equals(MoveForward.class.getTypeName()) : " + moveForwardOrBack.getClass().getTypeName().equals(MoveForward.class.getTypeName()) + "\n" +
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
//                gameController
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
                maxSayioldu = true;
            }
            if (maxSayioldu) {
                System.out.println(" adim sayisi  en az 1 kere max sayiya esit oldu : ");
            }
        }

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

    FxmlMove getMoveBackOrForward(int index) {
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
