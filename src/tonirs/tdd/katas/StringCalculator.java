package tonirs.tdd.katas;

import java.util.StringTokenizer;

public class StringCalculator {

    public int add(final String numbers) {
        int sum = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(numbers, ",");
        while(stringTokenizer.hasMoreTokens()) {
            final String number = stringTokenizer.nextToken();
            sum += Integer.valueOf(number);
        }
        return sum;
    }

}
