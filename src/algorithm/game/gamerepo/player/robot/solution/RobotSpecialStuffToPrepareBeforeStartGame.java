package algorithm.game.gamerepo.player.robot.solution;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.player.PlayerSpecialStuffToPrepareBeforeStartGame;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.play.PlayerMove;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;

public class RobotSpecialStuffToPrepareBeforeStartGame extends PlayerSpecialStuffToPrepareBeforeStartGame {

    public RobotSpecialStuffToPrepareBeforeStartGame(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
    }

    @Override
    public void prepare() {

        Robot robot=(Robot) prepareGameBySelectingMenu.getPlayer();
//        System.out.println(" prepare ONCE robot cozumu : "+robot.getSolution().getMoveForward().getClass().getName());
//        System.out.println(" prepare ONCE robot cozumu : "+robot.getSolution().getMoveBack().getClass().getSimpleName());
        super.prepare();
//        prepareGameBySelectingMenu.getPlayer().setGame(prepareGameBySelectingMenu.getGame());
//        Robot robot=(Robot) prepareGameBySelectingMenu.getPlayer();
        System.out.println("  --------------------------    >>>>>>>>>>>>>>>>>>>> prepare SONRA robot cozumu : "+robot.getSolution().getMoveForward());
        System.out.println("  --------------------------    >>>>>>>>>>>>>>>>>>>>   prepare SONRA robot cozumu : "+robot.getSolution().getMoveBack());
//        ShowPanel.show(getClass()," DURR incele ");
//        Robot robot = (Robot) prepareGameBySelectingMenu.getPlayer();
//        robot.getSolution().setGame(prepareGameBySelectingMenu.getGame());


//        robot.setPlayerMove(new PlayerMove(robot.getSolution().getMoveForward(), robot.getSolution().getMoveBack()));
    }

    /*  @Override
    public void prepare() {
        super.prepare();
//        Robot robot = (Robot) prepareGameBySelectingMenu.getPlayer();
//        robot.setPlayerMove(new PlayerMove(robot.getSolution().getMoveForward(), robot.getSolution().getMoveBack()));



    }*/
}
