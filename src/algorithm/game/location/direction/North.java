package algorithm.game.location.direction;

import algorithm.game.location.DirectionLocation;


public class North extends DirectionLocation {

    @Override
    public int getId() {
        return getCompass().getNorth();
    }

    @Override
    public int getY() {
        return 3;
    }

}
