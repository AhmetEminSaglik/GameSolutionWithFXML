package algorithm.utility;

import algorithm.errormessage.ErrorMessage;

public class ConvertVariable {

    public String intToString(int value) {
        return Integer.toString(value);
    }

    public int StringToInt(String text) {
        try {

            return Integer.parseInt(text);

        } catch (NumberFormatException ex) {
            ErrorMessage.appearClassicError(getClass(), ex.getMessage());
        }
        return -1;

    }
}
