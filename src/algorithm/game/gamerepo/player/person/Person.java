package algorithm.game.gamerepo.player.person;

import algorithm.compass.Compass;
import algorithm.compass.KeyboardCompass;
import algorithm.game.Game;
import algorithm.game.gameover.PersonGameOver;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.play.PlayerMove;
import algorithm.game.rule.BaseGameRule;

public class Person extends Player {

    public Person() {
        printAbleEveryStep = true;
        setName("Person");
    }

    @Override
    public void setGame(Game game) {
        super.setGame(game);
    }

    @Override
    public void setPlayerMove(PlayerMove playerMove) {
        this.playerMove = playerMove;
    }

    @Override
    public Compass getCompass() {
        return new KeyboardCompass();
    }

    @Override
    public BaseGameRule getGameRule() {
        if (gameRule == null) {
            gameRule = new BaseGameRule(new PersonGameOver());
        }
        return gameRule;
    }

    public PlayerMove getPlayerMove() {
        return playerMove;
    }

    @Override
    public boolean isPrintableStepSituation() {
        return printAbleEveryStep;
    }

}
