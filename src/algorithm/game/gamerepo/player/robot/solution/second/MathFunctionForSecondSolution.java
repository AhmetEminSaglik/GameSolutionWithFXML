package algorithm.game.gamerepo.player.robot.solution.second;

import algorithm.check.forwardlocation.InpectingForwardLocation;
import algorithm.compass.DirectionCompass;
import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.gamerepo.player.robot.solution.second.exitsituation.ExitSituation;
import algorithm.game.gamerepo.player.robot.solution.second.navigation.Navigation;
import algorithm.game.gamerepo.player.robot.solution.second.navigation.NavigationService;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.Location;
import algorithm.game.location.LocationsList;
import algorithm.squareprocess.SquareProcess;
import algorithm.weights.WeightOfAvailableWay;

import java.util.ArrayList;

public class MathFunctionForSecondSolution {
    Game game;
    Location playerLocation;
    ArrayList<DirectionLocation> locationsList;
    final DirectionLocation lastLocation;// locationsList.get(locationsList.size() - 1);
    DirectionLocation selectedDirection;
    SquareProcess squareProcess = new SquareProcess();
    WeightOfAvailableWay weightOfAvailableWay = new WeightOfAvailableWay();
    Robot robot;
    final int edgeValue;
    DirectionLocation compulsoryLocation = null;
    Navigation navigation = new Navigation();
    //    PrintAble printAble;
    int oneWayNumbersValue;
    boolean killRequestByAvailableProcessFunction = false;
    NavigationService navigationService = new NavigationService();


    public MathFunctionForSecondSolution(Game game, Location playerLocation) {
        this.game = game;
        this.playerLocation = playerLocation;
        robot = (Robot) game.getPlayer();
        edgeValue = game.getModel().getGameSquares().length;
        locationsList = new LocationsList().getListOfLocationsAccordingToPlayerCompass(game.getPlayer().getCompass());
//        calculationDeadlyPoint = new CalculationDeadlyPoint(game);
        lastLocation = new LocationsList().getLastLocation(game.getPlayer().getCompass());
        selectedDirection = lastLocation;
    }


    public int calculateFunctionResult() {

        if (isNavigationInRoadMemoryAvailableForThisStep()) {
            navigationService.setCompulsoryLocationToNavigation(game, navigation, lastLocation);
            try {
                selectedDirection = navigationService.getCompulsoryLocation(navigation);
                return selectedDirection.getId();
            } catch (Exception e) {
            }
        }

        calculateForwardAvailableDirectionsOfCurrentDirection();

        double calculationOfDeadlyPoint = calculateDeadlyPoint();

        if (calculationOfDeadlyPoint == CalculationDeadlyPoint.IS_FREE_SO_MOVE_FORWARD) {
            navigation = buildNavigation();
            addNavigationToRoadMemoryList();
        }
        if(game.getPlayer().getStep()==0 || selectedDirection==lastLocation){
            ShowPanel.show(getClass(),"Adim sayisi 0 ve geri adim istegi donuyor");
        }
        return selectedDirection.getId();


    }


    boolean isNavigationInRoadMemoryAvailableForThisStep() {
        navigation = getLastNavigationFromRoadMemory();
        if (navigation != null && navigation.getStep() == robot.getStep()) {
            return true;
        }
        return false;
    }

    Navigation getLastNavigationFromRoadMemory() {
        if (robot.getRobotMemory().getRoadMemory().getOneWayNumbersList().size() > 0) {
            return robot.getRobotMemory().getRoadMemory().getOneWayListLastItem();
        }
        return null;
    }


    Navigation buildNavigation() {
        return navigationService.buildNavigation(game, oneWayNumbersValue, compulsoryLocation);
//        Navigation navigation = new Navigation();
//
//        navigation.setStep(robot.getStep());
//
//        navigation.setOneWayNumbersValue(oneWayNumbersValue);
//
//        if (compulsoryLocation != null) {
//            System.out.println("AAAAAAAAAAAAAAAAAAA step : " + robot.getStep());
//            navigation.setCompulsoryLocation(compulsoryLocation);
//        }
//
//
//        return navigation;
    }


