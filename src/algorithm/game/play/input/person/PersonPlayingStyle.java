package algorithm.game.play.input.person;

import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.play.input.PlayerPlayingStyle;
import fxmlmove.FxmlMove;
import scene.game.SquareButton;


public class PersonPlayingStyle extends PlayerPlayingStyle {


    @Override
    public void startGame() {
//        setFxmlMoveBack(new FxmlMoveBack(gameController));
//        getFxmlMoveBack().setChangePlayerLocation(new ChangeLocationByAdding(player));
//        setFxmlMoveForward(new FxmlMoveForward(gameController));
//        getFxmlMoveForward().setChangePlayerLocation(new ChangeLocationByAdding(player));
        game = player.getGame();
        fillFxmlMoveForward();
        fillFxmlMoveBack();
//        FxmlMoveForward fxmlMoveForward = new FxmlMoveForward(prepareGameBySelectingMenu, player.getPlayerMove().getMoveForward());
//        fxmlMoveForward.setGameController(gameController);
//        fxmlMoveForward.setSquareBtnCommunity(getGameController().squareBtnCommunity);
//        player.getPlayerMove().setMoveForward(fxmlMoveForward);

/*
        System.out.println(fxmlMoveForward);
        System.out.println("-=------------------------------");
        FxmlMoveBack fxmlMoveBack = new FxmlMoveBack(gameController, player.getPlayerMove().getMoveBack());
//        fxmlMoveForward.setT(new MoveForward(game));
        setPlayerMove(new PlayerMove(fxmlMoveForward, fxmlMoveBack));
        System.out.println("person burada bir sey yapmayacaktir");
*/


//        player.getPlayerMove().getMoveForward();
//        player.setPlayerMove(new PlayerMove(getFxmlMoveForward(), getFxmlMoveBack()/*new FxmlMoveForward(gameController), new FxmlMoveBack(gameController)*/));
        /*        fillForwardAndBackMoveReferances();
        System.out.println("person burada bir sey yapmayacaktir");
        player.setPlayerMove(new PlayerMove(getFxmlMoveForward(), getFxmlMoveBack()*//*new FxmlMoveForward(gameController), new FxmlMoveBack(gameController)*//*));
//        fillForwardAndBackMoveReferances();*/
    }

    public PersonPlayingStyle(Player player) {
        super(player);
    }


    @Override
    public void play(SquareButton button) {
        gameController.printModel();
        if (player.getStep() == 0) {
//  TODO : Bu lazim olabilir            player.getPlayerMove().setChangeableStartLocationSpecialMovement(new PersonChangeLocationMove(player, button));

//            System.out.println("DirectionLocation : " + directionLocation.toString());

            fxmlMoveForwardOrBack = fxmlMoveForward;
//            System.out.println(" player.getPlayerMove().getMoveForward() --------------------------- >>>>>>>>>>>>>>> : " + player.getPlayerMove().getMoveForward());
            fxmlMoveForwardOrBack.setUpdateValuesInGameModel(player.getPlayerMove().getMoveForward().getUpdateValuesInGameModel());
            fxmlMoveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocation(player));
            System.out.println(fxmlMoveForwardOrBack.getChangePlayerLocation());

            DirectionLocation directionLocation = new DirectionLocation();
            directionLocation.setX(button.getX());
            directionLocation.setY(button.getY());
            System.out.println("Gonderilecek olan direction location : " + directionLocation);
            fxmlMoveForwardOrBack.move(directionLocation);
//            player.getGame().increaseRoundCounter();
//            fillFxmlMoveForward();

            updateChangePlayerLocationFunctionOfFxmlMove(fxmlMoveForward,new ChangeLocationByAdding(player));
        } else {
//            if (button.getX() != player.getLocation().getX() || button.getY() != player.getLocation().getY()) {
//            }
            ButtonClickInputForFXML buttonClickInputForFXML = new ButtonClickInputForFXML((Person) player);
            buttonClickInputForFXML.setLocationToGetCompassDirectionLocation(button.getX(), button.getY());
            PersonInput personInput = new PersonInput(buttonClickInputForFXML);
            player.setIPlayerInput(personInput);
//            fxmlMoveForwardOrBack.setChangePlayerLocation(new ChangeLocationByAdding(player));
            System.out.println("GELEN DEGER : " + player.getInput(player.getGame()));
            int choose = player.getInput(player.getGame());

//            fxmlMoveForward.setChangePlayerLocation(new ChangeLocationByAdding(player));
            if (choose != -1) {
//                    player.getGame().increaseRoundCounter();
//                    squareBtnCommunity.listMovedSquareBtn.get(listLastIndex()).setId(VISITED_BEFORE_BTN_ID);
                FxmlMove moveForwardOrBack = getMoveBackOrForward(choose);
                System.out.println("gelen choose : " + choose);
                System.out.println("gelen choose : " + moveForwardOrBack.toString());


                if (moveForwardOrBack != null) {
                    moveForwardOrBack.move(
                            new DirectionLocation().getLocationValueAccordingToEnteredValue
                                    (player.getGame(), choose));
//                    player.getGame().increaseRoundCounter();

                    System.out.println(player.getTimeKeeper().getTotalPassedTimeDuringPlayingGame());
                    ;
                }

//                }
            }
            checkStatus();
        }


    }

    @Override
    public void stepBack() {
        //Todo geri adim atma ihtimali yoksa uyari eklenebilir
        if (player.getStep() > 1) {
//            player.getPlayerMove().getMoveBack().move(new DirectionLocation().getLocationValueAccordingToEnteredValue
//                    (player.getGame(), new LocationsList().getLastLocation(player.getCompass()).getId()));
            fxmlMoveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(player.getGame(),
                    new LocationsList().getLastLocation(player.getCompass()).getId()));
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

    FxmlMove getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return  fxmlMoveBack;
        }
//        FxmlMoveForward fxmlMoveForward = new FxmlMoveForward(gameController);
//        fxmlMoveForward.setChangePlayerLocation(new ChangeLocationByAdding(player));
        return fxmlMoveForward;//player.getPlayerMove().getMoveForward();
//        moveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocatin(player));
//        return new FxmlMoveForward(gameController/*player.getGame(), squareBtnCommunity*/);

//        return player.getPlayerMove().getMoveForward();
    }


}
