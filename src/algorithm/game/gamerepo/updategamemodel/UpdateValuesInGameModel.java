package algorithm.game.gamerepo.updategamemodel;


import algorithm.game.Game;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.Location;
import algorithm.game.move.MovePlayer;
import algorithm.game.move.seal.SealationOfLocation;
import algorithm.game.move.seal.Signature;

public abstract class UpdateValuesInGameModel {

    Game game;
    Player player;
    MovePlayer movePlayer;

    public UpdateValuesInGameModel(Game game) {
        this.game = game;

        player = game.getPlayer();
        movePlayer = new MovePlayer(player);
    }

    public abstract void updatePlayerStepValue();

    public final void changePlayerLocation(Location location) {
        movePlayer.changePlayerLocationByAdding(location);
    }


    abstract Signature ifMovedForwardThenSealTheLocation();

    public final void updateValueVisitedArea() {
        new SealationOfLocation(game).updateLocationCondition(game.getModel().getVisitedAreas(), ifMovedForwardThenSealTheLocation());

    }
      public abstract void updateValueVisitedDirection(DirectionLocation directionLocation);

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
