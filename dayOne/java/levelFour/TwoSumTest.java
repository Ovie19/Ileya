import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {

    @Test
    public void testThatGetTwoSumReturnsAnArrayOfTheIndexesThatEqualsTheSumOfTheTarget() {
        int[] numbers = {8, 4, -2, 7, 1};
        int target = 6;

        int[] expected = TwoSum.getTwoSum(numbers, target);
        int[] actual = {0, 2};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void testThatGetTwoSumReturnsAnArrayOfTheFirstOccurrenceThatEqualsTheSumOfTheTarget() {
        int[] numbers = {2, 6, 2, -2, 9, 4, 7, 1};
        int target = 10;

        int[] expected = TwoSum.getTwoSum(numbers, target);
        int[] actual = {1, 5};

        assertArrayEquals(actual, expected);
    }
}