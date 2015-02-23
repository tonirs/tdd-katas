package tonirs.tdd.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTests {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = FIZZ + BUZZ;

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void numbersNeitherMultipleOfThreeNorFiveTranslateToThemselves() {
        final int[] numbers = { 1, 2, 4 };
        for(int number : numbers) {
            assertThat(fizzBuzz.translate(number), is(equalTo(String.valueOf(number))));
        }
    }

    @Test
    public void numbersMultipleOfThreeAndNotFiveTranslateToFizz() {
        final int[] numbers = { 3, 6, 18 };
        for(int number : numbers) {
            assertThat(fizzBuzz.translate(number), is(equalTo(FIZZ)));
        }
    }

    @Test
    public void numbersMultipleOfFiveAndNotThreeTranslateToBuzz() {
        final int[] numbers = { 5, 10, 20 };
        for(int number : numbers) {
            assertThat(fizzBuzz.translate(number), is(equalTo(BUZZ)));
        }
    }

    @Test
    public void numbersMultipleOfThreeAndFiveTranslateToFizzBuzz() {
        final int[] numbers = { 15, 30, 45 };
        for(int number : numbers) {
            assertThat(fizzBuzz.translate(number), is(equalTo(FIZZBUZZ)));
        }
    }

}
