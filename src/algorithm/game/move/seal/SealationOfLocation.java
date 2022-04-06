package algorithm.game.move.seal;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.Player;

public class SealationOfLocation implements UpdateableLocation {
    Game game;
    Player player;

    public SealationOfLocation(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    @Override
    public void updateLocationCondition(boolean[][] area, Signature signature) {
        try {
            area[game.getPlayer().getLocation().getX()][game.getPlayer().getLocation().getY()] = signature.isSealed();

        } catch (ArrayIndexOutOfBoundsException ex) {
            ShowPanel.show(/*getClass(),*/ ex.getMessage()+" --> "+getClass().getName()+"\n game.getPlayer().getLocation().getX(): "+game.getPlayer().getLocation().getX()+"\n" +
                    "game.getPlayer().getLocation().getY()"+game.getPlayer().getLocation().getY()+" step :"+game.getPlayer().getStep());
            ex.printStackTrace();
        }

    }
}
