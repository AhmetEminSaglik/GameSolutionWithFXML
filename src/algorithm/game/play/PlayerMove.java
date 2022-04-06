package algorithm.game.play;

import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.move.fundamental.MoveForward;

public class PlayerMove {
    private MoveForward moveForward;
    private MoveBack moveBack;

    public PlayerMove(MoveForward moveForward, MoveBack moveBack) {
        this.moveForward = moveForward;
        this.moveBack = moveBack;
    }

    public MoveForward getMoveForward() {
        return moveForward;
    }


    public MoveBack getMoveBack() {
        return moveBack;
    }

    @Override
    public String toString() {
        return "PlayerMove{" +
                "moveForward=" + moveForward +
                ", moveBack=" + moveBack +
                '}';
    }

    public void setMoveForward(MoveForward moveForward) {
        this.moveForward = moveForward;
    }

    public void setMoveBack(MoveBack moveBack) {
        this.moveBack = moveBack;
    }
}
