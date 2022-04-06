package fxmlmove;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.fundamental.MoveBack;
import scene.game.GameController;
import scene.game.SquareButton;

public class FxmlMoveBack extends FxmlMove {
    MoveBack moveBack;

    public FxmlMoveBack(Game game, GameController gameController) {
        super(game);
        this.gameController = gameController;
    }

    @Override
    public void prepareAllStuff() {
        moveBack.prepareAllStuff();
    }


    @Override
    public void updateVisitedDirection() {
        moveBack.updateVisitedDirection();
    }


    @Override
    public void updateBeforeStep() {
        moveBack.setDirectionLocation(getDirectionLocation());
        moveBack.updateBeforeStep();
        gameController.clearOldHintButtons();
        currentBtn = getCurrentBtn();
        gameController.clearStepValueOfSquareBtnAsAText(currentBtn);
        gameController.paintSquareBtnTo_NormalSquareBtn(currentBtn);
    }

    @Override
    public void updateAfterStep() {
        moveBack.updateAfterStep();

        SquareButton currentBtn = getCurrentBtn();
        gameController.paintSquareBtnTo_CurrentBtn(currentBtn);
        gameController.setStepValueToSquareBtnAsAText(currentBtn);
        gameController.paintHintButtonsOfCurrentBtn();
        gameController.updateLabelTotalStepValue();
        gameController.updateLabelCurrentValue();


    }

    @Override
    public void changeStartLocation(DirectionLocation directionLocation) {
        moveBack.changeStartLocation(directionLocation);
    }


    @Override
    public void updatePlayerLocation() {
        moveBack.updatePlayerLocation();
    }


    @Override
    public void updateVisitedArea() {
        moveBack.updateVisitedArea();
    }

    SquareButton getCurrentBtn() {
        updatePlayerLocationToGetCurrentBtn();
        return gameController.squareBtnCommunity.getCurrentSquareBtn(playerLocationX, playerLocationY);
    }



    public MoveBack getMoveBack() {
        return moveBack;
    }

    public void setMoveBack(MoveBack moveBack) {
        this.moveBack = moveBack;
    }

    @Override
    public String toString() {
        return "FxmlMoveBack\n{" +
                ", updateValuesInGameModel=" + updateValuesInGameModel +
                ", moveBack=" + moveBack +
                '}';
    }
}
