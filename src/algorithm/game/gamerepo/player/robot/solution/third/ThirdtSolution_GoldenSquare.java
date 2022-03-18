package algorithm.game.gamerepo.player.robot.solution.third;

import algorithm.game.Game;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.gamerepo.player.robot.solution.BaseSolution;
import algorithm.game.move.fundamental.secondsolutionforrobot.MoveBackSecondSolution;
import algorithm.game.move.fundamental.secondsolutionforrobot.MoveForwardSecondSolution;
import algorithm.game.move.fundamental.thirdsolution.MoveBackThirdSolution;
import algorithm.game.move.fundamental.thirdsolution.MoveForwardThirdSolution;

public class ThirdtSolution_GoldenSquare extends BaseSolution {
    public ThirdtSolution_GoldenSquare(Game game) {
        super("Third  SOlution ( Problemmm)");
//        super(game);
    }



    @Override
    public int getLocationInput(Game game) {
        prepareation();

        MathFunctionWithSpecialFeaturesForThirdSolution mathFunctionWithSpecialFeaturesForThirdSolution
                = new MathFunctionWithSpecialFeaturesForThirdSolution(game, playerLocation);

/*
        GraphMemory graphMemory=((Robot)game.getPlayer()).getRobotMemory().getGraphMemory();
        graphMemory.createGraphAccordingToGame();
*/


//        ShowPanel.show(getClass(),"DURRRR");
        return mathFunctionWithSpecialFeaturesForThirdSolution.calculateFunctionResult();
    }

    @Override
    public void buildRobotMove() {
        setMoveForward(new MoveForwardThirdSolution(getGame()));
        setMoveBack(new MoveBackThirdSolution(getGame()));
    }
}
