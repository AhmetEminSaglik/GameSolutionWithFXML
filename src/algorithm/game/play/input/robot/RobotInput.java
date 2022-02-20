package algorithm.game.play.input.robot;

import algorithm.game.Game;
import algorithm.game.gamerepo.player.robot.solution.BaseSolution;
import algorithm.game.play.input.person.IPlayerInput;

public class RobotInput /*extends BaseControlInput*/ implements IPlayerInput {

    BaseSolution solution;

    public RobotInput(BaseSolution solution/*, Game game*/) {
//        super(game);
        this.solution = solution;
    }

    @Override
    public int getInput(Game game) {
        return solution.getLocationInput(game);
    }

/*    @Override
    public boolean isInputSuitableToMoveForward(Game game, int choose) {
        ErrorMessage.appearFatalError(getClass(), "BURAYA GELDIIII /  burasi kullanilmiyor");
        return false;
    }

    @Override
    public boolean isInputSuitableToMoveBack(Game game, int choose) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}
