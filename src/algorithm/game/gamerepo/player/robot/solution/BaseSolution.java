package algorithm.game.gamerepo.player.robot.solution;

import algorithm.check.CheckSquare;
import algorithm.game.Game;
import algorithm.game.location.Location;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.move.fundamental.MoveForward;
import algorithm.squareprocess.SquareProcess;

public abstract class BaseSolution {
    private Game game;
    private String name;
    public Location playerLocation;

    public BaseSolution(String name) {
        this.name = name;
    }

    private MoveForward moveForward;
    private MoveBack moveBack;
    public CheckSquare checkSquare = new CheckSquare();
    public SquareProcess squareProcess = new SquareProcess();

    public void prepareation() {
        playerLocation = checkSquare.getPlayerLocation(getGame());
    }

    public abstract int getLocationInput(Game game);

    public MoveForward getMoveForward() {
        return moveForward;
    }

    public void setMoveForward(MoveForward moveForward) {
        this.moveForward = moveForward;
    }

    public MoveBack getMoveBack() {
        return moveBack;
    }

    public void setMoveBack(MoveBack moveBack) {
        this.moveBack = moveBack;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public abstract void buildRobotMove();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseSolution{" +
                ", moveForward=" + moveForward +
                ", moveBack=" + moveBack +
                '}';
    }
}
