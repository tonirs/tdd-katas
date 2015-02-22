package tonirs.tdd.katas;

import org.junit.*;

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
    public void addWithZeroNumbersReturnsZero() {
        assertThat(stringCalculator.add(""), is(equalTo(0)));
    }

    @Test
    public void addWithOneNumbersReturnsTheNumber() {
        assertThat(stringCalculator.add("3"), is(equalTo(3)));
        assertThat(stringCalculator.add("5"), is(equalTo(5)));
    }

    @Test
    public void addWithTwoNumbersReturnsTheSumOfTheNumbers() {
        assertThat(stringCalculator.add("3,5"), is(equalTo(8)));
        assertThat(stringCalculator.add("-3,5"), is(equalTo(2)));
    }

}
