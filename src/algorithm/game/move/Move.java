package algorithm.game.move;

import algorithm.game.gamerepo.FillGameSquare;
import algorithm.game.gamerepo.updategamemodel.UpdateValuesInGameModel;
import algorithm.compass.Compass;
import algorithm.game.Game;
import algorithm.game.location.DirectionLocation;
import algorithm.print.EasylyReadNumber;


public abstract class Move implements IMove { // ICalculateMove
    ChangePlayerLocation changePlayerLocation;
    public Game game;
    Compass compass;
    protected UpdateValuesInGameModel updateValuesInGameModel;
    private FillGameSquare fillGameSquare;

    private DirectionLocation directionLocation;
    int squareEdge;

    public Move(Game game) {
        this.game = game;
        compass = game.getPlayer().getCompass();
        fillGameSquare = new FillGameSquare(game);
        squareEdge = game.getModel().getGameSquares().length;
    }

    @Override
    public boolean isRequiredToChangeStartLocation() {
        if (/*game.getPlayer().getStep() == 1 && getClass().equals(MoveBack.class) || */game.getPlayer().getStep() == 0) {
            return true;
        }
//        if(game.getPlayer().getStep() == 1 ){
//            ShowPanel.show(getClass()," STEP DEGERI 1 AMA GELEN CLASS : "+getClass());
//        }
        return false;
    }

    public final void move(DirectionLocation directionLocation) {

        setDirectionLocation(directionLocation);
        game.increaseRoundCounter();
        prepareAllStuff();

        if (isRequiredToChangeStartLocation()) {
            changeStartLocation(directionLocation);
        }
        if (game.getPlayer().getStep() > 0) {
        updateBeforeStep();
        }
        updatePlayerStepValue();
        updateAfterStep();
        fillGameSquare.printStepInGameSquare();
    }

    @Override
    public void updatePlayerStepValue() {
        updateValuesInGameModel.updatePlayerStepValue();
    }


//    public void changeStartLocationSpecialMovement(ChangeableStartLocationSpecialMovement changeableStartLocationSpecialMovement) {
//        changeableStartLocationSpecialMovement.changeStartLocation();
/*//        ShowPanel.show(getClass(), "square  total solved value :" + game.getPlayer().getSquareTotalSolvedValue());

//        appendFileSquareTotalSolvedValue();
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
 }  */

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
        updateValuesInGameModel.updateValueVisitedArea();
    }

    @Override
    public void updatePlayerLocation() {
        updateValuesInGameModel.changePlayerLocation(getDirectionLocation());
    }

    public DirectionLocation getDirectionLocation() {
        return directionLocation;
    }

    public void setDirectionLocation(DirectionLocation directionLocation) {
        this.directionLocation = directionLocation;
    }

    public FillGameSquare getFillGameSquare() {
        return fillGameSquare;
    }

    public ChangePlayerLocation getChangePlayerLocation() {
        return changePlayerLocation;
    }

    public void setChangePlayerLocation(ChangePlayerLocation changePlayerLocation) {
        this.changePlayerLocation = changePlayerLocation;
        updateValuesInGameModel.setChangePlayerLocation(changePlayerLocation);
    }

    public UpdateValuesInGameModel getUpdateValuesInGameModel() {
        return updateValuesInGameModel;
    }

    public void setUpdateValuesInGameModel(UpdateValuesInGameModel updateValuesInGameModel) {
        this.updateValuesInGameModel = updateValuesInGameModel;
    }

    @Override
    public String toString() {
        return "Move{" +
                "updateValuesInGameModel=" + updateValuesInGameModel +
                '}';
    }
}
