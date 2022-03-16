package algorithm.game.play.input;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.move.ChangePlayerLocation;
import algorithm.game.move.Move;
import algorithm.game.play.PlayerMove;
import fxmlmove.FxmlMove;
import fxmlmove.FxmlMoveBack;
import fxmlmove.FxmlMoveForward;
import fxmlmove.FxmlSquareBtnCommunity;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.game.GameController;
import scene.game.SquareButton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public abstract class PlayerPlayingStyle {
//    protected Move moveForwardOrBack;


    protected Game game;
//    private boolean movementLocked = false;
    public  boolean movementLocked = false;
    //    protected FxmlMoveBack fxmlMoveBack;
    protected FxmlMoveForward fxmlMoveForward;
    protected FxmlMoveBack fxmlMoveBack;
    protected FxmlMove fxmlMoveForwardOrBack;
    protected Player player;
    //    protected SquareButton squareButtonArray[][];
    public FxmlSquareBtnCommunity squareBtnCommunity = new FxmlSquareBtnCommunity();
    public final static String CURRENT_BTN_ID = "currentBtn";
    public final static String NORMAL_SQUARE_BTN_ID = SquareButton.NORMAL_SQUARE_BTN_ID;
    public final static String VISITED_BEFORE_BTN_ID = "visitedSquareBtn";
    public final static String HINT_BTN_ID = "hintBtn";
    //    public List<SquareButton> listMovedSquareBtn = new ArrayList<>();
    protected PrepareGameBySelectingMenu prepareGameBySelectingMenu;
    protected GameController gameController;


    public abstract void startGame();/* {
        fillForwardAndBackMoveReferances(new FxmlMoveForward());
        System.out.println("person burada bir sey yapmayacaktir");
        player.setPlayerMove(new PlayerMove(getFxmlMoveForward(), getFxmlMoveBack()*//*new FxmlMoveForward(gameController), new FxmlMoveBack(gameController)*//*));
        game = player.getGame();
    }*/

    public PlayerPlayingStyle(Player player) {
        this.player = player;
    }

    public abstract void play(SquareButton button/*int x, int y*/);

    public abstract void stepBack();

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
//        System.out.println("buraya geldik player : " + player.getClass().getName());
        squareBtnCommunity = gameController.squareBtnCommunity;
        this.gameController = gameController;
        this.prepareGameBySelectingMenu = gameController.getPrepareGameBySelectingMenu();
    }

    protected int listLastIndex() {
        return squareBtnCommunity.listMovedSquareBtn.size() - 1;
    }

//    public FxmlMoveBack getFxmlMoveBack() {
//        return fxmlMoveBack;
//    }
//
//    public void setFxmlMoveBack(FxmlMoveBack fxmlMoveBack) {
//        this.fxmlMoveBack = fxmlMoveBack;
//    }
//
//    public FxmlMoveForward getFxmlMoveForward() {
//        return fxmlMoveForward;
//    }
//
//    public void setFxmlMoveForward(FxmlMoveForward fxmlMoveForward) {
//        this.fxmlMoveForward = fxmlMoveForward;
//    }

//    protected void fillForwardAndBackMoveReferances(FxmlMoveForward fxmlMoveForward,FxmlMoveBack fxmlMoveBack) {
//        setFxmlMoveForward(fxmlMoveForward);
//        getFxmlMoveForward().setChangePlayerLocation(new ChangeLocationByAdding(player));
//        setFxmlMoveBack(fxmlMoveBack);
//        getFxmlMoveBack().setChangePlayerLocation(new ChangeLocationByAdding(player));
//    }

 /*   public void checkStatus() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (prepareGameBySelectingMenu.getPlayer().getGameRule().isGameOver(prepareGameBySelectingMenu.getPlayer().getGame())) {  // todo bu person kismina atanacak
                    if (prepareGameBySelectingMenu.getPlayer().getStep() == prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue()) {
                        ShowPanel.show(getClass(), "Tebrikler butun bosluklari doldurdunuz.");

                        gameController.lblScoreValue.setText(prepareGameBySelectingMenu.getPlayer().getScore().getTotalGameFinishedScore() + "");
                    } else {
                        ShowPanel.show(getClass(), " Game Over Step deger i : " + prepareGameBySelectingMenu.getPlayer().getStep());
                        gameController.resetGame();
                    }
                }
            }

        };
        gameController.runFunctionInPlatformThread(runnable);
    }*/

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
//            fxmlMoveBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(player.getGame(),
//                    new LocationsList().getLastLocation(player.getCompass()).getId()));
//            ShowPanel.show(getClass(), "\ndonecek deger : " + fxmlMoveBack);
            return fxmlMoveBack;
        } else {
//            ShowPanel.show(getClass(), "\ndonecek deger : " + fxmlMoveForward);
            return fxmlMoveForward;
        }
    }

    protected void updateChangePlayerLocationFunctionOfFxmlMove(FxmlMove fxmlMove, ChangePlayerLocation changePlayerLocation) {
        fxmlMove.setChangePlayerLocation(changePlayerLocation);
    }
//    protected void fillFxmlMoveBack() {
//        fxmlMoveBack = new FxmlMoveBack(game, gameController);
//        fxmlMoveForward.setMoveForward(player.getPlayerMove().getMoveForward());
//    }

//    public boolean isMovementLocked() {
//        return movementLocked;
//    }
//
//    public void setMovementLocked(boolean movementLocked) {
//        this.movementLocked = movementLocked;
//    }
    }
