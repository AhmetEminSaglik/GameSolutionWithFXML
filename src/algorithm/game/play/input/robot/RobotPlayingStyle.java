package algorithm.game.play.input.robot;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.Move;
import algorithm.game.play.PrepareGame;
import algorithm.game.play.input.PlayerPlayingStyle;
import javafx.application.Platform;
import scene.game.SquareButton;

public class RobotPlayingStyle extends PlayerPlayingStyle {

    PrepareGame prepareGame;
    boolean moveForward = true;

    @Override
    public void startGame() {
        System.out.println("start game geldi");
        prepareGame = new PrepareGame(player.getGame());
        prepareGame.prepareToPlay(0, 0);
        prepareGameBySelectingMenu.getGame().increaseRoundCounter();
        Move moveForwardOrBack;
        Game game = player.getGame();
        gameController.printModel();
        getCurrentSquareBtn().setText(player.getStep() + "");
        gameController.paintCurrentButton();
        listMovedSquareBtn.add(getCurrentSquareBtn());
        gameController.paintHintButton();
        gameController.updateOldHintButtons();


        while (!player.getGameRule().isGameOver(game)) {


            listMovedSquareBtn.get(listLastIndex()).setId(VISITED_BEFORE_BTN_ID);


            int choose = player.getInput(game);
            moveForwardOrBack = getMoveBackOrForward(choose);
            moveForwardOrBack.move(
                    new DirectionLocation().
                            getLocationValueAccordingToEnteredValue(game, choose));
//            ShowPanel.show(getClass(), "moveForwardOrBack.getClass().getTypeName().equals(MoveForward.class.getTypeName()) : " + moveForwardOrBack.getClass().getTypeName().equals(MoveForward.class.getTypeName()) + "\n" +
//                    "moveForwardOrBack.getClass().getTypeName() : " + moveForwardOrBack.getClass().getTypeName());
            if (moveForward) {
                gameController.paintCurrentButton();
                Platform.runLater(() -> {
                    getCurrentSquareBtn().setText(player.getStep() + "");
                });
                gameController.paintHintButton();
                game.increaseRoundCounter();
                listMovedSquareBtn.add(getCurrentSquareBtn());

            } else {
                ShowPanel.show(getClass(), "GERI ADIM ATIYOR");
                listMovedSquareBtn.remove(getCurrentSquareBtn());
                gameController.paintNormalBtn();
                Platform.runLater(() -> {
                    getCurrentSquareBtn().setText("");

                });
                listMovedSquareBtn.get(listLastIndex()).setId(CURRENT_BTN_ID);
            }

            try {
//                gameController
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            gameController.printModel();
            Platform.runLater(() -> {
                getCurrentSquareBtn().setText(player.getStep() + "");
                gameController.updateStepValue();
                gameController.updateCurrentValue();
                gameController.updateOldHintButtons();
            });


        }

    }

    SquareButton getCurrentSquareBtn() {
        return squareButtonArray[player.getLocation().getX()][player.getLocation().getY()];
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

    }

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            moveForward = false;
            return player.getPlayerMove().getMoveBack();
        }
        moveForward = true;
        return player.getPlayerMove().getMoveForward();
    }


}
