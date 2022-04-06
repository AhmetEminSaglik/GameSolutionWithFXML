package algorithm.validation;

import algorithm.errormessage.ErrorMessage;
import algorithm.game.Game;

public class SquareValidationGame {

    int horizontalSquares;
    int verticalSquares;

    public SquareValidationGame(int verticalSquares, int horizontalSquares) throws Exception {

        if (new Validation().validateSquareNumbers(verticalSquares) && new Validation().validateSquareNumbers(horizontalSquares)) {
            this.verticalSquares = verticalSquares;
            this.horizontalSquares = horizontalSquares;
        } else {
            String message = "For both squares must be bigger than 4";
            new ErrorMessage().throwError(getClass(), message);
        }

    }

}
