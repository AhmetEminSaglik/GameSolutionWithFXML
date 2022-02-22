package algorithm.game.gamerepo.player.robot.solution;

import algorithm.errormessage.joptionpanel.ShowPanel;
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
//        System.out.println(" prepare ONCE robot cozumu : "+robot.getSolution().getMoveForward().getClass().getName());
//        System.out.println(" prepare ONCE robot cozumu : "+robot.getSolution().getMoveBack().getClass().getSimpleName());
//        prepareGameBySelectingMenu.getPlayer().setGame(prepareGameBySelectingMenu.getGame());
//        Robot robot=(Robot) prepareGameBySelectingMenu.getPlayer();
//        MoveForward moveForward = robot.getSolution().getMoveForward();
//        MoveBack moveBack = robot.getSolution().getMoveBack();
        robot.getSolution().setGame(prepareGameBySelectingMenu.getGame());
        robot.getSolution().buildRobotMove();
        MoveForward moveForward = robot.getSolution().getMoveForward();
        MoveBack moveBack = robot.getSolution().getMoveBack();
        prepareGameBySelectingMenu.getPlayer().setPlayerMove(new PlayerMove(moveForward, moveBack));
//        ShowPanel.show(getClass(), " player move : ???? \n " + prepareGameBySelectingMenu.getPlayer().getPlayerMove().toString());
//        ShowPanel.show(getClass()," DURR incele ");
//        Robot robot = (Robot) prepareGameBySelectingMenu.getPlayer();
//        robot.getSolution().setGame(prepareGameBySelectingMenu.getGame());


//        robot.setPlayerMove(new PlayerMove(robot.getSolution().getMoveForward(), robot.getSolution().getMoveBack()));
//        System.out.println("  --------------------------    >>>>>>>>>>>>>>>>>>>> prepare SONRA robot cozumu : " + robot.getSolution().getMoveForward());
//        System.out.println("  --------------------------    >>>>>>>>>>>>>>>>>>>>   prepare SONRA robot cozumu : " + robot.getSolution().getMoveBack());
    }

    /*  @Override
    public void prepare() {
        super.prepare();
//        Robot robot = (Robot) prepareGameBySelectingMenu.getPlayer();
//        robot.setPlayerMove(new PlayerMove(robot.getSolution().getMoveForward(), robot.getSolution().getMoveBack()));



    }*/
}
