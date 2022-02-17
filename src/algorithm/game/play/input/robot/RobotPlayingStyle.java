package algorithm.game.play.input.robot;

import algorithm.game.gamerepo.player.Player;
import algorithm.game.play.input.PlayerPlayingStyle;
import scene.game.SquareButton;

public class RobotPlayingStyle extends PlayerPlayingStyle {
    public RobotPlayingStyle(Player player) {
        super(player);
    }

    @Override
    public void play(SquareButton button) {
        System.out.println("robot burada oynicak");

    }

    @Override
    public void stepBack() {

    }
}
