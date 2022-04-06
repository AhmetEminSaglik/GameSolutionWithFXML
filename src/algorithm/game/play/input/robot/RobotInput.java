package algorithm.game.play.input.robot;

import algorithm.game.Game;
import algorithm.game.gamerepo.player.robot.solution.BaseSolution;
import algorithm.game.play.input.person.IPlayerInput;

public class RobotInput  implements IPlayerInput {

    BaseSolution solution;

    public RobotInput(BaseSolution solution) {
        this.solution = solution;
    }

    @Override
    public int getInput(Game game) {
        return solution.getLocationInput(game);
    }


}
