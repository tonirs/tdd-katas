package tonirs.tdd.katas.stringcalculator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import tonirs.tdd.katas.stringcalculator.exceptions.DelimiterNotFollowedByNumberException;
import tonirs.tdd.katas.stringcalculator.exceptions.NegativesNotAllowedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTests {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void addSupportsEmptyNumbersString() {
        assertThat(stringCalculator.add(""), is(equalTo(0)));
    }

    @Test
    public void addSupportsAnyAmountOfNumbers() {
        assertThat(stringCalculator.add("3"), is(equalTo(3)));
        assertThat(stringCalculator.add("3,5"), is(equalTo(8)));
        assertThat(stringCalculator.add("1,3,5"), is(equalTo(9)));
    }

    @Test
    public void addSupportsNewLinesAndCommasAsDelimiters() {
        assertThat(stringCalculator.add("1\n3,5"), is(equalTo(9)));
        assertThat(stringCalculator.add("1,2\n3"), is(equalTo(6)));
    }

    @Test(expected = DelimiterNotFollowedByNumberException.class)
    public void delimiterNotFollowedByNumberThrowsException() {
        stringCalculator.add("1,\n");
    }

    @Test
    public void addSupportsGivenDelimiters() {
        assertThat(stringCalculator.add("//;+\n1;2\n3,4+5"), is(equalTo(15)));
        assertThat(stringCalculator.add("//\n1,2\n3,4,5"), is(equalTo(15)));
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void negativeNumbersThrowsException() {
        stringCalculator.add("1,-2,3");
    }

    @Test
    public void numbersBiggerThanOneThousandAreIgnored() {
        assertThat(stringCalculator.add("2,1000"), is(equalTo(1002)));
        assertThat(stringCalculator.add("2,1001"), is(equalTo(2)));
        assertThat(stringCalculator.add("2,2001"), is(equalTo(2)));
    }

}
