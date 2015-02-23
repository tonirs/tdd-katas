package tonirs.tdd.katas.fizzbuzz;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = FIZZ + BUZZ;

    public final String translate(final int number) {
        if(isMultipleOfFive(number)) {
            return isMultipleOfThree(number) ? FIZZBUZZ : BUZZ;
        }
        return isMultipleOfThree(number) ? FIZZ : String.valueOf(number);
    }

    private boolean isMultipleOfFive(final int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOfThree(final int number) {
        return number % 3 == 0;
    }

}
