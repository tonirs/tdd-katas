package tonirs.tdd.katas.stringcalculator.matchers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumbersOptionallyPrefixedWithDelimitersMatcherTest {

    private NumbersOptionallyPrefixedWithDelimitersMatcher numbersOptionallyPrefixedWithDelimitersMatcher;

    @Before
    public void setUp() throws Exception {
        numbersOptionallyPrefixedWithDelimitersMatcher = new NumbersOptionallyPrefixedWithDelimitersMatcher();
    }

    @Test
    public void supportsNewLinesAndCommasAsDelimiters() {
        numbersOptionallyPrefixedWithDelimitersMatcher.match("");
        final String expectedDelimitersRegEx = ",|\n";
        assertThat(numbersOptionallyPrefixedWithDelimitersMatcher.getDelimitersRegEx(), is(equalTo(expectedDelimitersRegEx)));
        assertThat(numbersOptionallyPrefixedWithDelimitersMatcher.getNumbers(), is(equalTo("")));
    }

    @Test
    public void supportsGivenDelimitersOfAnyLength() {
        numbersOptionallyPrefixedWithDelimitersMatcher.match("//<;><***><+>\n");
        final String expectedDelimitersRegEx = ",|\n|;|\\*\\*\\*|\\+";
        assertThat(numbersOptionallyPrefixedWithDelimitersMatcher.getDelimitersRegEx(), is(equalTo(expectedDelimitersRegEx)));
        assertThat(numbersOptionallyPrefixedWithDelimitersMatcher.getNumbers(), is(equalTo("")));
    }

}