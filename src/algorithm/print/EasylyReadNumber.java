package algorithm.print;

import algorithm.printarray.StringFormat;

public class EasylyReadNumber implements ReadAbleNumberInStringFormat {
    @Override
    public String getReadableNumberInStringFormat(long number) {
        StringFormat stringFormat = new StringFormat();
        String numberInReadableStringFormat = stringFormat.converNumberToReadableNumbers(number);
        return numberInReadableStringFormat;
    }
}
