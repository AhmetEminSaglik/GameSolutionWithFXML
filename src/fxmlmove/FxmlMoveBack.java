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
//        ShowPanel.show(getClass(), " MOVE BACKk  updateBeforeStep");
        moveBack.updateVisitedDirection();
    }


    @Override
    public void updateBeforeStep() {
//        ShowPanel.show(getClass()," MOVE BACKk  geldiiiiiiiiiiiiiiiiiiii"  );
//        super.updateBeforeStep();
//        ShowPanel.show(getClass()," FXML MOVE BACK ");
        moveBack.updateBeforeStep();
        gameController.clearOldHintButtons();
        currentBtn = getCurrentBtn();
        gameController.clearStepValueOfSquareBtnAsAText(currentBtn);
//        currentBtn.setText("");
        gameController.paintSquareBtnTo_NormalSquareBtn(currentBtn);
//        ShowPanel.show(getClass(),"FXML Update BEFORE step : "+game.getPlayer().getStep());
    }

    @Override
    public void updateAfterStep() {
//        super.updateAfterStep();
//        ShowPanel.show(getClass(), " MOVE BACKk  updateAfterStep");
//        ShowPanel.show(getClass(),"FXML  Update AFTER step : "+game.getPlayer().getStep());
        moveBack.setDirectionLocation(getDirectionLocation());
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
//        updateValuesInGameModel.setMovePlayer(new ChangeLocationByAdding(game.getPlayer()));
//        ShowPanel.show(getClass(), " MOVE BACKk  updatePlayerLocation");
        moveBack.updatePlayerLocation();
//        super.updatePlayerLocation();
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
