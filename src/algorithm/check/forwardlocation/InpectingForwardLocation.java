package algorithm.check.forwardlocation;

import algorithm.drone.Drone;
import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.Location;
import algorithm.game.location.LocationsList;
import algorithm.squareprocess.SquareProcess;


import java.util.ArrayList;

public class InpectingForwardLocation {
    SquareProcess squareProcess = new SquareProcess();
    ArrayList<DirectionLocation> locationsList;

    public ArrayList<Location> inspectLocationAndGetAvailableSquareNumbers(Game game, DirectionLocation locationNeededToInspect) {
        ArrayList<Location> availableLocationList = new ArrayList<>();
        Drone drone = buildDrone(game, locationNeededToInspect);
        locationsList = new LocationsList().getListOfLocationsAccordingToPlayerCompass(game.getPlayer().getCompass());
        int availableLocationNumberToMove = 0;
        for (int i = 0; i < locationsList.size() - 1; i++) {
            if (squareProcess.isAreaAvailableToVisit(game, drone.getLocation(), locationsList.get(i)))
                availableLocationList.add(locationsList.get(i));
//            availableLocationNumberToMove++;
        }
//        return availableLocationNumberToMove;
        return availableLocationList;
    }

    Drone buildDrone(Game game, DirectionLocation locationNeededToInspect) {

        Drone drone = new Drone();
        drone.getLocation().setX(game.getPlayer().getLocation().getX() + locationNeededToInspect.getX());
        drone.getLocation().setY(game.getPlayer().getLocation().getY() + locationNeededToInspect.getY());

        return drone;
    }

}
