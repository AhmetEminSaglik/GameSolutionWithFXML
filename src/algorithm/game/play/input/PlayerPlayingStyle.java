package algorithm.game.play.input;

import algorithm.game.gamerepo.player.Player;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.game.GameController;
import scene.game.SquareButton;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerPlayingStyle {

    protected Player player;
    protected SquareButton squareButtonArray[][];
    public final static String CURRENT_BTN_ID = "currentBtn";
    public final static String NORMAL_SQUARE_BTN_ID = SquareButton.NORMAL_SQUARE_BTN_ID;
    public final static String VISITED_BEFORE_BTN_ID = "visitedSquareBtn";
    public final static String HINT_BTN_ID = "hintBtn";
    public List<SquareButton> listMovedSquareBtn = new ArrayList<>();
    protected PrepareGameBySelectingMenu prepareGameBySelectingMenu;
    protected GameController gameController;


    public abstract void startGame();

    public PlayerPlayingStyle(Player player) {
        this.player = player;
    }

    public abstract void play(SquareButton button/*int x, int y*/);

    public abstract void stepBack();

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        System.out.println("buraya geldik player : " + player.getClass().getName());
        squareButtonArray = gameController.squareButtonArray;
        this.gameController = gameController;
        this.prepareGameBySelectingMenu = gameController.getPrepareGameBySelectingMenu();
    }
    protected int listLastIndex() {
        return listMovedSquareBtn.size() - 1;
    }
}
