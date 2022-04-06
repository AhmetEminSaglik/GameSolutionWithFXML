package algorithm.errormessage.joptionpanel;

import javax.swing.*;

public class ShowPanel {
    public static void show(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void show(Class className, String message) {
        JOptionPane.showMessageDialog(null, className.getName() + " > " + message);
    }
}
