package algorithm.game.gamerepo;


import algorithm.game.Game;
import algorithm.game.gamerepo.player.Player;

public class FillGameSquare {

    Game game;
    Player player;

    public FillGameSquare(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    public void printStepInGameSquare() {
        System.out.println("gelen deger x : "+player.getLocation().getX()+" y " +player.getLocation().getY());
        game.getModel().getGameSquares()[player.getLocation().getX()][player.getLocation().getY()] = player.getStep();
    }

}
