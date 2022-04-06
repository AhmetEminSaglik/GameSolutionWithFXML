package algorithm.game.move;

import algorithm.game.gamerepo.player.Player;
import algorithm.game.move.seal.ChangeableStartLocationSpecialMovement;
import algorithm.game.play.SelectFirstSqaureToStart;
import scene.game.SquareButton;

public class PersonChangeLocationMove implements ChangeableStartLocationSpecialMovement {
    Player player;
    SquareButton selectSquareBtnAsStartLocation;

    public PersonChangeLocationMove(Player player, SquareButton selectSquareBtnAsStartLocation) {
        this.player = player;
        this.selectSquareBtnAsStartLocation = selectSquareBtnAsStartLocation;
    }

    @Override
    public void changeStartLocation() {
        locatePlayerFirstLocation(selectSquareBtnAsStartLocation.getX(),selectSquareBtnAsStartLocation.getY());

    }

    public SquareButton getSelectSquareBtnAsStartLocation() {
        return selectSquareBtnAsStartLocation;
    }

    public void setSelectSquareBtnAsStartLocation(SquareButton selectSquareBtnAsStartLocation) {
        this.selectSquareBtnAsStartLocation = selectSquareBtnAsStartLocation;
    }
    void locatePlayerFirstLocation(int x, int y) {
        SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(player.getGame());
        selectFirstSqaureToStart.selectSquareStart(x, y);
        selectFirstSqaureToStart.locateThePlayer();
    }
}
