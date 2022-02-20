package algorithm.printarray;

import algorithm.utility.ConvertVariable;

public class StringFormat {

    public String getStringFormatArray(int array[][]) {
        String text = "";
        for (int j = array.length - 1; j >= 0; j--) {
            for (int i = 0; i < array[j].length; i++) {
                text += printDesign(array[i][j]);
            }
            text += getNextLine();

        }
        text += "----------------------------------" + getNextLine();

        return text;
    }

    private String printDesign(int value) {
        if (value > 0) {
            if (value / 100 > 0) {
                return "|" + new ConvertVariable().intToString(value) + "|";
            } else if (value / 10 > 0) {
                return "|" + new ConvertVariable().intToString(value) + " |";
            } else {

                return "| " + new ConvertVariable().intToString(value) + " |";

            }
        }
        return "|   |";
    }

    private String getNextLine() {
        return "\n";
    }

    public String converNumberToReadableNumbers(long number) {
        String numberText = number + "";
        int numberTextLength = numberText.length();

        numberText = "";

        int counter = 0;
        for (int i = numberTextLength ; i > 0; i--) {

            if (counter == 3) {
                numberText = "_" + numberText;
                counter = 0;
            }
            numberText = number % 10 + "" + numberText;
            number /= 10;

            counter++;
        }

       /* if (numberText.length() % 3 == 0) {
            numberTextLength--;
        }

        for (int i = numberText.length() - 1; i > 0; i--) {
            if (i % 3 == 2) {
                numberText = "_" + numberText;

            }

        }*/

        return numberText;


    }
}
