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
        if (player.getStep() == 0) {
//  TODO : Bu lazim olabilir            player.getPlayerMove().setChangeableStartLocationSpecialMovement(new PersonChangeLocationMove(player, button));
            fxmlMoveForwardOrBack = fxmlMoveForward;
            fxmlMoveForwardOrBack.setUpdateValuesInGameModel(player.getPlayerMove().getMoveForward().getUpdateValuesInGameModel());
            fxmlMoveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocation(player));

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
                    moveForwardOrBack.move(
                            new DirectionLocation().getLocationValueAccordingToEnteredValue
                                    (player.getGame(), choose));
                    checkStatus();
                }
            }

        }


    }

    public void checkStatus() {
        Thread checkStatusThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (prepareGameBySelectingMenu.getPlayer().getGameRule().isGameOver(prepareGameBySelectingMenu.getPlayer().getGame())) {  // todo bu person kismina atanacak
                    if (prepareGameBySelectingMenu.getPlayer().getStep() == prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue()) {
                        ShowPanel.show("Congratulations You succeed");

                        gameController.lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "");
                    } else {
                        gameController.stopTiming();
                        ShowPanel.show("Game Over" +
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


    }

    @Override
    public void stepBack() {
        //Todo geri adim atma ihtimali yoksa uyari eklenebilir
        if (player.getStep() > 1) {
            fxmlMoveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(player.getGame(),
                    new LocationsList().getLastLocation(player.getCompass()).getId()));
        }
    }

}
