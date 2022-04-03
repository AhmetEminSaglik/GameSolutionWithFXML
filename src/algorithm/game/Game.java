package algorithm.game;

import algorithm.game.gamerepo.Model;
import algorithm.game.gamerepo.player.Player;

public class Game {
    protected long roundCounter = 0;
    private Model model;
    private Player player;
    protected int overLongRoundCounter = 0;

    public Game(Model model, Player player) {   
        this.model = model;
        this.player = player;
    }

    public Game() {
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {

        this.model = model;
    }

    public Player getPlayer() {
        return player;
    }

    public void resetRoundCounter() {
        roundCounter = 0;
    }

    public void increaseRoundCounter() {
        roundCounter++;
        if (roundCounter == Long.MAX_VALUE) {
            roundCounter = 0;
            overLongRoundCounter++;

        }
    }

    public long getRoundCounter() {
        return roundCounter;
    }

    public int getOverLongRoundCounter() {
        return overLongRoundCounter;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
//    public void printGameAdress(){
//        System.out.println(" ---> "+toString());
//    }

/*    @Override
    public String toString() {
        return "Game{" +
                "roundCounter=" + roundCounter +
                ", model=" + model +
                ", player=" + player +
                ", overLongRoundCounter=" + overLongRoundCounter +
                '}';
    }*/
}
