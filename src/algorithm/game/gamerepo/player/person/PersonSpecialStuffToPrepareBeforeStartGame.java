package algorithm.game.gamerepo.player.person;

import algorithm.game.gamerepo.player.PlayerSpecialStuffToPrepareBeforeStartGame;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.move.fundamental.MoveForward;
import algorithm.game.play.PlayerMove;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;


public class PersonSpecialStuffToPrepareBeforeStartGame extends PlayerSpecialStuffToPrepareBeforeStartGame {
    public PersonSpecialStuffToPrepareBeforeStartGame(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
    }

    @Override
    public void prepare() {
        super.prepare();
        MoveForward moveForward = new MoveForward(prepareGameBySelectingMenu.getGame());
        MoveBack moveBack = new MoveBack(prepareGameBySelectingMenu.getGame());

        prepareGameBySelectingMenu.getPlayer().setPlayerMove(new PlayerMove(moveForward, moveBack));
    }
}
