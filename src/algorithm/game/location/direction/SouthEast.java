package algorithm.game.location.direction;

import algorithm.game.location.DirectionLocation;

public class SouthEast extends DirectionLocation {

    @Override
    public int getId() {
        return getCompass().getSouthEast();
    }

    @Override
    public int getX() {
        return 2;
    }

    @Override
    public int getY() {
        return -2;
    }

}
