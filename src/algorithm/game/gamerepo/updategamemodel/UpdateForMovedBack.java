package algorithm.game.gamerepo.updategamemodel;

import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.seal.Signature;
import algorithm.validation.Validation;


public class UpdateForMovedBack extends UpdateValuesInGameModel {

    public UpdateForMovedBack(Game game) {
        super(game);
    }

    @Override
    public void updatePlayerStepValue() {
        game.getPlayer().decreaseStep();
    }

    @Override
    Signature ifMovedForwardThenSealTheLocation() {
        return Signature.UNSEAL;
    }

    @Override
    public void updateValueVisitedDirection(DirectionLocation directionLocation) {
        int step = player.getStep();
        if (new Validation().isStepValueAvailable(game, step)) {
            player.updateVisitedDirection(ifMovedForwardThenSealTheLocation().isSealed(), step, directionLocation);
        }
    }

    @Override
    public String toString() {
        return "UpdateForMovedBack{}";
    }
}
