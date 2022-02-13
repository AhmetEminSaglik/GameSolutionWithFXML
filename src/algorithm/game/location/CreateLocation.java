package algorithm.game.location;


import algorithm.errormessage.ErrorMessage;

public class CreateLocation extends DirectionLocation {

    @Override
    public int getId() {
        ErrorMessage.appearClassicError(getClass(),"Undefined value");
        return -1;
    }

}
