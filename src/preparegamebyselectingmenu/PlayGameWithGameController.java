package preparegamebyselectingmenu;

import algorithm.game.play.PlayGame;

public class PlayGameWithGameController {
    PrepareGameBySelectingMenu prepareGameBySelectingMenu;

    public PlayGameWithGameController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
        PlayGame playGame = new PlayGame(prepareGameBySelectingMenu.getGame());
        playGame.playGame();
    }

}
