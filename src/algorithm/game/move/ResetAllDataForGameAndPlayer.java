package algorithm.game.move;

import algorithm.game.Game;
import algorithm.game.gamerepo.BuildGame;
import algorithm.game.gamerepo.IDetermineEdgeValue;
import algorithm.game.gamerepo.player.Player;

public class ResetAllDataForGameAndPlayer {
    int squareEdge;
    BuildGame buildGame;

    public ResetAllDataForGameAndPlayer(Game game) throws InterruptedException {
        squareEdge = game.getModel().getGameSquares().length;
        buildGame = new BuildGame(new IDetermineEdgeValue() {
            @Override
            public int determineEdgeValue() {
                return squareEdge;
            }
        });
    }


    public void clearGameData(Game game) throws InterruptedException {
        game.getModel().setGameSquares(new int[squareEdge][squareEdge]);
        game.getModel().setVisitedAreas(new boolean[squareEdge][squareEdge]);
    }

    public void clearPlayerData(Player player) {
        player.clearVisitedDirections();
        player.clearStepValue();
    }

}
