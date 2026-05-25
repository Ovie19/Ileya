import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZerosTest {

    @Test
    public void testThatIPassAnArrayAndItReturnsAnArryWithZerosAtTheBack() {

        int[] arrayOne = {5, 0 , 3, 0, 2, 0};
        MoveZeros.moveZerosToBackOfArray(arrayOne);
        int[] expectedOne = {5, 3, 2, 0, 0, 0};
        assertArrayEquals(expectedOne, arrayOne);

        int[] arrayTwo = {0, 0 , 0, 0, 0, 1};
        MoveZeros.moveZerosToBackOfArray(arrayTwo);
        int[] expectedTwo = {1, 0, 0, 0, 0, 0};
        assertArrayEquals(expectedTwo, arrayTwo);
    }
}