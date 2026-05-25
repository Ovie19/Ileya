import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PalindromeArrayTest {

    @Test
    public void testThatCheckIfPalindromeMethodReturnsTrueIfAnArrayIsAPalindrome() {

        int[] arrayOne = {45, 0, 8, 0, 45};
        assertTrue(PalindromeArray.checkIfPalindrome(arrayOne));

        int[] arrayTwo = {-20, 10, 10, -20};
        assertTrue(PalindromeArray.checkIfPalindrome(arrayTwo));
    }

    @Test
    public void testThatCheckIfPalindromeMethodReturnsFalseIfAnArrayIsNotAPalindrome() {

        int[] arrayOne = {45, 1, 8, 0, 45};
        assertFalse(PalindromeArray.checkIfPalindrome(arrayOne));

        int[] arrayTwo = {-20, 12, 10, -20};
        assertFalse(PalindromeArray.checkIfPalindrome(arrayTwo));
    }
}