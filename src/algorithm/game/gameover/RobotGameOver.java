package algorithm.game.gameover;


import algorithm.check.CheckSquare;
import algorithm.game.Game;
import algorithm.game.location.Location;

public class RobotGameOver implements IGameOver {

    Game game;
    int squareEdge;

    public RobotGameOver(Game game) {
        this.game = game;
        squareEdge = game.getModel().getGameSquares().length;
    }

    @Override
    public boolean isGameOver(Game game) {
        if (isRobotFinishedAllLocations() &&
                allDirectionsAreVisitedAtStep1()) {
            System.out.println("All Solutions are DONE  ::::\n");
            return true;
        }
        return false;
    }


    boolean isRobotFinishedAllLocations() {
        Location robotLocation = game.getPlayer().getLocation();

        if (robotLocation.getX() == squareEdge - 1 &&
                robotLocation.getY() == squareEdge - 1) {
            return true;
        }
        return false;

    }

    boolean allDirectionsAreVisitedAtStep1() {
        if (game.getPlayer().getStep() == 1) {
            return !(new CheckSquare().isAnySquareAvailableInVisitedDirection(game, game.getPlayer().getLocation()));
        }
        return false;
    }
}
