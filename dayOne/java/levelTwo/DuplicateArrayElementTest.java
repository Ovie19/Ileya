import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DuplicateArrayElementTest {

    @Test
    public void testThatIPassAnArrayItReturnsAnArrayOfDuplicateElementsFound() {

        int[] array = {1, 2, 3, 2, 4, 3};

        int[] actual = DuplicateArrayElement.getDuplicateElements(array);
        int[] expected = {2, 3};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void testThatIPassAnArrayItReturnsAnEmptyArrayIfNoDuplicateElementsIsFound() {

        int[] array = {1, 2, 3, 4, 5};

        int[] actual = DuplicateArrayElement.getDuplicateElements(array);
        int[] expected = {};

        assertArrayEquals(expected, actual);

    }
}