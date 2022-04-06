package algorithm.compass;

public class DirectionCompass extends Compass {

    public DirectionCompass() {
        fillValues();
    }

    @Override
    void fillValues() {
        setNorth(0);
        setNorthEast(1);
        setEast(2);
        setSouthEast(3);
        setSouth(4);
        setSouthWest(5);
        setWest(6);
        setNorthWest(7);
        setLastLocation(8);
    }

}
