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
    public void addSupportsAnyAmountOfNumbers() {
        assertThat(stringCalculator.add(""), is(equalTo(0)));
        assertThat(stringCalculator.add("3"), is(equalTo(3)));
        assertThat(stringCalculator.add("-3,5"), is(equalTo(2)));
        assertThat(stringCalculator.add("1,3,5"), is(equalTo(9)));
        assertThat(stringCalculator.add("-3,5,-2,7"), is(equalTo(7)));
    }

}
