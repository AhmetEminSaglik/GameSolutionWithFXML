package algorithm.game.move.fundamental;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.updategamemodel.UpdateForMovedForward;
import algorithm.game.move.Move;

public class MoveForward extends Move {


    public MoveForward(Game game) {
        super(game);
        updateValuesInGameModel = new UpdateForMovedForward(game);
    }

    @Override
    public void updateVisitedDirection() {
        game.getPlayer().getScore().lockCounterOfMovingBackLose();
//        System.out.println("geri adim atma kilidi kapatildi");
        updateValuesInGameModel.updateValueVisitedDirection(getDirectionLocation());
    }

    @Override
    public void updateBeforeStep() {

    }

    @Override
    public void updateAfterStep() {
//        System.out.println(" 3 getDirection : " + getDirectionLocation());
        updatePlayerLocation();
        updateVisitedArea();
        updateVisitedDirection();

    }

    @Override
    public String toString() {
        return "MoveForward\n{" +
                ", updateValuesInGameModel=" + updateValuesInGameModel +
                '}';
    }
}
