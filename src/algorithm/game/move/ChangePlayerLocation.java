package algorithm.game.move;

import algorithm.game.gamerepo.player.Player;

public  abstract class ChangePlayerLocation implements ChangeLocation {

    Player player;

    public ChangePlayerLocation(Player player) {
        this.player = player;
    }

    void xChangeLocationByAdding(int x) {
        player.getLocation().setX(player.getLocation().getX() + x);
    }

    void yChangeLocationByAdding(int y) {
        player.getLocation().setY(player.getLocation().getY() + y);
    }

 /*   public void changePlayerLocationByAdding(Location location) {
        xChangeLocationByAdding(location.getX());
        yChangeLocationByAdding(location.getY());
    }

    public void changePlayerLocationByExcatlyLocation(Location location) {
        xChangeLocationByExcatly(location.getX());
        yChangeLocationByExcatly(location.getY());
    }*/

    void xChangeLocationByExcatly(int x) {
        player.getLocation().setX(x);
    }

    void yChangeLocationByExcatly(int y) {
        player.getLocation().setY(y);
    }


}
