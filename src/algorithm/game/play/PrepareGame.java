package algorithm.game.play;

import algorithm.compass.Compass;
import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.location.SwitchDirection;

public class PrepareGame {

    Game game;
//    Compass compass;
//    SwitchDirection switchDirection;
    SelectFirstSqaureToStart selectFirstSqaureToStart;

    public PrepareGame(Game game) {

        fillNullReferans(game);
//        prepareToPlay();

    }

    void fillNullReferans(Game game) {
        this.game = game;

        selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);
//        compass = game.getPlayer().getCompass();
    }

    void prepareToPlay() {
//        switchDirection = new SwitchDirection(compass);
        selectFirstSqaureToStart.selectSquareStart(0, 0);
//        selectFirstSqaureToStart.selectSquareStart(game.getPlayer().getInput(game),game.getPlayer().getInput(game));
//        ShowPanel.show(getClass(),"Burada nereden baslancagi hesaplaniyor. Bu kadar yeter simdilik");
        selectFirstSqaureToStart.locateThePlayer();
    }

}
