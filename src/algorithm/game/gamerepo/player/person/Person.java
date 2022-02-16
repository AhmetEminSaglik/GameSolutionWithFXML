package algorithm.game.gamerepo.player.person;


import algorithm.compass.Compass;
import algorithm.compass.KeyboardCompass;
import algorithm.game.Game;
import algorithm.game.gameover.PersonGameOver;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.move.fundamental.MoveForward;
import algorithm.game.play.PlayerMove;
import algorithm.game.play.input.person.IPlayerInput;
import algorithm.game.play.input.person.PersonInput;
import algorithm.game.rule.BaseGameRule;

public class Person extends Player {

    public Person() {
//        super(game);
        printAbleEveryStep = true;
//        playerMove = new PlayerMove(/*new PersonMove(game),*/new MoveForward(game), new MoveBack(game));
    }

    @Override
    public void setGame(Game game) {
        super.setGame(game);
        setPlayerMove();
    }

    @Override
    public void setPlayerMove() {
        playerMove = new PlayerMove(/*new PersonMove(game),*/new MoveForward(game), new MoveBack(game));
    }

    @Override
    public Compass getCompass() {
        return new KeyboardCompass();
    }

//    @Override
//    public int getInput(Game game) {
//        return new PersonInput(game).getInput();
//    }

    @Override
    public BaseGameRule getGameRule() {
        if (gameRule == null) {
            gameRule = new BaseGameRule(new PersonGameOver());
        }
        return gameRule;
    }

    public PlayerMove getPlayerMove() {
        return playerMove;
    }

    @Override
    public boolean isPrintableStepSituation() {
        return printAbleEveryStep;
    }

/*    @Override
    public String toString() {
        return "Person{" +
                "playerMove=" + playerMove +
                ", name='" + name + '\'' +
                ", printableFileScore=" + printableFileScore +
                ", printAbleEveryStep=" + printAbleEveryStep +
                ", squareTotalSolvedValue=" + squareTotalSolvedValue +
                ", game=" + game +
                ", gameRule=" + gameRule +
                '}';
    }*/
}
