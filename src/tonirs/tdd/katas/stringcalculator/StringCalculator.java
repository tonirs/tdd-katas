package tonirs.tdd.katas.stringcalculator;

import tonirs.tdd.katas.stringcalculator.exceptions.NegativesNotAllowedException;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",\n";
    private static final Pattern NUMBERS_OPTIONALLY_PREFIXED_WITH_DELIMITERS_PATTERN = Pattern.compile("^//([^\n]*)\n(.*)$", Pattern.DOTALL);

    public int add(final String numbersOptionallyPrefixedWithDelimiters) {
        final StringCalculatorMatcher stringCalculatorMatcher = new StringCalculatorMatcher();
        stringCalculatorMatcher.match(numbersOptionallyPrefixedWithDelimiters);
        final String numbers = stringCalculatorMatcher.getNumbers();
        final String delimiters = stringCalculatorMatcher.getDelimiters();

        int sum = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(numbers, delimiters);
        while(stringTokenizer.hasMoreTokens()) {
            final String token = stringTokenizer.nextToken();
            final int number = Integer.valueOf(token);
            if(number < 0) {
                throw new NegativesNotAllowedException();
            }
            if(number > 1000) {
                continue;
            }
            sum += number;
        }
        return sum;
    }

    private class StringCalculatorMatcher {
        private String delimiters;
        private String numbers;

        public void match(final String numbersOptionallyPrefixedWithDelimiters) {
            delimiters = DEFAULT_DELIMITERS;
            numbers = numbersOptionallyPrefixedWithDelimiters;

            final Matcher numbersOptionallyPrefixedWithDelimitersMatcher = NUMBERS_OPTIONALLY_PREFIXED_WITH_DELIMITERS_PATTERN.matcher(numbers);
            if(numbersOptionallyPrefixedWithDelimitersMatcher.matches()) {
                delimiters += numbersOptionallyPrefixedWithDelimitersMatcher.group(1);
                numbers = numbersOptionallyPrefixedWithDelimitersMatcher.group(2);
            }
        }

        public final String getDelimiters() {
            return delimiters;
        }

        public final String getNumbers() {
            return numbers;
        }

    }

}
