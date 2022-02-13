package algorithm.compass;

public class KeyboardCompass extends Compass {
    
    public KeyboardCompass() {
        fillValues();
    }
    
    @Override
    void fillValues() {
        setNorth(8);
        setNorthEast(9);
        setEast(6);
        setSouthEast(3);
        setSouth(2);
        setSouthWest(1);
        setWest(4);
        setNorthWest(7);
        setLastLocation(5);
    }
 
}
