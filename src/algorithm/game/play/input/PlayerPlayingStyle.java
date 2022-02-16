package algorithm.game.play.input;

import algorithm.game.gamerepo.player.Player;
import javafx.scene.control.Button;
import scene.game.SquareButton;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerPlayingStyle {
    protected Player player;
    public final  static String CURRENT_BTN_ID = "currentBtn";
    public final  static String NORMAL_SQUARE_BTN_ID = SquareButton.NORMAL_SQUARE_BTN_ID;
    public final  static String VISITED_BEFORE_BTN_ID = "visitedSquareBtn";
    public final  static String HINT_BTN_ID = "hintBtn";
    public List<SquareButton> listMovedSquareBtn = new ArrayList<>();
    public PlayerPlayingStyle(Player player) {
        this.player = player;
    }

    public abstract void play(SquareButton button/*int x, int y*/);

}
