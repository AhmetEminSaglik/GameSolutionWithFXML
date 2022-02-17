package algorithm.game.gamerepo.player;

import preparegamebyselectingmenu.PrepareGameBySelectingMenu;

public abstract class PlayerSpecialStuffToPrepareBeforeStartGame {
    protected PrepareGameBySelectingMenu prepareGameBySelectingMenu;

    public PlayerSpecialStuffToPrepareBeforeStartGame(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
    }

    public void prepare() {
        prepareGameBySelectingMenu.prepareGame();
    }

}
