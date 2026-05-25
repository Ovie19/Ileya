import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SplitArrayTest {

    @Test
    public void testThatIPassAnArrayAndItReturnsAnArrayOfArraysWithEvenAndOddNumbersSeparated() {

        int[] array = {45, 60, 3, 10, 9, 22};

        int[][] actual = SplitArray.splitArray(array);
        int[][] expected = {{45, 3, 9}, {60, 10, 22}};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatIPassAnArrayWithOnlyOddNumbersAndItReturnsAnArrayOfArraysWithEmptyEvenAndOddNumbersSeparated() {

        int[] array = {45, 3, 5, 11, 31, 9};

        int[][] actual = SplitArray.splitArray(array);
        int[][] expected = {{45, 3, 5, 11, 31, 9}, {}};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatIPassAnArrayWithOnlyEvenNumbersAndItReturnsAnArrayOfArraysWithEvenAndEmptyOddNumbersSeparated() {

        int[] array = {40, 24, 32, 64, 58};

        int[][] actual = SplitArray.splitArray(array);
        int[][] expected = {{}, {40, 24, 32, 64, 58}};

        assertArrayEquals(expected, actual);
    }
}
