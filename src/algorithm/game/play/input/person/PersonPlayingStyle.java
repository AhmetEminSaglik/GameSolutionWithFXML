package algorithm.game.play.input.person;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.Move;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.play.SelectFirstSqaureToStart;
import algorithm.game.play.input.PlayerPlayingStyle;
import javafx.application.Platform;
import scene.game.SquareButton;


public class PersonPlayingStyle extends PlayerPlayingStyle {

    @Override
    public void startGame() {
        System.out.println("person burada bir sey yapmayacaktir");
    }

    public PersonPlayingStyle(Player player) {
        super(player);
    }

    @Override
    public void play(SquareButton button/*int x, int y*/) {

        if (player.getStep() == 0) {
            player.getGame().increaseRoundCounter();
            locatePlayerFirstLocation(button.getX(), button.getY());
            button.setId(CURRENT_BTN_ID);
            button.setText(player.getStep() + "");
            listMovedSquareBtn.add(button);
            System.out.println(" listMovedSquareBtn  size: " + listMovedSquareBtn.size());
        } else {
            if (button.getX() != player.getLocation().getX() || button.getY() != player.getLocation().getY()) {
//            }
                ButtonClickInputForFXML buttonClickInputForFXML = new ButtonClickInputForFXML((Person) player);
                buttonClickInputForFXML.setLocationToGetCompassDirectionLocation(button.getX(), button.getY());
                PersonInput personInput = new PersonInput(buttonClickInputForFXML);
                player.setIPlayerInput(personInput);

                System.out.println("GELEN DEGER : " + player.getInput(player.getGame()));
                int choose = player.getInput(player.getGame());

                if (choose != -1) {
                    player.getGame().increaseRoundCounter();
                    listMovedSquareBtn.get(listLastIndex()).setId(VISITED_BEFORE_BTN_ID);
                    Move moveForwardOrBack = getMoveBackOrForward(choose);

                    if (moveForwardOrBack != null) {
                        moveForwardOrBack.move(
                                new DirectionLocation().getLocationValueAccordingToEnteredValue
                                        (player.getGame(), choose));

                        if (!moveForwardOrBack.getClass().getTypeName().equals(MoveBack.class.getTypeName())) {
                            button.setId(CURRENT_BTN_ID);
                            String text = player.getStep() + "";
                            button.setText(text);
                            listMovedSquareBtn.add(button);
                            System.out.println(" listMovedSquareBtn  size: " + listMovedSquareBtn.size());

                        } else {
                            listMovedSquareBtn.remove(button);
                            button.setId(NORMAL_SQUARE_BTN_ID);
                            button.setText("");
                            listMovedSquareBtn.get(listLastIndex()).setId(CURRENT_BTN_ID);

                        }

                    }

                }
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
            gameController.updateCurrentValue();
            gameController.updateStepValue();

        });
    }

    @Override
    public void stepBack() {
        //Todo geri adim atma ihtimali yoksa uyari eklenebilir
        if (prepareGameBySelectingMenu.getPlayer() instanceof Person) {
            if (prepareGameBySelectingMenu.getPlayer().getStep() > 1) {
                gameController.updateOldHintButtons();
                prepareGameBySelectingMenu.getGame().increaseRoundCounter();
                PlayerPlayingStyle playerPlayingStyle = prepareGameBySelectingMenu.getPlayerPlayingStyle();

                SquareButton button = playerPlayingStyle.listMovedSquareBtn.get(playerPlayingStyle.listMovedSquareBtn.size() - 1);
                button.setId(playerPlayingStyle.NORMAL_SQUARE_BTN_ID);
                button.setText("");

                Move moveBack = prepareGameBySelectingMenu.getPlayer().getPlayerMove().getMoveBack();
                moveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(prepareGameBySelectingMenu.getGame(),
                        prepareGameBySelectingMenu.getPlayer().getCompass().getLastLocation()));

                playerPlayingStyle.listMovedSquareBtn.remove(playerPlayingStyle.listMovedSquareBtn.size() - 1);
                SquareButton squareButton = playerPlayingStyle.listMovedSquareBtn.get(playerPlayingStyle.listMovedSquareBtn.size() - 1);
                squareButton.setId(playerPlayingStyle.CURRENT_BTN_ID);

                gameController.updateCurrentValue();
                gameController.updateStepValue();
                gameController.paintHintButton();
            }
            gameController.printModel();
        }
    }


    void locatePlayerFirstLocation(int x, int y) {
        SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(player.getGame());
        selectFirstSqaureToStart.selectSquareStart(x, y);
        selectFirstSqaureToStart.locateThePlayer();
        System.out.println("Baslangic yeri : secildi" + player.getLocation().toString());
    }

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return player.getPlayerMove().getMoveBack();

        }
        return player.getPlayerMove().getMoveForward();
    }


}
