package algorithm.game.move;

import algorithm.errormessage.ErrorMessage;
import algorithm.game.Game;
import algorithm.game.move.seal.ChangeableStartLocationSpecialMovement;
import algorithm.game.play.SelectFirstSqaureToStart;

public class RobotChangeLocationMove implements ChangeableStartLocationSpecialMovement {
    Game game;

    public RobotChangeLocationMove(Game game) {
        this.game = game;
    }

    @Override
    public void changeStartLocation() {
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
        }


    }
 /*   public RobotChangeLocationMove(Game game) {
        super(game);
    }*/
/*
    @Override
    public void updateVisitedDirection() {

    }

    @Override
    public void updateBeforeStep() {

    }

    @Override
    public void updateAfterStep() {

    }

    @Override
    public void changeStartLocation(DirectionLocation directionLocation) {
        ShowPanel.show(getClass(), "GELDIIIIIIIIIIIIIIIIII  DOLUUU");
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

    }*/
}
