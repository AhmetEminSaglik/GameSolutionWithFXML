package algorithm.game.move;

import algorithm.errormessage.ErrorMessage;
import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.FillGameSquare;
import algorithm.game.gamerepo.updategamemodel.UpdateValuesInGameModel;
import algorithm.compass.Compass;
import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.play.SelectFirstSqaureToStart;
import algorithm.print.EasylyReadNumber;
import algorithm.print.FileWriteProcess;
import algorithm.print.PrintAble;
import algorithm.printarray.StringFormat;
import algorithm.validation.Validation;

import java.io.PrintWriter;


public abstract class Move implements IMove { // ICalculateMove

    public Game game;
    Compass compass;
    Validation validation = new Validation();
    public UpdateValuesInGameModel updateValuesInGameModel;
    private FillGameSquare fillGameSquare;

    DirectionLocation directionLocation;
    int squareEdge;

    public Move(Game game) {
        this.game = game;
        compass = game.getPlayer().getCompass();
        fillGameSquare = new FillGameSquare(game);
        squareEdge = game.getModel().getGameSquares().length;
    }

    @Override
    public boolean isRequiredToChangeStartLocation() {
        if (game.getPlayer().getStep() == 1 && getClass().equals(MoveBack.class)) {
            return true;
        }
        return false;
    }

    public final void move(DirectionLocation directionLocation) {
        prepareAllStuff();

        if (isRequiredToChangeStartLocation()) {

//            game.getPlayer().getPlayerMove().
            changeStartLocationSpecialMovement();
//            System.out.println("AAAAAAAAAAAAAAA");
//            changeStartLocationSpecialMovement();
        } else {
            setLocation(directionLocation);
            updateBeforeStep();
            updatePlayerStepValue();
            updateAfterStep();
            fillGameSquare.printStepInGameSquare();
        }

        if (game.getPlayer().getGameRule().isGameOver(game)) {
            appendFileSquareTotalSolvedValue();
        }
    }

    @Override
    public void updatePlayerStepValue() {
        updateValuesInGameModel.updatePlayerStepValue();
    }

    @Override
    public void changeStartLocationSpecialMovement() {

//        ShowPanel.show(getClass(), "square  total solved value :" + game.getPlayer().getSquareTotalSolvedValue());

        appendFileSquareTotalSolvedValue();
        int locationX = game.getPlayer().getLocation().getX();
        int locationY = game.getPlayer().getLocation().getY();

        locationX++;
        if (locationX >= game.getModel().getGameSquares().length) {
            locationX = 0;
            locationY++;

        }


        if (locationY < game.getModel().getGameSquares().length) {

            try {

                ResetAllDataForGameAndPlayer resetData = new ResetAllDataForGameAndPlayer(game);
                resetData.clearPlayerData(game.getPlayer());
                resetData.clearGameData(game);
                SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);
                selectFirstSqaureToStart.selectSquareStart(locationX, locationY);

                selectFirstSqaureToStart.locateThePlayer();
            } catch (InterruptedException e) {
                ErrorMessage.appearFatalError(getClass(), "OYUN SIFIRLAMASINDA SORUN OLDU : " + e.getMessage());

            }
        } else {

            ShowPanel.show(getClass(), " Y siniri asti ");
        }
    }

    void appendFileSquareTotalSolvedValue() {

        int locationX = game.getPlayer().getLocation().getX();
        int locationY = game.getPlayer().getLocation().getY();
        int squareTotalSolvedValue = game.getPlayer().getSquareTotalSolvedValue();

        String scoreValue = new EasylyReadNumber().getReadableNumberInStringFormat(squareTotalSolvedValue);

//        game.getPlayer().getPrintableFileScore().append(scoreValue);


        String text = "[" + locationX + "]" + "[" + locationY + "] = " + scoreValue + "\n";
        if (locationX == squareEdge - 1) {
            text += "\n";
        }

//        game.getPlayer().getPrintableFileScore().append(text);
        game.getPlayer().resetSquareTotalSolvedValue();

    }


    @Override
    public void prepareAllStuff() {

    }

    @Override
    public void updateVisitedArea() {
//        ShowPanel.show(getClass(),"GELDIIII"+game.getPlayer().getPlayerMove().getMove().getClass().getName());
        updateValuesInGameModel.updateValueVisitedArea();
    }

    @Override
    public void updatePlayerLocation() {
        updateValuesInGameModel.changePlayerLocation(getDirectionLocation());
    }

    public DirectionLocation getDirectionLocation() {
        return directionLocation;
    }

    public void setLocation(DirectionLocation directionLocation) {
        this.directionLocation = directionLocation;
    }

    @Override
    public String toString() {
        return "Move{" + "game=" + game + ", compass=" + compass + ", validation=" + validation + ", updateValuesInGameModel=" + updateValuesInGameModel + ", fillGameSquare=" + fillGameSquare + ", directionLocation=" + directionLocation + '}';
    }

    public FillGameSquare getFillGameSquare() {
        return fillGameSquare;
    }
}
