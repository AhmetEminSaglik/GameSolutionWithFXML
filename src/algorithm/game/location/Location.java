package algorithm.game.location;

public class Location {

    private int x = 0, y = 0;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{x=" + getX() + ", y=" + getY() + "}";
    }

    public void printLocation() {
        System.out.println(toString());
    }

    /**
     * return Location of
     *
     * @param compass = is used to specify keyboradCommpas or DirectionCompass
     * @param directionIndex = is used to get index and index changes according
     * to Compass (Compass is abstract)
     */
}
