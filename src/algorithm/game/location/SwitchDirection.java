package algorithm.game.location;


import algorithm.compass.Compass;
import algorithm.errormessage.ErrorMessage;
import algorithm.game.location.direction.*;

public class SwitchDirection {

    Compass compass;

    public SwitchDirection(Compass compass) {
        this.compass = compass;
    }

    public DirectionLocation choseDirection(int value) {
//        ShowPanel.show(getClass(),"compass.getNorth() "+compass.getNorth()+" value : "+value);

        if (compass.getNorth() == value) {
            North north = new North();
            north.setCompass(compass);
            return north;
        }
        if (compass.getNorthEast() == value) {
            NorthEast northEast = new NorthEast();
            northEast.setCompass(compass);
            return northEast;
        }
        if (compass.getEast() == value) {
            East east = new East();
            east.setCompass(compass);
            return east;
        }
        if (compass.getSouthEast() == value) {
            SouthEast southEast = new SouthEast();
            southEast.setCompass(compass);
            return southEast;
        }
        if (compass.getSouth() == value) {
            South south = new South();
            south.setCompass(compass);
            return south;
        }
        if (compass.getSouthWest() == value) {
            SouthWest southWest = new SouthWest();
            southWest.setCompass(compass);
            return southWest;
        }
        if (compass.getWest() == value) {
            West west = new West();
            west.setCompass(compass);
            return west;
        }
        if (compass.getNorthWest() == value) {
            NorthWest northWest = new NorthWest();
            northWest.setCompass(compass);
            return northWest;
        }
        if (compass.getLastLocation() == value) {
            LastLocation lastLocation = new LastLocation();
            lastLocation.setCompass(compass);
            return lastLocation;
        }

        ErrorMessage.appearClassicError(getClass(), " compass  : " + compass.getClass().getSimpleName() + " -> Unknow Option  : " + value);

        return null;
    }

}
