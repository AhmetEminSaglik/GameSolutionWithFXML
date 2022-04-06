package fxmlmove;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.fundamental.MoveForward;
import scene.game.GameController;
import scene.game.SquareButton;

public class FxmlMoveForward extends FxmlMove {
    MoveForward moveForward;

    public FxmlMoveForward(Game game, GameController gameController) {
        super(game);
        this.gameController = gameController;
    }

    @Override
    public void prepareAllStuff() {
        moveForward.setDirectionLocation(getDirectionLocation());
        moveForward.prepareAllStuff();
    }

    @Override
    public void updateVisitedDirection() {
        moveForward.updateVisitedDirection();
    }

    @Override
    public void updateBeforeStep() {
            moveForward.updateBeforeStep();
            gameController.clearOldHintButtons();
            currentBtn = getCurrentBtn();
            gameController.paintSquareBtnTo_VisitedBeforeBtn(currentBtn);
    }

    @Override
    public void updateAfterStep() {
        moveForward.updateAfterStep();

        SquareButton currentBtn = getCurrentBtn();
        gameController.paintSquareBtnTo_CurrentBtn(currentBtn);
        gameController.setStepValueToSquareBtnAsAText(currentBtn);
        gameController.paintHintButtonsOfCurrentBtn();
        gameController.updateLabelTotalStepValue();
        gameController.updateLabelCurrentValue();
    }

    @Override
    public void changeStartLocation(DirectionLocation directionLocation) {
        moveForward.changeStartLocation(directionLocation);
    }

    @Override
    public void updatePlayerLocation() {
        moveForward.updatePlayerLocation();
    }


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

    @Override
    public String toString() {
        return "FxmlMoveForward\n{" +
                ", updateValuesInGameModel=" + updateValuesInGameModel +
                ", moveForward=" + moveForward +
                '}';
    }
}
