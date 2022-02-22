package algorithm.game.gamerepo.player;


import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.move.fundamental.MoveForward;
import algorithm.game.play.PlayerMove;
import fxmlmove.FxmlMoveForward;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.game.GameController;

public abstract class PlayerSpecialStuffToPrepareBeforeStartGame {
    protected PrepareGameBySelectingMenu prepareGameBySelectingMenu;
    GameController gameController;

    public PlayerSpecialStuffToPrepareBeforeStartGame(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
    }

    public void prepare() {
        prepareGameBySelectingMenu.prepareGame();
//        TODO  setPlayerMove 1
//        MoveForward moveForward = new MoveForward(prepareGameBySelectingMenu.getGame());
//        moveForward.createUpdateValuesInGameModel();
//        MoveBack moveBack = new MoveBack(prepareGameBySelectingMenu.getGame());
//        moveBack.createUpdateValuesInGameModel();
//        FxmlMoveForward fxmlMoveForward= new FxmlMoveForward(prepareGameBySelectingMenu.getGame());

        MoveForward moveForward = new MoveForward(prepareGameBySelectingMenu.getGame());
        MoveBack moveBack = new MoveBack(prepareGameBySelectingMenu.getGame());
        prepareGameBySelectingMenu.getPlayer().setPlayerMove(new PlayerMove(moveForward, moveBack));


    }

}
