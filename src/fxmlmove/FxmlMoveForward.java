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
        moveForward.prepareAllStuff();
    }

    @Override
    public void updateVisitedDirection() {
//        ShowPanel.show(getClass(), " MOVE FORWARD  updateBeforeStep");
        moveForward.updateVisitedDirection();
    }

    @Override
    public void updateBeforeStep() {
//        ShowPanel.show(getClass()," BBB 1 ");
//        ShowPanel.show(getClass(), " MOVE FORWARD  updateBeforeStep");

//        super.updateBeforeStep();
//        t.updateBeforeStep();
//        super.updateBeforeStep();
        moveForward.setDirectionLocation(getDirectionLocation());
        moveForward.updateBeforeStep();
        gameController.clearOldHintButtons();
        currentBtn = getCurrentBtn();
        gameController.paintSquareBtnTo_VisitedBeforeBtn(currentBtn);
    }

    //
    @Override
    public void updateAfterStep() {
//        ShowPanel.show(getClass(), " MOVE FORWARD  updateAfterStep");
//        t.updateAfterStep();
//        super.updateAfterStep();
//        super.updateAfterStep();
//        System.out.println(" 2 getDirection : " + getDirectionLocation());


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
        ShowPanel.show(getClass()," changeStartLocation Fxml Move Forward");
        moveForward.changeStartLocation(directionLocation);
    }

    @Override
    public void updatePlayerLocation() {
//        ShowPanel.show(getClass(), " MOVE FORWARD  updatePlayerLocation");
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

    @Override
    public String toString() {
        return "FxmlMoveForward\n{" +
                ", updateValuesInGameModel=" + updateValuesInGameModel +
                ", moveForward=" + moveForward +
                '}';
    }
}