    void calculateForwardAvailableDirectionsOfCurrentDirection() {

        double weightResult = -1;
        InpectingForwardLocation inpectingForwardLocation = new InpectingForwardLocation();

        for (int i = 0; i < locationsList.size() - 1; i++) {
            if (squareProcess.isSquareAvailableToMoveOnIt(game, playerLocation, locationsList.get(i))) {
                DirectionLocation location = locationsList.get(i);

                ArrayList<Location> availableLocationList = inpectingForwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, location);
                int availableWayNumber = availableLocationList.size();

                if (isAvailableWayEqualsToZero(availableWayNumber) && !isNextStepWillBeEqualsToTotalSquareValue()) {
                    selectedDirection = lastLocation;
                    return;
                }
                if (weightOfAvailableWay.getWeightOfDirection()[availableWayNumber] > weightResult) {
                    weightResult = calculateWeightResult(availableWayNumber);
                    selectedDirection = location;
                }
                if (availableWayNumber == 1) {
                    processAccordingToOneWayNumber(location);
                }
                if (isRequestedToKillFunctionByOneWayAvailableNumberProcess()) {

                    return;
                }

            }

        }
    }

    boolean isExitSituationLocated() {
        if (robot.getRobotMemory().getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_LOCATED)
            return true;
        return false;
    }

    void processAccordingToOneWayNumber(DirectionLocation location) {


        oneWayNumbersValue++;

        if (isExitSituationLocated()) {
            compulsoryLocation = lastLocation;
        }
        if (oneWayNumbersValue == 2) {
            compulsoryLocation = location;
        }
        if (isOneWayNumberTooMuchToRunHealtyTheAlgorithm()) {
            selectedDirection = lastLocation;
            killRequestByAvailableProcessFunction = true;
            return;
        }

    }

    boolean isRequestedToKillFunctionByOneWayAvailableNumberProcess() {
        return killRequestByAvailableProcessFunction;
    }

    boolean isAvailableWayEqualsToZero(int availableWayNumber) {
        if (availableWayNumber == 0) {
            return true;
        }
        return false;
    }

    boolean isNextStepWillBeEqualsToTotalSquareValue() {
        if (robot.getStep() == (edgeValue * edgeValue) - 1) {
            return true;
        }
        return false;
    }


    double calculateWeightResult(int availableWayNumber) {
        return weightOfAvailableWay.getWeightOfDirection()[availableWayNumber];
    }

    boolean isOneWayNumberTooMuchToRunHealtyTheAlgorithm() {
        if (oneWayNumbersValue >= 3)
            return true;
        return false;
    }

    int calculateDeadlyPoint() {
//        CalculationDeadlyPoint calculationDeadlyPoint = new CalculationDeadlyPoint(game);
        return new CalculationDeadlyPoint(game).calculateDeadlyPoint(oneWayNumbersValue);
//        return calculationDeadlyPoint.calculateDeadlyPoint(oneWayNumbersValue);
        /*ExitSituation exitSituation = robot.getRobotMemory().getRoadMemory().getExitSituation();
        double calculation = 1 - (double) (exitSituation.getSituation() + oneWayNumbersValue) / 2;
        return decideDeadlyPointCalculation(calculation);*/
    }

    /*int decideDeadlyPointCalculation(double calculation) {
        if (calculation >= 0) {
            return IS_FREE_SO_MOVE_FORWARD;
        }
        return IS_DEAD_SO_MOVE_BACK;
    }*/

    void addNavigationToRoadMemoryList() {

        if (oneWayNumbersValue >= 1) {
//            robot.getRobotMemory().getRoadMemory().getOneWayNumbersList().add(navigation);
            navigationService.addNavigationToRoadMemoryList(navigation, (Robot) game.getPlayer());
        }
    }

}
