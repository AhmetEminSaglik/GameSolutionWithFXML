package algorithm.game.move;

import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.Location;

public class ChangeLocationByAdding extends ChangePlayerLocation {
    public ChangeLocationByAdding(Player player) {
        super(player);
    }

    public void changePlayerLocationByAdding(Location location) {
        xChangeLocationByAdding(location.getX());
        yChangeLocationByAdding(location.getY());
    }

    @Override
    public void change(Location location) {
        changePlayerLocationByAdding(location);
    }
}
