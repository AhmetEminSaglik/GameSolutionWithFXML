package algorithm.game.move;

import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.Location;

public class ChangeLocationByExactlyLocation extends ChangePlayerLocation {

    public ChangeLocationByExactlyLocation(Player player) {
        super(player);
    }

    public void changePlayerLocationByExcatlyLocation(Location location) {
        xChangeLocationByExcatly(location.getX());
        yChangeLocationByExcatly(location.getY());
    }

    @Override
    public void change(Location location) {
        changePlayerLocationByExcatlyLocation(location);
    }
}
