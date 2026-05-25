import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortArrayTest {

    @Test
    public void testThatIPassTwoArraysItReturnsASortedArrayWithAllElement() {
        int[] arrayA = {3, 5, 1};
        int[] arrayB = {2, 4, 6};

        int[] actual = MergeSortArray.mergeArray(arrayA, arrayB);
        int[] expected = {1, 2, 3, 4, 5, 6};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatIPassTwoOfDifferentSizesArraysItReturnsASortedArrayWithAllElement() {
        int[] arrayA = {1, 3, 5, 1};
        int[] arrayB = {2, 2, 0, 4, 6};

        int[] actual = MergeSortArray.mergeArray(arrayA, arrayB);
        int[] expected = {0, 1, 1, 2, 2, 3, 4, 5, 6};

        assertArrayEquals(expected, actual);
    }
}