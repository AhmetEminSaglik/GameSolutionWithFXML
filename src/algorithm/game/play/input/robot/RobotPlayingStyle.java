package algorithm.game.play.input.robot;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.move.Move;
import algorithm.game.play.input.PlayerPlayingStyle;
import algorithm.sleep.Sleep;
import scene.game.SquareButton;


public class RobotPlayingStyle extends PlayerPlayingStyle {
    /*
    esculator servisler
    * */
    int sleepTime = 125;
    Sleep sleep = new Sleep();
    @Override
    public void startGame() {
        game = player.getGame();


        fillFxmlMoveForward();
        fxmlMoveForwardOrBack = fxmlMoveForward;
        fxmlMoveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocation(player));
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

        fillFxmlMoveForward();
        fillFxmlMoveBack();

        while (!player.getGameRule().isGameOver(game)) {
            if (movementLocked == UNLOCK) {
                playRobot();
            } else {
                System.out.print("");
            }

        }

    }

    void playRobot() {
//        if (game.getPlayer().getStep() == 100 && game.getPlayer().getScore().getTotalGameFinishedScore() <= 3) {
//            ShowPanel.show("Completed : " + game.getPlayer().getScore().getTotalGameFinishedScore());
//        }
        movementLocked = PlayerPlayingStyle.LOCK;

        int choose = player.getInput(game);
        fxmlMoveForwardOrBack = getFxmlMoveBackOrForward(choose);
        DirectionLocation directionLocationToMove = new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose);
        fxmlMoveForwardOrBack.move(directionLocationToMove);
        checkStatus();

    }
    public void checkStatus() {
        Runnable runnable = () -> {
            if (prepareGameBySelectingMenu.getPlayer().getStep() == prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue()) {
                game.getPlayer().getScore().increaseTotalGameFinishedScore();
                gameController.updateTotalFinishedScore();

            }
            movementLocked = PlayerPlayingStyle.UNLOCK;
            sleep.sleep(5);
        };

        gameController.runFunctionInPlatformThread(runnable);
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

}
