package tonirs.tdd.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTests {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void numberNeitherMultipleOfThreeNorFiveTranslatesToItself() {
        assertThat(fizzBuzz.translate(1), is(equalTo("1")));
        assertThat(fizzBuzz.translate(2), is(equalTo("2")));
        assertThat(fizzBuzz.translate(4), is(equalTo("4")));
    }

}
