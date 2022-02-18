package algorithm.game.play.input.person;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.Location;
import algorithm.game.location.LocationsList;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.move.Move;
import algorithm.game.move.PersonChangeLocationMove;
import algorithm.game.play.PlayerMove;
import algorithm.game.play.SelectFirstSqaureToStart;
import algorithm.game.play.input.PlayerPlayingStyle;
import fxmlmove.FxmlMoveBack;
import fxmlmove.FxmlMoveForward;
import javafx.application.Platform;
import scene.game.SquareButton;

import java.util.ArrayList;


public class PersonPlayingStyle extends PlayerPlayingStyle {
    FxmlMoveBack fxmlMoveBack;
    FxmlMoveForward fxmlMoveForward;

    @Override
    public void startGame() {
        System.out.println("person burada bir sey yapmayacaktir");
        player.setPlayerMove(new PlayerMove(new FxmlMoveForward(gameController), new FxmlMoveBack(gameController)));
        fillForwardAndBackMoveReferances();
    }

    public PersonPlayingStyle(Player player) {
        super(player);
    }

    Move moveForwardOrBack;

    @Override
    public void play(SquareButton button) {

        if (player.getStep() == 0) {
//  TODO : Bu lazim olabilir            player.getPlayerMove().setChangeableStartLocationSpecialMovement(new PersonChangeLocationMove(player, button));
            moveForwardOrBack = new FxmlMoveForward(gameController);
            moveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocation(player));
            DirectionLocation directionLocation = new DirectionLocation();
            directionLocation.setX(button.getX());
            directionLocation.setY(button.getY());
            System.out.println("DirectionLocation : " + directionLocation.toString());
            moveForwardOrBack.move(directionLocation);
//            player.getGame().increaseRoundCounter();

        } else {
//            if (button.getX() != player.getLocation().getX() || button.getY() != player.getLocation().getY()) {
//            }
            ButtonClickInputForFXML buttonClickInputForFXML = new ButtonClickInputForFXML((Person) player);
            buttonClickInputForFXML.setLocationToGetCompassDirectionLocation(button.getX(), button.getY());
            PersonInput personInput = new PersonInput(buttonClickInputForFXML);
            player.setIPlayerInput(personInput);

            System.out.println("GELEN DEGER : " + player.getInput(player.getGame()));
            int choose = player.getInput(player.getGame());

            if (choose != -1) {
//                    player.getGame().increaseRoundCounter();
//                    squareBtnCommunity.listMovedSquareBtn.get(listLastIndex()).setId(VISITED_BEFORE_BTN_ID);
                Move moveForwardOrBack = getMoveBackOrForward(choose);

                if (moveForwardOrBack != null) {
                    moveForwardOrBack.move(
                            new DirectionLocation().getLocationValueAccordingToEnteredValue
                                    (player.getGame(), choose));
//                    player.getGame().increaseRoundCounter();

                    System.out.println(player.getTimeKeeper().getTotalPassedTimeDuringPlayingGame());;
                }

//                }
            }
        }
        Platform.runLater(() -> {

            if (prepareGameBySelectingMenu.getPlayer().getGameRule().isGameOver(prepareGameBySelectingMenu.getPlayer().getGame())) {
                if (prepareGameBySelectingMenu.getPlayer().getStep() == prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue()) {
                    ShowPanel.show(getClass(), "Tebrikler butun bosluklari doldurdunuz.");
                    prepareGameBySelectingMenu.getPlayer().getScore().increaseTotalGameFinishedScore();
                    gameController.lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "");
                } else {
                    ShowPanel.show(getClass(), " Game Over Step deger i : " + prepareGameBySelectingMenu.getPlayer().getStep());
                    gameController.resetGame();
                }
            }

        });

    }

    @Override
    public void stepBack() {
        //Todo geri adim atma ihtimali yoksa uyari eklenebilir
        if (player.getStep() > 1) {
            fxmlMoveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue
                    (player.getGame(), new LocationsList().getLastLocation(player.getCompass()).getId()));
        }
     /*   if (prepareGameBySelectingMenu.getPlayer() instanceof Person) {
            if (prepareGameBySelectingMenu.getPlayer().getStep() > 1) {
//                gameController.clearOldHintButtons();
                prepareGameBySelectingMenu.getGame().increaseRoundCounter();
                PlayerPlayingStyle playerPlayingStyle = prepareGameBySelectingMenu.getPlayerPlayingStyle();

                SquareButton button = playerPlayingStyle.squareBtnCommunity.listMovedSquareBtn.get(playerPlayingStyle.squareBtnCommunity.listMovedSquareBtn.size() - 1);
                button.setId(playerPlayingStyle.NORMAL_SQUARE_BTN_ID);
                button.setText("");

                Move moveBack = prepareGameBySelectingMenu.getPlayer().getPlayerMove().getMoveBack();
                moveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(prepareGameBySelectingMenu.getGame(),
                        prepareGameBySelectingMenu.getPlayer().getCompass().getLastLocation()));

                playerPlayingStyle.squareBtnCommunity.listMovedSquareBtn.remove(playerPlayingStyle.squareBtnCommunity.listMovedSquareBtn.size() - 1);
                SquareButton squareButton = playerPlayingStyle.squareBtnCommunity.listMovedSquareBtn.get(playerPlayingStyle.squareBtnCommunity.listMovedSquareBtn.size() - 1);
                squareButton.setId(playerPlayingStyle.CURRENT_BTN_ID);

                gameController.updateLabelCurrentValue();
                gameController.updateLabelTotalStepValue();
                gameController.paintHintButtonsOfCurrentBtn();
            }
            gameController.printModel();
        }*/
    }


    /*void locatePlayerFirstLocation(int x, int y) {
        SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(player.getGame());
        selectFirstSqaureToStart.selectSquareStart(x, y);
        selectFirstSqaureToStart.locateThePlayer();
        System.out.println("Baslangic yeri : secildi" + player.getLocation().toString());
    }*/

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
//            FxmlMoveBack fxmlMoveBack = new FxmlMoveBack(gameController);
//            fxmlMoveBack.setChangePlayerLocation(new ChangeLocationByAdding(player));
            return fxmlMoveBack;

        }
//        FxmlMoveForward fxmlMoveForward = new FxmlMoveForward(gameController);
//        fxmlMoveForward.setChangePlayerLocation(new ChangeLocationByAdding(player));
        return fxmlMoveForward;
//        moveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocatin(player));
//        return new FxmlMoveForward(gameController/*player.getGame(), squareBtnCommunity*/);

//        return player.getPlayerMove().getMoveForward();
    }

    void fillForwardAndBackMoveReferances() {
        fxmlMoveBack = new FxmlMoveBack(gameController);
        fxmlMoveBack.setChangePlayerLocation(new ChangeLocationByAdding(player));
        fxmlMoveForward = new FxmlMoveForward(gameController);
        fxmlMoveForward.setChangePlayerLocation(new ChangeLocationByAdding(player));
    }

}
