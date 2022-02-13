package algorithm.game.gamerepo.updategamemodel;


import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.seal.Signature;

public class UpdateForMovedForward extends UpdateValuesInGameModel {

    public UpdateForMovedForward(Game game) {
        super(game);
    }

    @Override
    public void updatePlayerStepValue() {
        game.getPlayer().increaseStep();
    }

    @Override
    Signature ifMovedForwardThenSealTheLocation() {
        return Signature.SEAL;
    }

    @Override
    public void updateValueVisitedDirection(DirectionLocation directionLocation) {
        player.updateVisitedDirection(ifMovedForwardThenSealTheLocation().isSealed(), game.getPlayer().getStep()-1, directionLocation);
    }

}
