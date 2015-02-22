package tonirs.tdd.katas.stringcalculator;

import tonirs.tdd.katas.stringcalculator.exceptions.DelimiterNotFollowedByNumberException;
import tonirs.tdd.katas.stringcalculator.exceptions.InvalidNumberException;
import tonirs.tdd.katas.stringcalculator.exceptions.NegativesNotAllowedException;
import tonirs.tdd.katas.stringcalculator.matchers.NumbersOptionallyPrefixedWithDelimitersMatcher;

public class StringCalculator {

    public int add(final String numbersOptionallyPrefixedWithDelimiters) {
        final NumbersOptionallyPrefixedWithDelimitersMatcher matcher = new NumbersOptionallyPrefixedWithDelimitersMatcher();
        matcher.match(numbersOptionallyPrefixedWithDelimiters);
        final String numbers = matcher.getNumbers();
        final String delimitersRegEx = matcher.getDelimitersRegEx();

        if(numbers.isEmpty()) {
            return 0;
        }

        int sum = 0;
        final String[] tokens = numbers.split(delimitersRegEx, -1);
        for(final String token : tokens) {
            if(token.isEmpty()) {
                throw new DelimiterNotFollowedByNumberException();
            }
            try {
                final int number = Integer.valueOf(token);
                if(number < 0) {
                    throw new NegativesNotAllowedException();
                }
                if(number > 1000) {
                    continue;
                }
                sum += number;
            } catch(final NumberFormatException e) {
                throw new InvalidNumberException();
            }
        }
        return sum;
    }

}
