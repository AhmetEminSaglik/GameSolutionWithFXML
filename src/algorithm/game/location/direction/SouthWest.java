package algorithm.game.location.direction;

import algorithm.game.location.DirectionLocation;

public class SouthWest extends DirectionLocation {

    @Override
    public int getId() {
        return getCompass().getSouthWest();
    }

    @Override
    public int getX() {
        return -2;
    }

    @Override
    public int getY() {
        return -2;
    }

}
