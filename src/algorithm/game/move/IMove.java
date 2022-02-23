package algorithm.game.move;

import algorithm.game.location.DirectionLocation;

public interface IMove {

    void prepareAllStuff();

    void updatePlayerStepValue();

    void updateVisitedArea();

    void updateVisitedDirection();

    void updatePlayerLocation();

    void updateBeforeStep();

    void updateAfterStep();

    boolean isRequiredToChangeStartLocation();

    void changeStartLocation(DirectionLocation directionLocation);
}
