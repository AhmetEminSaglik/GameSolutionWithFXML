package algorithm.game.rule;

import algorithm.game.Game;
import algorithm.game.gameover.IGameOver;

public class BaseGameRule implements IGameOver {

    IGameOver gameOver;

    public BaseGameRule(IGameOver gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public boolean isGameOver(Game game) {
        return gameOver.isGameOver(game);
    }

}
