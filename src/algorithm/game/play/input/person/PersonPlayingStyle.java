package algorithm.game.play.input.person;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.play.input.PlayerPlayingStyle;
import fxmlmove.FxmlMove;
import javafx.application.Platform;
import scene.game.SquareButton;


public class PersonPlayingStyle extends PlayerPlayingStyle {


    @Override
    public void startGame() {
        game = player.getGame();
        fillFxmlMoveForward();
        fillFxmlMoveBack();
    }

    public PersonPlayingStyle(Player player) {
        super(player);
    }


    @Override
    public void play(SquareButton button) {
//        gameController.printModel();
        if (player.getStep() == 0) {
//  TODO : Bu lazim olabilir            player.getPlayerMove().setChangeableStartLocationSpecialMovement(new PersonChangeLocationMove(player, button));
            fxmlMoveForwardOrBack = fxmlMoveForward;
            fxmlMoveForwardOrBack.setUpdateValuesInGameModel(player.getPlayerMove().getMoveForward().getUpdateValuesInGameModel());
            fxmlMoveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocation(player));
//            System.out.println(fxmlMoveForwardOrBack.getChangePlayerLocation());

            DirectionLocation directionLocation = new DirectionLocation();
            directionLocation.setX(button.getX());
            directionLocation.setY(button.getY());
            fxmlMoveForwardOrBack.move(directionLocation);

            updateChangePlayerLocationFunctionOfFxmlMove(fxmlMoveForward, new ChangeLocationByAdding(player));
        } else {
            ButtonClickInputForFXML buttonClickInputForFXML = new ButtonClickInputForFXML((Person) player);
            buttonClickInputForFXML.setLocationToGetCompassDirectionLocation(button.getX(), button.getY());
            PersonInput personInput = new PersonInput(buttonClickInputForFXML);
            player.setIPlayerInput(personInput);

            int choose = player.getInput(player.getGame());

            if (choose != -1) {
                FxmlMove moveForwardOrBack = getFxmlMoveBackOrForward(choose);

                if (moveForwardOrBack != null) {
//                    System.out.println("direction  3 -) :"+new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose).toString());
                    moveForwardOrBack.move(
                            new DirectionLocation().getLocationValueAccordingToEnteredValue
                                    (player.getGame(), choose));
//                    System.out.println(player.getTimeKeeper().getTotalPassedTimeDuringPlayingGame());
                    if (player.getStep() == 6) {
                        System.out.println("step value 6");
                    }
                    checkStatus();
                }
            }

        }


    }

    public void checkStatus() {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
        Thread checkStatusThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (prepareGameBySelectingMenu.getPlayer().getGameRule().isGameOver(prepareGameBySelectingMenu.getPlayer().getGame())) {  // todo bu person kismina atanacak
                    if (prepareGameBySelectingMenu.getPlayer().getStep() == prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue()) {
                        ShowPanel.show(/*getClass(), getClass().getName() */"Congratulations You succeed");

                        gameController.lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "");
                    } else {
                        gameController.stopTiming();
                        ShowPanel.show(/*getClass(),*/ "Game Over" +
                                "\n" + gameController.getElapsedTime().getTimeInStringFormat() +
                                "\nYour Step value is  " + prepareGameBySelectingMenu.getPlayer().getStep() +
                                "\nYour Score is  " + prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore());
                        Platform.runLater(() -> {
                            gameController.resetGame();
                        });
                    }
                }
            }
        });
        checkStatusThread.start();


//            }
//
//        };
//
//        gameController.runFunctionInPlatformThread(runnable);
    }

    @Override
    public void stepBack() {
        //Todo geri adim atma ihtimali yoksa uyari eklenebilir
        if (player.getStep() > 1) {
            fxmlMoveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(player.getGame(),
                    new LocationsList().getLastLocation(player.getCompass()).getId()));
        }
    }

/*    FxmlMove getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return  fxmlMoveBack;
        }
        return fxmlMoveForward;
    }*/
}
