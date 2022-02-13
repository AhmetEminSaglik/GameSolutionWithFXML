package preparegamebyselectingmenu;

import algorithm.Main.ISelectPlayer;
import algorithm.game.Game;
import algorithm.game.gamerepo.BuildGame;
import algorithm.game.gamerepo.IDetermineEdgeValue;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.play.PlayGame;

public class PrepareGameBySelectingMenu {

    private BuildGame buildGameModel;
    private Player player;
    private Game game;
    private int edgeValue;

    public void startGame() {
//        buildGameModel();
        createGame();
        createVisitedArea();
        System.out.println(toString());
    }

    public void buildGameModel(IDetermineEdgeValue iDetermineEdgeValue) {
        buildGameModel = new BuildGame(iDetermineEdgeValue);

    }

    public void createGame() {
        game = buildGameModel.createGame();
    }

    public void selectPlayer(ISelectPlayer iSelectPlayer) {
        player = iSelectPlayer.selectPlayer(game);

    }

    public void createVisitedArea() {
        buildGameModel.createVisitedArea();
    }

    public void playGame() {
        PlayGame playGame = new PlayGame(game);
        playGame.playGame();

    }

    public BuildGame getBuildGameModel() {
        return buildGameModel;
    }

    public void setBuildGameModel(BuildGame buildGameModel) {
        this.buildGameModel = buildGameModel;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getEdgeValue() {
        return edgeValue;
    }

    public void setEdgeValue(int edgeValue) {
        this.edgeValue = edgeValue;
    }

    @Override
    public String toString() {
        return "PrepareGameBySelectingMenu{" +
                "buildGameModel=" + buildGameModel +
                ", player=" + player +
                ", game=" + game +
                ", edgeValue=" + edgeValue +
                '}';
    }
}
