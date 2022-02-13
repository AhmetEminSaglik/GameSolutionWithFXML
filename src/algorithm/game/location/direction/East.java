package algorithm.game.location.direction;

import algorithm.game.location.DirectionLocation;

public class East extends DirectionLocation {

    @Override
    public int getId() {
        return getCompass().getEast();
    }

    @Override
    public int getX() {
        return 3;
    }

}
