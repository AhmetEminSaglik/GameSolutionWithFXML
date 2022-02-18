package algorithm.game.play;

import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.move.ChangePlayerLocation;
import algorithm.game.move.fundamental.MoveForward;

import java.util.Random;

public class SelectFirstSqaureToStart extends DirectionLocation {

    private Game game;
    ChangePlayerLocation movePlayer;

    public SelectFirstSqaureToStart(Game game) {
        this.game = game;
        movePlayer = new ChangeLocationByExactlyLocation(game.getPlayer());
    }

    public void randomStart() {
        fillCordinates(new Random().nextInt(game.getModel().getGameSquares().length),
                new Random().nextInt(game.getModel().getGameSquares()[0].length));
    }

    public void selectSquareStart(int x, int y) {
        fillCordinates(x, y);
    }

    void fillCordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public int getId() {
        return -1;
    }

    @Override
    public String toString() {
        return "SelectFirstSqaureToStart{ X : " + getX() + " Y " + getY() + " }";
    }

    public void locateThePlayer() {
        MoveForward moveForward = game.getPlayer().getPlayerMove().getMoveForward();//new MoveForward(game);
        moveForward.updatePlayerStepValue();

        movePlayer.change(this);

        moveForward.updateVisitedArea();
        moveForward.getFillGameSquare().printStepInGameSquare();
    }
}
