package algorithm.game.play;

import algorithm.compass.Compass;
import algorithm.game.Game;
import algorithm.game.location.SwitchDirection;

public class PrepareGame {

    Game game;
    Compass compass;
    SwitchDirection switchDirection;
    SelectFirstSqaureToStart selectFirstSqaureToStart;

    public PrepareGame(Game game) {

        fillNullReferans(game);
        prepareToPlay();

    }

    void fillNullReferans(Game game) {
        this.game = game;

        selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);
        compass = game.getPlayer().getCompass();
    }

    void prepareToPlay() {
        switchDirection = new SwitchDirection(compass);
        selectFirstSqaureToStart.selectSquareStart(0, 0);
        selectFirstSqaureToStart.locateThePlayer();
    }

}
