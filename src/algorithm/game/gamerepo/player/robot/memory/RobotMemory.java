package algorithm.game.gamerepo.player.robot.memory;

import algorithm.game.Game;

public class RobotMemory {
    Game game;

    private RoadMemory roadMemory = new RoadMemory();

    public RobotMemory(Game game) {
        this.game = game;
    }

    public RoadMemory getRoadMemory() {
        return roadMemory;
    }
}
