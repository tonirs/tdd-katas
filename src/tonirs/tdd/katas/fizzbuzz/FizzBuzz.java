package tonirs.tdd.katas.fizzbuzz;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public final String translate(final int number) {
        return number % 5 == 0 ? BUZZ : number % 3 == 0 ? FIZZ : String.valueOf(number);
    }

}
