package algorithm.game.play;

import algorithm.game.Game;

public class PrepareGame {

    Game game;
//    Compass compass;
//    SwitchDirection switchDirection;
    SelectFirstSqaureToStart selectFirstSqaureToStart;

    public PrepareGame(Game game) {
        fillNullReferans(game);
    }

    void fillNullReferans(Game game) {
        this.game = game;

        selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);
//        compass = game.getPlayer().getCompass();
    }

    public void prepareToPlay(int x, int y) {
//        switchDirection = new SwitchDirection(compass);
        selectFirstSqaureToStart.selectSquareStart(x, y);
//        selectFirstSqaureToStart.selectSquareStart(game.getPlayer().getInput(game),game.getPlayer().getInput(game));
//        ShowPanel.show(getClass(),"Burada nereden baslancagi hesaplaniyor. Bu kadar yeter simdilik");
        selectFirstSqaureToStart.locateThePlayer();
    }

}
