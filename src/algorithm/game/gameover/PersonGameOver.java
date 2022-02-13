package algorithm.game.gameover;


import algorithm.check.CheckAroundSquare;
import algorithm.game.Game;

public class PersonGameOver implements IGameOver {

    @Override
    public boolean isGameOver(Game game) {
        if (new CheckAroundSquare(game).isThereAnyAvailableSquare()) {

            return false;
        }
         return true;
    }

}
