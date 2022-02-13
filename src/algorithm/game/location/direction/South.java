package algorithm.game.location.direction;


import algorithm.game.location.DirectionLocation;

public class South extends DirectionLocation {

    @Override
    public int getId() {
        return getCompass().getSouth();
    }

    @Override
    public int getY() {
        return -3;
    }

}
