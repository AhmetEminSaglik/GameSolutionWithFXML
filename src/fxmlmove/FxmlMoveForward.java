package fxmlmove;

import algorithm.game.Game;
import algorithm.game.move.Move;
import algorithm.game.move.fundamental.MoveForward;
import scene.game.GameController;
import scene.game.SquareButton;

public class FxmlMoveForward extends FxmlMove {
    MoveForward moveForward;


    public FxmlMoveForward(Game game, GameController gameController) {
        super(game);
        this.gameController = gameController;
    }


    //    public FxmlMoveForward(GameController gameController) {
//
//        super(gameController.getPrepareGameBySelectingMenu().getGame());
//        this.squareBtnCommunity = gameController.squareBtnCommunity;
//        this.gameController = gameController;
//
//    }
//
//    @Override
//    public void prepareAllStuff() {
//
////        getT().prepareAllStuff();
//    }
//


    @Override
    public void prepareAllStuff() {moveForward.prepareAllStuff();}

    @Override
    public void updateVisitedDirection() {
        moveForward.updateVisitedDirection();
    }

    @Override
    public void updateBeforeStep() {
//        super.updateBeforeStep();
//        t.updateBeforeStep();
//        super.updateBeforeStep();
        moveForward.updateBeforeStep();
        gameController.clearOldHintButtons();
        currentBtn = getCurrentBtn();
        gameController.paintSquareBtnTo_VisitedBeforeBtn(currentBtn);
    }

    //
    @Override
    public void updateAfterStep() {
//        t.updateAfterStep();
//        super.updateAfterStep();
//        super.updateAfterStep();
//        System.out.println(" 2 getDirection : " + getDirectionLocation());
        moveForward.setDirectionLocation(getDirectionLocation());
        moveForward.updateAfterStep();

        SquareButton currentBtn = getCurrentBtn();
        gameController.paintSquareBtnTo_CurrentBtn(currentBtn);
        gameController.setStepValueToSquareBtnAsAText(currentBtn);
        gameController.paintHintButtonsOfCurrentBtn();
        gameController.updateLabelTotalStepValue();
        gameController.updateLabelCurrentValue();


    }

    @Override
    public void updatePlayerLocation() {
        moveForward.updatePlayerLocation();
    }
    //
//    @Override
//    public void updatePlayerLocation() {
////        updateValuesInGameModel.setMovePlayer(new ChangeLocationByAdding(game.getPlayer()));
////        super.updatePlayerLocation();
//
////        t.updatePlayerLocation();
//    }
//
//
//    @Override
//    public void updateVisitedArea() {
////        super.updateVisitedArea();
////        t.updateVisitedArea();
//    }


    @Override
    public void updateVisitedArea() {
        moveForward.updateVisitedArea();
    }

    public MoveForward getMoveForward() {
        return moveForward;
    }

    public void setMoveForward(MoveForward moveForward) {
        this.moveForward = moveForward;
    }
}
