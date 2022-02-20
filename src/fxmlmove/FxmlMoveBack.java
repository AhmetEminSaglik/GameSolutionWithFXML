package fxmlmove;

import algorithm.game.Game;
import algorithm.game.move.fundamental.MoveBack;
import scene.game.GameController;
import scene.game.SquareButton;

public class FxmlMoveBack extends FxmlMove {
    MoveBack moveBack;

    public FxmlMoveBack(Game game, GameController gameController) {
        super(game);
        this.gameController = gameController;
    }

/*    MoveBack moveBack;
    FxmlSquareBtnCommunity squareBtnCommunity;
    GameController gameController;
    int playerLocationX, playerLocationY;// = game.getPlayer().getLocation().getX();// = game.getPlayer().getLocation().getY();
    SquareButton currentBtn;*/
/*

    public FxmlMoveBack(GameController gameController, MoveBack moveBack) {
        super(gameController.getPrepareGameBySelectingMenu().getGame());
        this.moveBack = moveBack;
        this.squareBtnCommunity = gameController.squareBtnCommunity;
        this.gameController = gameController;
    }
*/

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
//        super.updateBeforeStep();
        moveBack.updateBeforeStep();
        gameController.clearOldHintButtons();
        currentBtn = getCurrentBtn();
        gameController.clearStepValueOfSquareBtnAsAText(currentBtn);
//        currentBtn.setText("");
        gameController.paintSquareBtnTo_NormalSquareBtn(currentBtn);
    }

    @Override
    public void updateAfterStep() {
//        super.updateAfterStep();
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
    public void updatePlayerLocation() {
//        updateValuesInGameModel.setMovePlayer(new ChangeLocationByAdding(game.getPlayer()));
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
}
