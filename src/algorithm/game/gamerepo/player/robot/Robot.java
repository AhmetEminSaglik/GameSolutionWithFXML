package algorithm.game.gamerepo.player.robot;

import algorithm.compass.Compass;
import algorithm.compass.DirectionCompass;
import algorithm.game.Game;
import algorithm.game.gameover.RobotGameOver;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.robot.memory.RoadMemory;
import algorithm.game.gamerepo.player.robot.memory.RobotMemory;
import algorithm.game.gamerepo.player.robot.solution.BaseSolution;
import algorithm.game.location.DirectionLocation;
import algorithm.game.play.PlayerMove;
import algorithm.game.play.input.robot.RobotInput;
import algorithm.game.rule.BaseGameRule;


public class Robot extends Player {
    private RobotMemory robotMemory;
    //    RoadMemory roadMemory = new RoadMemory();
    private BaseSolution solution;
    int recordValueForEachSquare;

    public Robot() {
        robotMemory = new RobotMemory(game);
        printAbleEveryStep = false;
    }

    //    public Robot(Game game/*, BaseSolution solution*/) {
//        super(game);
//        this.game = game;
//        robotMemory = new RobotMemory(game);
////        this.solution = solution;
////        solution.buildRobotMove();
////        playerMove = new PlayerMove(/*new RobotMove(game),*/ solution.getMoveForward(), solution.getMoveBack());
////       setName(solution.getClass().getSimpleName() + "_" + game.getModel().getGameSquares());
//        printAbleEveryStep = false;
//    }
    /*public Robot(Game game, BaseSolution solution) {
        super(game);
        robotMemory = new RobotMemory(game);
        this.solution = solution;
        solution.buildRobotMove();
        playerMove = new PlayerMove(*//*new RobotMove(game),*//* solution.getMoveForward(), solution.getMoveBack());
        setName(solution.getClass().getSimpleName() + "_" + game.getModel().getGameSquares());
        printAbleEveryStep = false;
    }*/

    @Override
    public Compass getCompass() {
        return new DirectionCompass();
    }

    @Override
    public int getInput(Game game) {
        return new RobotInput(solution, game).getInput();//getRobotMemory()
    }

    public BaseSolution getSolution() {
        return solution;
    }

    public void setSolution(BaseSolution solution) {
        this.solution = solution;
        solution.buildRobotMove();
        setName(solution.getClass().getSimpleName() + "_" + game.getModel().getGameSquares());
        setPlayerMove();
    }

    @Override
    public void setPlayerMove() {
        playerMove = new PlayerMove(/*new RobotMove(game),*/ solution.getMoveForward(), solution.getMoveBack());
    }

    @Override
    public BaseGameRule getGameRule() {
        if (gameRule == null) {
            gameRule = new BaseGameRule(new RobotGameOver(getGame()));
        }
        return gameRule;
    }

    @Override
    public void updateVisitedDirection(boolean sealOrUnseal, int step, DirectionLocation location) {
        assert (getStep() > 1) : getClass().getName() + " >>> ADIM SAYUISI " + getStep() + " GELDI";
        location.setCompass(getGame().getPlayer().getCompass());
        getVisitedDirections()[step][location.getId()] = sealOrUnseal;
    }

    public int getRecordValueForEachSquare() {
        return recordValueForEachSquare;
    }

    public void increaseRecordValueForEachSquare() {
        recordValueForEachSquare++;
    }

    public void decreaseRecordValueForEachSquare() {
        recordValueForEachSquare--;
    }

    public void resetRecordValueForEachSquare() {
        recordValueForEachSquare = 0;
    }

    public RobotMemory getRobotMemory() {
        return robotMemory;
    }

    @Override
    public boolean isPrintableStepSituation() {
        return printAbleEveryStep;
    }
//    public RoadMemory getRoadMemory() {
//        return roadMemory;
//    }
}
