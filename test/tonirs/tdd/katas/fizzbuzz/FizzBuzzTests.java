package tonirs.tdd.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTests {

    private static final String FIZZ = "Fizz";

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void numberNotMultipleOfThreeTranslatesToItself() {
        assertThat(fizzBuzz.translate(1), is(equalTo("1")));
        assertThat(fizzBuzz.translate(2), is(equalTo("2")));
        assertThat(fizzBuzz.translate(4), is(equalTo("4")));
        assertThat(fizzBuzz.translate(5), is(equalTo("5")));
    }

    @Test
    public void numberMultipleOfThreeTranslatesToFizz() {
        assertThat(fizzBuzz.translate(3), is(equalTo(FIZZ)));
        assertThat(fizzBuzz.translate(6), is(equalTo(FIZZ)));
        assertThat(fizzBuzz.translate(18), is(equalTo(FIZZ)));
    }

}
