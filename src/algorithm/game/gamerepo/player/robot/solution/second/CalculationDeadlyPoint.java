package algorithm.game.gamerepo.player.robot.solution.second;

import algorithm.game.Game;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.gamerepo.player.robot.solution.second.exitsituation.ExitSituation;

public class CalculationDeadlyPoint {
    Game game;
    Robot robot;
    public final static int IS_DEAD_SO_MOVE_BACK = -1, IS_FREE_SO_MOVE_FORWARD = 1;

    public CalculationDeadlyPoint(Game game) {
        this.game = game;
        robot = (Robot) game.getPlayer();
    }

    public int calculateDeadlyPoint(int oneWayNumbersValue) {
        ExitSituation exitSituation = robot.getRobotMemory().getRoadMemory().getExitSituation();
        double calculation = 1 - (double) (exitSituation.getSituation() + oneWayNumbersValue) / 2;
        return decideDeadlyPointCalculation(calculation);
    }

    private int decideDeadlyPointCalculation(double calculation) {
        if (calculation >= 0) {
            return IS_FREE_SO_MOVE_FORWARD;
        }
        return IS_DEAD_SO_MOVE_BACK;
    }
}
