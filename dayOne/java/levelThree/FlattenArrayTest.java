import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlattenArrayTest {
    @Test
    public void testThatIPassAnArrayOfArraysItReturnsTheTotalCountOfElements() {

        int[][] array = {{9, 0, 7}, {3, 5, 1}, {8, 1, 7}, {9, 9, 6}};
        int actual = FlattenArray.getElementsCount(array);
        int expected = 12;
        assertEquals(expected, actual);

        int[][] arrayTwo = {{2, 3}, {1, 2, 3}, {4, 5, 6}, {7, 8}};
        int actualTwo = FlattenArray.getElementsCount(arrayTwo);
        int expectedTwo = 10;
        assertEquals(expectedTwo, actualTwo);
    }

    @Test
    public void testThatIPassAnArrayOfArraysItReturnsASingleArrayWithAllElements() {
        int[][] array = {{9, 0, 7}, {3, 5, 1}, {8, 1, 7}, {9, 9, 6}};
        int[] actual = FlattenArray.flatten(array);
        int[] expected = {9, 0, 7, 3, 5, 1, 8, 1, 7, 9, 9, 6};
        assertArrayEquals(expected, actual);

        int[][] arrayTwo = {{2, 3}, {1, 2, 3}, {4, 5, 6}, {7, 8}};
        int[] actualTwo = FlattenArray.flatten(arrayTwo);
        int[] expectedTwo = {2, 3, 1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expectedTwo, actualTwo);
    }
}