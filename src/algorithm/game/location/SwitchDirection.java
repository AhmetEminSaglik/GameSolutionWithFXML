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
//            System.out.println("NORTH GIRDIIII");
            return new North();
        }
        if (compass.getNorthEast() == value) {
            return new NorthEast();
        }
        if (compass.getEast() == value) {
            return new East();
        }
        if (compass.getSouthEast() == value) {
            return new SouthEast();
        }
        if (compass.getSouth() == value) {
            return new South();
        }
        if (compass.getSouthWest() == value) {
            return new SouthWest();
        }
        if (compass.getWest() == value) {
            return new West();
        }
        if (compass.getNorthWest() == value) {
            return new NorthWest();
        }
        if (compass.getLastLocation() == value) {
            return new LastLocation();
        }

        ErrorMessage.appearClassicError(getClass(), " compass  : " + compass.getClass().getSimpleName() + " -> Unknow Option  : " + value);

        return null;
    }

}
