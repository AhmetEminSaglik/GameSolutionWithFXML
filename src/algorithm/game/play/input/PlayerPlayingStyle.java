package algorithm.game.play.input;

import algorithm.game.Game;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangePlayerLocation;
import fxmlmove.FxmlMove;
import fxmlmove.FxmlMoveBack;
import fxmlmove.FxmlMoveForward;
import fxmlmove.FxmlSquareBtnCommunity;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.game.GameController;
import scene.game.SquareButton;



public abstract class PlayerPlayingStyle {

    protected Game game;
    public boolean movementLocked = false;
    public final static boolean UNLOCK = false;
    public final static boolean LOCK = true;
    protected FxmlMoveForward fxmlMoveForward;
    protected FxmlMoveBack fxmlMoveBack;
    protected FxmlMove fxmlMoveForwardOrBack;
    protected Player player;
    public FxmlSquareBtnCommunity squareBtnCommunity = new FxmlSquareBtnCommunity();
    public final static String CURRENT_BTN_ID = "currentBtn";
    public final static String NORMAL_SQUARE_BTN_ID = SquareButton.NORMAL_SQUARE_BTN_ID;
    public final static String VISITED_BEFORE_BTN_ID = "visitedSquareBtn";
    public final static String HINT_BTN_ID = "hintBtn";
    protected PrepareGameBySelectingMenu prepareGameBySelectingMenu;
    protected GameController gameController;


    public abstract void startGame();

    public PlayerPlayingStyle(Player player) {
        this.player = player;
    }

    public abstract void play(SquareButton button);

    public abstract void stepBack();

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        squareBtnCommunity = gameController.squareBtnCommunity;
        this.gameController = gameController;
        this.prepareGameBySelectingMenu = gameController.getPrepareGameBySelectingMenu();
    }

    protected int listLastIndex() {
        return squareBtnCommunity.listMovedSquareBtn.size() - 1;
    }

    protected void fillFxmlMoveForward() {
        fxmlMoveForward = new FxmlMoveForward(game, gameController);
        fxmlMoveForward.setMoveForward(player.getPlayerMove().getMoveForward());
        fxmlMoveForward.setUpdateValuesInGameModel(player.getPlayerMove().getMoveForward().getUpdateValuesInGameModel());
        fxmlMoveForward.setChangePlayerLocation(new ChangeLocationByAdding(player));
    }

    protected void fillFxmlMoveBack() {
        fxmlMoveBack = new FxmlMoveBack(game, gameController);
        fxmlMoveBack.setMoveBack(player.getPlayerMove().getMoveBack());
        fxmlMoveBack.setUpdateValuesInGameModel(player.getPlayerMove().getMoveBack().getUpdateValuesInGameModel());
        fxmlMoveBack.setChangePlayerLocation(new ChangeLocationByAdding(player));
    }

    protected FxmlMove getFxmlMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return fxmlMoveBack;
        } else {
            return fxmlMoveForward;
        }
    }

    protected void updateChangePlayerLocationFunctionOfFxmlMove(FxmlMove fxmlMove, ChangePlayerLocation changePlayerLocation) {
        fxmlMove.setChangePlayerLocation(changePlayerLocation);
    }
}
