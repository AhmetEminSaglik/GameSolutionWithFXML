package algorithm.compass;

public abstract class Compass {


    int north;
    int northEast;
    int east;
    int southEast;
    int south;
    int southWest;
    int west;
    int northWest;

    int lastLocation;

    public int getNorth() {
        return north;
    }

    public void setNorth(int value) {
        north = value;
    }

    public int getNorthEast() {
        return northEast;
    }

    public void setNorthEast(int value) {
        northEast = value;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int value) {
        east = value;
    }

    public int getSouthEast() {
        return southEast;
    }

    public void setSouthEast(int value) {
        southEast = value;
    }

    public int getSouth() {
        return south;
    }

    public void setSouth(int value) {
        south = value;
    }

    public int getSouthWest() {
        return southWest;
    }

    public void setSouthWest(int value) {
        southWest = value;
    }

    public int getWest() {
        return west;
    }

    public void setWest(int value) {
        west = value;
    }

    public int getNorthWest() {
        return northWest;
    }

    public void setNorthWest(int value) {
        northWest = value;
    }

    public int getLastLocation() {
        return lastLocation;
    }

    /**
     * @param lastLocation = to move before before Location
     */
    public void setLastLocation(int lastLocation) {
        this.lastLocation = lastLocation;
    }

    abstract void fillValues();

    @Override
    public String toString() {
        return "Compass : " + getClass().getSimpleName();
    }

}
