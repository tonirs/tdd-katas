package tonirs.tdd.katas.stringcalculator.matchers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersOptionallyPrefixedWithDelimitersMatcher {

    private static final Pattern NUMBERS_OPTIONALLY_PREFIXED_WITH_DELIMITERS_PATTERN = Pattern.compile("^(?://((?:<(?:[^>]+)>)+)\n)?(.*)$", Pattern.DOTALL);

    private static final Pattern DELIMITERS_PATTERN = Pattern.compile("(?:<([^>]+)>)+?");

    private static final String DEFAULT_DELIMITERS_REG_EX = ",|\n";
    private String delimitersRegEx;

    private String numbers;

    public void match(final String numbersOptionallyPrefixedWithDelimiters) {
        delimitersRegEx = DEFAULT_DELIMITERS_REG_EX;
        numbers = numbersOptionallyPrefixedWithDelimiters;

        final Matcher numbersOptionallyPrefixedWithDelimitersMatcher = NUMBERS_OPTIONALLY_PREFIXED_WITH_DELIMITERS_PATTERN.matcher(numbers);
        if(numbersOptionallyPrefixedWithDelimitersMatcher.matches()) {
            final String delimiters = numbersOptionallyPrefixedWithDelimitersMatcher.group(1);
            if(delimiters != null) {
                final Matcher delimitersMatcher = DELIMITERS_PATTERN.matcher(delimiters);
                while (delimitersMatcher.find()) {
                    delimitersRegEx += "|" + delimitersMatcher.group(1);
                }
                delimitersRegEx = delimitersRegEx.replace("+", "\\+").replace("*", "\\*");

                numbers = numbersOptionallyPrefixedWithDelimitersMatcher.group(2);
            }
        }
    }

    public final String getDelimitersRegEx() {
        return delimitersRegEx;
    }

    public final String getNumbers() {
        return numbers;
    }

}
