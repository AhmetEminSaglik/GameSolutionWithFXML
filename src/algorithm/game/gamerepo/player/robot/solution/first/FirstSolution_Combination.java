package algorithm.game.gamerepo.player.robot.solution.first;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.robot.solution.BaseSolution;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.move.fundamental.MoveForward;

import java.util.ArrayList;

public class FirstSolution_Combination extends BaseSolution {

//    public FirstSolution_Combination(Game game) {
//        super(game);
//    }

    @Override
    public int getLocationInput(Game game) {
        prepareation();
        ArrayList<DirectionLocation> locationsList =
                new LocationsList().getListOfLocationsAccordingToPlayerCompass
                        (game.getPlayer().getCompass());




        for (int i = 0; i < locationsList.size() - 1; i++) {

            if (squareProcess.isSquareAvailableToMoveOnIt(game, playerLocation, locationsList.get(i))) {
                return locationsList.get(i).getId();
            }
        }
//        }
        return locationsList.get(locationsList.size() - 1).getId(); //LastLocation

    }

    @Override
    public void buildRobotMove() {
        setMoveForward(new MoveForward(getGame()));
        setMoveBack(new MoveBack(getGame()));
        System.out.println("buraya girip move forward ve move back dolduruldu");
        System.out.println("move forward : "+getMoveForward());
        System.out.println("move back : "+getMoveBack());
    }

    @Override
    public String toString() {
        return  "First Solution  {"+super.toString()+'}';
    }
}
