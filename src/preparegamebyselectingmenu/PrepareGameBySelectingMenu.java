package preparegamebyselectingmenu;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.BuildGame;
import algorithm.game.gamerepo.IDetermineEdgeValue;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.PlayerSpecialStuffToPrepareBeforeStartGame;
import algorithm.game.play.PlayGame;
import algorithm.game.play.input.PlayerPlayingStyle;

public class PrepareGameBySelectingMenu {

    private BuildGame buildGameModel;
    private Player player;
    private Game game;
    private int edgeValue;
    private PlayerPlayingStyle playerPlayingStyle;
    private PlayerSpecialStuffToPrepareBeforeStartGame playerSpecialStuffToPrepareBeforeStartGame;

    public void prepareGame() {
        prepareAllStuffs();
    }

    void prepareAllStuffs() {

        createGame();
        createVisitedArea();
        player.setStep(0);
        game.setPlayer(player);
        player.setGame(game);

    }

    public void buildGameModel(IDetermineEdgeValue iDetermineEdgeValue) {
        edgeValue = iDetermineEdgeValue.determineEdgeValue();
        buildGameModel = new BuildGame(iDetermineEdgeValue);

    }


    public void createGame() {
        game = buildGameModel.createGame();

    }


    public void createVisitedArea() {
        buildGameModel.createVisitedArea();
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


    public PlayerPlayingStyle getPlayerPlayingStyle() {
        return playerPlayingStyle;
    }

    public void setPlayerPlayingStyle(PlayerPlayingStyle playerPlayingStyle) {
        this.playerPlayingStyle = playerPlayingStyle;
    }
    public PlayerSpecialStuffToPrepareBeforeStartGame getPlayerSpecialStuffToPrepareBeforeStartGame() {
        return playerSpecialStuffToPrepareBeforeStartGame;
    }

    public void setPlayerSpecialStuffToPrepareBeforeStartGame(PlayerSpecialStuffToPrepareBeforeStartGame playerSpecialStuffToPrepareBeforeStartGame) {
        this.playerSpecialStuffToPrepareBeforeStartGame = playerSpecialStuffToPrepareBeforeStartGame;
    }

}
