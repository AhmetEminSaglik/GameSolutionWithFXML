package algorithm.game.play.input.person;

import algorithm.check.CheckSquare;
import algorithm.compass.Compass;
import algorithm.compass.KeyboardCompass;
import algorithm.errormessage.ErrorMessage;
import algorithm.game.Game;
import algorithm.game.location.Location;
import algorithm.validation.Validation;


public class PersonInput /*extends BaseControlInput*/ implements IPlayerInput {

    CheckSquare checkSquare = new CheckSquare();
    private InputWayOfPersonInput inputWayOfPersonInput;

    public PersonInput(InputWayOfPersonInput inputWayOfPersonInput) {
        this.inputWayOfPersonInput = inputWayOfPersonInput;
    }


    @Override
    public int getInput(Game game) {
        int choose = inputWayOfPersonInput.getInput();
        if (isMoveableDirectionInput(game, choose)) {
            return choose;
        } else {

            ErrorMessage.appearClassicError(getClass(), "You can not  go that direction, please choose another direction\n" +
                    "chose : " + choose + "\n" +
                    "checkSquare.getCompass().getNorth() " + checkSquare.getCompass().getNorth());
        }
        return -1;
    }

    public boolean isInputSuitableToMoveForward(Game game, int choose) {
        return checkInputForForward(game, choose);
    }

    boolean checkInputForForward(Game game, int choose) {
        Validation validation = new Validation();
        Compass compass = new KeyboardCompass();

        validation.setCompass(compass);

        checkSquare.setCompass(compass);

        if (validation.isInputValidForArray(game, game.getPlayer().getLocation(), choose)
                && checkSquare.isSquareFreeFromVisitedArea(game, getLocationToCheck(game), choose)) {
            return true;
        }
        return false;
    }

    Location getLocationToCheck(Game game) {
        return checkSquare.getPlayerLocation(game);
    }

    public boolean isInputSuitableToMoveBack(Game game, int choose) {
        return checkInputForBack(game, choose);
    }

    boolean checkInputForBack(Game game, int choose) {
        if (choose == new KeyboardCompass().getLastLocation() && game.getPlayer().getStep() > 1) {
            return true;
        }
        return false;
    }

    public boolean isMoveableDirectionInput(Game game, int choose) {
        if (isInputSuitableToMoveForward(game, choose) || isInputSuitableToMoveBack(game, choose)) {
            return true;
        }
        return false;
    }

    public InputWayOfPersonInput getInputWayOfPersonInput() {
        return inputWayOfPersonInput;
    }

    public void setInputWayOfPersonInput(InputWayOfPersonInput inputWayOfPersonInput) {
        this.inputWayOfPersonInput = inputWayOfPersonInput;
    }
}
