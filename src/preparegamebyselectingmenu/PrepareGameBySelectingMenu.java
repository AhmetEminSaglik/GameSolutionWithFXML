package preparegamebyselectingmenu;


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
    //    PlayGameWithGameController playGameFXML;
    private PlayerPlayingStyle playerPlayingStyle;
    private PlayerSpecialStuffToPrepareBeforeStartGame playerSpecialStuffToPrepareBeforeStartGame;

    public void prepareGame() {
//        buildGameModel();
        prepareAllStuffs();
//        playGameFXML = new PlayGameWithGameController(this);
//        getPlayerPlayingStyle().prepareGame();
    }

    void prepareAllStuffs() {
        createGame();
        createVisitedArea();
        player.setStep(0);
        game.setPlayer(player);
        player.setGame(game);
//        playerSpecialStuffToPrepareBeforeStartGame.prepare();
//        player.getIPlayerInput()

    }

    public void buildGameModel(IDetermineEdgeValue iDetermineEdgeValue) {
//        System.out.println("gelen deger : "+iDetermineEdgeValue.determineEdgeValue());
        edgeValue = iDetermineEdgeValue.determineEdgeValue();
        buildGameModel = new BuildGame(iDetermineEdgeValue);

    }

    public void createGame() {
        game = buildGameModel.createGame();

    }

//    public void selectPlayer(Player player/*ISelectPlayer iSelectPlayer*/) {
////        player = iSelectPlayer.selectPlayer(game);
//        this.player = player;
//
//    }

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


    public PlayerPlayingStyle getPlayerPlayingStyle() {
        return playerPlayingStyle;
    }

    public void setPlayerPlayingStyle(PlayerPlayingStyle playerPlayingStyle) {
        this.playerPlayingStyle = playerPlayingStyle;
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

    public PlayerSpecialStuffToPrepareBeforeStartGame getPlayerSpecialStuffToPrepareBeforeStartGame() {
        return playerSpecialStuffToPrepareBeforeStartGame;
    }

    public void setPlayerSpecialStuffToPrepareBeforeStartGame(PlayerSpecialStuffToPrepareBeforeStartGame playerSpecialStuffToPrepareBeforeStartGame) {
        this.playerSpecialStuffToPrepareBeforeStartGame = playerSpecialStuffToPrepareBeforeStartGame;
    }
}
