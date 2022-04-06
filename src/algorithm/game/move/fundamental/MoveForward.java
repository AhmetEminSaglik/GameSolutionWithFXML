package algorithm.game.move.fundamental;

import algorithm.game.Game;
import algorithm.game.gamerepo.updategamemodel.UpdateForMovedForward;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.Move;

public class MoveForward extends Move {


    public MoveForward(Game game) {
        super(game);
        updateValuesInGameModel = new UpdateForMovedForward(game);
    }

    @Override
    public void updateVisitedDirection() {
        game.getPlayer().getScore().lockCounterOfMovingBackLose();
        updateValuesInGameModel.updateValueVisitedDirection(getDirectionLocation());
    }

    @Override
    public void updateBeforeStep() {

    }

    @Override
    public void updateAfterStep() {
        updatePlayerLocation();
        updateVisitedArea();
        updateVisitedDirection();

    }

    @Override
    public void changeStartLocation(DirectionLocation directionLocation) {

    }

    @Override
    public String toString() {
        return "MoveForward\n{" +
                ", updateValuesInGameModel=" + updateValuesInGameModel +
                '}';
    }
}
