import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ReplaceNonPerfectSquareTest {

    @Test
    public void testThatIPassAnArrayAndItReturnsAnArrayWithNonPerfectSquareAsMinusOne() {
        int[] array = {4, 7, 9, 10, 16, 18};
        int[] actual = ReplaceNonPerfectSquare.replaceNonPerfectSquareInArray(array);
        int[] expected = {4, -1, 9, -1, 16, -1};
        assertArrayEquals(expected, actual);

        int[] arrayTwo = {25, 16, 30, 36, 19, 21};
        int[] actualTwo = ReplaceNonPerfectSquare.replaceNonPerfectSquareInArray(arrayTwo);
        int[] expectedTwo = {25, 16, -1, 36, -1, -1};
        assertArrayEquals(expectedTwo, actualTwo);
    }

    @Test
    public void testThatIPassAnArrayAndItReturnsAnEmptyArrayIfNoPerfectSquareIsFound() {
        int[] array = {41, 7, 19, 10, 13};
        int[] actual = ReplaceNonPerfectSquare.replaceNonPerfectSquareInArray(array);
        int[] expected = {-1, -1, -1, -1, -1};
        assertArrayEquals(expected, actual);
    }
}