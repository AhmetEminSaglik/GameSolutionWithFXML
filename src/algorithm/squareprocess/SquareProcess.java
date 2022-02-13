package algorithm.squareprocess;

import algorithm.check.CheckSquare;
import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.Location;

public class SquareProcess {
    CheckSquare checkSquare = new CheckSquare();

    public boolean isSquareAvailableToMoveOnIt(Game game, Location currentProcessLocation, DirectionLocation directionLocation) {

        if (isAreaAvailableToVisit(game, currentProcessLocation, directionLocation)
                && isDirectionAvailableToVisit(game, currentProcessLocation, directionLocation)) {
            return true;
        }
        return false;
    }

    public boolean isAreaAvailableToVisit(Game game, Location playerLocation, DirectionLocation location) {
        location.setCompass(game.getPlayer().getCompass());
//        System.out.println("locatino getCompass : "+location.getCompass());

        return checkSquare.isSquareFreeFromVisitedArea(game, playerLocation, location.getId());
    }

    public boolean isDirectionAvailableToVisit(Game game, Location currentProcessLocation, DirectionLocation location) {
        return checkSquare.isSquareFreeFromVisitedDirection(game, currentProcessLocation, location.getId());
    }

}
