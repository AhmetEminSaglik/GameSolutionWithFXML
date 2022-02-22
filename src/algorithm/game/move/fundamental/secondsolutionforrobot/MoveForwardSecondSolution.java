package algorithm.game.move.fundamental.secondsolutionforrobot;


import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.gamerepo.player.robot.solution.second.exitsituation.ExitSituation;
import algorithm.game.gamerepo.player.robot.solution.second.navigation.Navigation;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.move.fundamental.MoveForward;

public class MoveForwardSecondSolution extends MoveForward {
    public MoveForwardSecondSolution(Game game) {
        super(game);

    }

    Robot robot = (Robot) game.getPlayer();
    Navigation navigation;

    DirectionLocation lastLocation = new LocationsList().getLastLocation(robot.getCompass());

    @Override
    public void prepareAllStuff() {
        navigation = robot.getRobotMemory().getRoadMemory().getOneWayListLastItem();
    }

    @Override
    public void updateBeforeStep() {
//        ShowPanel.show(getClass(),"MOVE FORWARD second solution updateBeforeStep");

        super.updateBeforeStep();
        doIfThereAreThingsTodoInOneWayNumberProcess();
    }

    @Override
    public void updateAfterStep() {
        super.updateAfterStep();

    }

    void doIfThereAreThingsTodoInOneWayNumberProcess() {
        if (!isNavigationNull() && navigation.getStep() == robot.getStep()) {
            processAccordingToOneWayNumber();
        }
    }


    boolean isDirectionSame(DirectionLocation d1, DirectionLocation d2) {

        if (d1.getX() == d2.getX() && d1.getY() == d2.getY()) {
            return true;
        }
        return false;

    }

    void processAccordingToOneWayNumber() {
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        ShowPanel.show(getClass(),"processAccordingToOneWayNumber");
        if (navigation.getOneWayNumbersValue() == 2) {
            if (robot.getRobotMemory().getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_FREE) {
                locateExitSituation();
            }

            if (isDirectionSame(getDirectionLocation(), navigation.getCompulsoryLocation())) {
                navigation.setCompulsoryLocation(new LocationsList().getLastLocation(robot.getCompass()));

            }
        } else if (navigation.getOneWayNumbersValue() == 1 &&
                robot.getRobotMemory().getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_LOCATED &&
                !navigation.isExitSituationWasLocatedInThisStep()) {
            navigation.setCompulsoryLocation(new LocationsList().getLastLocation(robot.getCompass()));
        }
    }

    void locateExitSituation() {
        robot.getRobotMemory().getRoadMemory().updateExistSituation(ExitSituation.EXIT_LOCATED);
        navigation.setExitSituationWasLocatedInThisStep(true);
    }

    boolean isNavigationNull() {
        if (navigation == null)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "MoveForwardSecondSolution{" +
                "game=" + game +
                ", updateValuesInGameModel=" + updateValuesInGameModel +
                ", robot=" + robot +
                ", navigation=" + navigation +
                ", lastLocation=" + lastLocation +
                '}';
    }
}
