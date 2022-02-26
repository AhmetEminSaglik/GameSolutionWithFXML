package algorithm.game.gamerepo;


import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.location.CreateLocation;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.direction.LastLocation;

public class CreateLocationOfLastStep {

    Game game;

    public CreateLocationOfLastStep(Game game) {
        this.game = game;
    }

    public DirectionLocation createLastStepLocation() {
        GameModelProcess gameModelProcess = new GameModelProcess(game);
        gameModelProcess.calculateIndexOfGivenStepInGameSquareArrays(game.getPlayer().getStep() - 1);

        CreateLocation createLocation = new CreateLocation();
        createLocation.setX(getOppositeValue(game.getPlayer().getLocation().getX(), gameModelProcess.getX()));
        createLocation.setY(getOppositeValue(game.getPlayer().getLocation().getY(), gameModelProcess.getY()));
//        ShowPanel.show(getClass()," GERI DONUS ILCIN OLUSTURULAN LOCASYON : "+createLocation.toString());
        return createLocation;
       /* LastLocation lastLocation = new LastLocation();
        lastLocation.setCompass(game.getPlayer().getCompass());

        lastLocation.setX(getOppositeValue(game.getPlayer().getLocation().getX(), gameModelProcess.getX()));
        lastLocation.setY(getOppositeValue(game.getPlayer().getLocation().getY(), gameModelProcess.getY()));
        ShowPanel.show(getClass(), "\nOpozite deger alirken\nplayer konumu : " + game.getPlayer().getLocation().toString()
                + "\ngamemodel x " + gameModelProcess.getX() + " " + gameModelProcess.getY() +
                "\nopozite degeri : " + lastLocation.toString());
        return lastLocation;
*/
    }

    int getOppositeValue(int a, int b) {
        return -(a - b);

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
