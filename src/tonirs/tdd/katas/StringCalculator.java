package tonirs.tdd.katas;

public class StringCalculator {

    public int add(final String numbers) {
        return numbers.isEmpty() ? 0 : Integer.valueOf(numbers);
    }

}
