package algorithm.sleep;

import algorithm.errormessage.ErrorMessage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Sleep {

    public void sleep() {

        try {
            showWarningMessage();
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sleep(int time) {
        try {
            showWarningMessage();
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    void showWarningMessage() {
        ErrorMessage.appearWarnings(getClass(), " 404 ");
    }

}
