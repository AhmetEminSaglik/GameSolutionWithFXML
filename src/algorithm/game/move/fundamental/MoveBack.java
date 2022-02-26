package algorithm.game.move.fundamental;

import algorithm.errormessage.ErrorMessage;
import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.GameModelProcess;
import algorithm.game.gamerepo.updategamemodel.UpdateForMovedBack;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.move.Move;
import algorithm.game.move.ResetAllDataForGameAndPlayer;
import algorithm.game.play.SelectFirstSqaureToStart;

import java.util.ArrayList;

public class MoveBack extends Move {

    public MoveBack(Game game) {
        super(game);
        updateValuesInGameModel = new UpdateForMovedBack(game);
    }

    @Override
    public void updateVisitedDirection() {
        if (game.getPlayer().getStep() == 100) {
            game.getPlayer().getScore().unlockCounterOfMovingBackLose();
            System.out.println("geri adim atma kilidi acildi");
        }
        if (game.getPlayer().getScore().isLockedCounterOfMovingBackLose() == true) {
//            printGamelastStuation(game);
//            ShowPanel.show(getClass(),"KITLI OLDUGU HALDE GERI ADIM ATTI   Step : "+game.getPlayer().getStep());
            game.getPlayer().getScore().increaseCounterOfMovingBackLose();
            game.getPlayer().getScore().unlockCounterOfMovingBackLose();

        }
        /* Ozel RoundCounter : geri adim atmaya baslandiktan sonra, eger ileri adim atilirsa  ve oyun bitmeden tekrardan geri adim atilmaya baslanirsa o zaman bu deger
        artmaya baslayacak. Amac Cozum bulamadan atilan geri adim sayisini hesaplayip verim oranini bulmak
        * */
    /*    if (game.getPlayer().getScore().getCounterOfMovingBackLose() > 0)
            ShowPanel.show(getClass(), "Geri adim atilacak tikanmayi incele step : " + game.getPlayer().getStep());
        printGamelastStuation(game);*/
        clearAllDirectionBeforeGoBack();
    }

    void clearAllDirectionBeforeGoBack() {
        ArrayList<DirectionLocation> directionLocationList = new LocationsList().getListOfLocationsAccordingToPlayerCompass(game.getPlayer().getCompass());

        for (int i = 0; i < directionLocationList.size(); i++) {
//            ShowPanel.show(getClass()," geri adim icin isleme sokulacak direction : "+directionLocationList.get(i).toString());
            updateValuesInGameModel.updateValueVisitedDirection(directionLocationList.get(i));
        }
    }

    @Override
    public void updateBeforeStep() {

//        ShowPanel.show(getClass()," Move Back udpateBefore Step");
        updateVisitedArea();
        updateVisitedDirection();
        removeMaxStepBeforeGoingLastStep();
    }

    @Override
    public void updateAfterStep() {
        updatePlayerLocation();
    }

    @Override
    public void changeStartLocation(DirectionLocation directionLocation) {
        ShowPanel.show(getClass()," Start Location Degisecek KOD YAZILMADI BOSSSSSSSSSSSSSSSSSSSSS");

/*

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
        System.out.println("hesapnan location : " + locationX + "-" + locationY);
        directionLocation.setX(locationX);
        directionLocation.setY(locationY);

        SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);
        selectFirstSqaureToStart.selectSquareStart(locationX, locationY);

*/


//        MoveForward moveForward= game.getPlayer().getPlayerMove().getMoveForward();
//        moveForward.move(directionLocation);
//        ShowPanel.show(getClass()," GELEN DIRECTION ?? AMA ISE YAIRCAK MI ? "+directionLocation+"  step : "+game.getPlayer().getStep()+"\n player location : "+game.getPlayer().getLocation());
    }

    void removeMaxStepBeforeGoingLastStep() {
        new GameModelProcess(game).deleteMaxStep(game.getPlayer().getStep());
    }

    /*void printGamelastStuation(Game game) {

        String textWillAppendToFile = " Finished totalGame : " + game.getPlayer().getScore().getTotalGameFinishedScore() + "\n";
        textWillAppendToFile += "RoundCounter : " + game.getRoundCounter() + '\n' + "" +
                "Counter of moving back " +game.getPlayer().getScore().getCounterOfMovingBackLose()+"\n"+
                "Step : " + game.getPlayer().getStep() + "\n";


        textWillAppendToFile += new StringFormat().getStringFormatArray(game.getModel().getGameSquares());//  print game squares
        System.out.println(textWillAppendToFile);
        System.out.println();
//        printToFile(textWillAppendToFile);
    }*/

    @Override
    public String toString() {
        return "MoveBack\n{" +
                ", updateValuesInGameModel=" + updateValuesInGameModel +
                '}';
    }
}
