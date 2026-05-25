import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PerfectSquareArrayTest {

    @Test
    public void testThatIsPerfectSquareReturnsTrueIfNumberIsPerfectSquare() {
        assertTrue(PerfectSquareArray.isPerfectSquare(9));

        assertTrue(PerfectSquareArray.isPerfectSquare(4));

        assertTrue(PerfectSquareArray.isPerfectSquare(25));
    }

    @Test
    public void testThatIsPerfectSquareReturnsFalseIfNumberIsNotPerfectSquare() {
        assertFalse(PerfectSquareArray.isPerfectSquare(19));

        assertFalse(PerfectSquareArray.isPerfectSquare(41));

        assertFalse(PerfectSquareArray.isPerfectSquare(26));
    }

    @Test
    public void testThatIPassAnArrayAndItReturnsAnArrayOfOnlyPerfectSquare() {
        int[] array = {4, 7, 9, 10, 16, 18};
        int[] actual = PerfectSquareArray.getPerfectSquareInArray(array);
        int[] expected = {4, 9, 16};
        assertArrayEquals(expected, actual);

        int[] arrayTwo = {25, 16, 30, 36, 19, 21};
        int[] actualTwo = PerfectSquareArray.getPerfectSquareInArray(arrayTwo);
        int[] expectedTwo = {25, 16, 36};
        assertArrayEquals(expectedTwo, actualTwo);
    }

    @Test
    public void testThatIPassAnArrayAndItReturnsAnEmptyArrayIfNoPerfectSquareIsFound() {
        int[] array = {41, 7, 19, 10, 13, 18};
        int[] actual = PerfectSquareArray.getPerfectSquareInArray(array);
        int[] expected = {};
        assertArrayEquals(expected, actual);
    }
}