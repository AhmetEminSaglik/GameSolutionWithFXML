package fxmlmove;

import algorithm.game.move.fundamental.MoveBack;
import scene.game.GameController;
import scene.game.SquareButton;

public class FxmlMoveBack extends MoveBack {
    FxmlSquareBtnCommunity squareBtnCommunity;
    GameController gameController;
    int playerLocationX, playerLocationY;// = game.getPlayer().getLocation().getX();// = game.getPlayer().getLocation().getY();
    SquareButton currentBtn;

    public FxmlMoveBack(GameController gameController) {
        super(gameController.getPrepareGameBySelectingMenu().getGame());
        this.squareBtnCommunity = gameController.squareBtnCommunity;
        this.gameController = gameController;
    }

    @Override
    public void updatePlayerLocation() {
//        updateValuesInGameModel.setMovePlayer(new ChangeLocationByAdding(game.getPlayer()));
        super.updatePlayerLocation();
    }

    @Override
    public void updateBeforeStep() {
        super.updateBeforeStep();
        gameController.clearOldHintButtons();
        currentBtn = getCurrentBtn();
        currentBtn.setText("");
        gameController.paintSquareBtnTo_NormalSquareBtn(currentBtn);
    }

    @Override
    public void updateAfterStep() {
        super.updateAfterStep();

        gameController.getPrepareGameBySelectingMenu().getGame().increaseRoundCounter();

        SquareButton currentBtn = getCurrentBtn();
        gameController.paintSquareBtnTo_CurrentBtn(currentBtn);
        gameController.setStepValueToToSquareBtnAsAText(currentBtn);
        gameController.paintHintButtonsOfCurrentBtn();
        gameController.updateLabelTotalStepValue();
        gameController.updateLabelCurrentValue();


    }


    @Override
    public void updateVisitedArea() {
        super.updateVisitedArea();
    }

    SquareButton getCurrentBtn() {
        updatePlayerLocationToGetCurrentBtn();
        return gameController.squareBtnCommunity.getCurrentSquareBtn(playerLocationX, playerLocationY);
    }

    void updatePlayerLocationToGetCurrentBtn() {
        playerLocationX = game.getPlayer().getLocation().getX();
        playerLocationY = game.getPlayer().getLocation().getY();
    }


}
