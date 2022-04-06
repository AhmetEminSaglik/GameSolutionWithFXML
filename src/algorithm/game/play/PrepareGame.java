package algorithm.game.play;

import algorithm.game.Game;

public class PrepareGame {

    Game game;
    SelectFirstSqaureToStart selectFirstSqaureToStart;

    public PrepareGame(Game game) {
        fillNullReferans(game);
    }

    void fillNullReferans(Game game) {
        this.game = game;

        selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);
    }

    public void prepareToPlay(int x, int y) {
        selectFirstSqaureToStart.selectSquareStart(x, y);
        selectFirstSqaureToStart.locateThePlayer();
    }

}
