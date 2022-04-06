package algorithm.game.gamerepo.player.robot.solution;

import algorithm.game.gamerepo.player.PlayerSpecialStuffToPrepareBeforeStartGame;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.move.fundamental.MoveForward;
import algorithm.game.play.PlayerMove;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;

public class RobotSpecialStuffToPrepareBeforeStartGame extends PlayerSpecialStuffToPrepareBeforeStartGame {

    public RobotSpecialStuffToPrepareBeforeStartGame(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
    }

    @Override
    public void prepare() {
        super.prepare();

        Robot robot = (Robot) prepareGameBySelectingMenu.getPlayer();
        robot.getSolution().setGame(prepareGameBySelectingMenu.getGame());
        robot.getSolution().buildRobotMove();
        MoveForward moveForward = robot.getSolution().getMoveForward();
        MoveBack moveBack = robot.getSolution().getMoveBack();
        prepareGameBySelectingMenu.getPlayer().setPlayerMove(new PlayerMove(moveForward, moveBack));
    }

}
