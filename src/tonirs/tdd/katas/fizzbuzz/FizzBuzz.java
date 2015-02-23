package tonirs.tdd.katas.fizzbuzz;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";

    public final String translate(final int number) {
        return number % 3 == 0 ? FIZZ : String.valueOf(number);
    }

}
