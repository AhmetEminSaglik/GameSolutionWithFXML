package algorithm.game.play;

import algorithm.game.gamerepo.player.Player;

public class TimeCalcuation {

    public String getTotalPassedTime(Player player) {
        return player.getTimeKeeper().getTotalPassedTimeDuringPlayingGame();
    }
}
