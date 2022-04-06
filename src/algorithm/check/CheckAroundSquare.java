package algorithm.check;

import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.Location;
import algorithm.game.location.LocationsList;

import java.util.ArrayList;


public class CheckAroundSquare extends BaseCheck {

    Game game;
    CheckSquare checkSquare = new CheckSquare();
    ArrayList<DirectionLocation> locationList;

    public CheckAroundSquare(Game game) {
        this.game = game;
        locationList = new LocationsList().getListOfLocationsAccordingToPlayerCompass(game.getPlayer().getCompass());
    }
    public boolean isThereAnyAvailableSquare() {
        setCompass(game.getPlayer().getCompass());
        checkSquare.setCompass(getCompass());

        for (int i = 0; i < locationList.size(); i++) {
            if (isLocationAvailable(game, locationList.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    boolean isLocationAvailable(Game game, int directionIndex) {
        Location locationWillBeCheck = getPlayerLocation(game);
        return checkSquare.isSquareFreeFromVisitedArea(game, locationWillBeCheck, directionIndex);
    }
}
