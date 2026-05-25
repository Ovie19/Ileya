import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncodedStringTest {

    @Test
    public void testThatIPassAStringOfCharacterItReturnsAnEncodedStringWithEachCharacterAndItsCount() {
        String input = "aaabbc";
        String expected = "a3b2c";
        String actual = EncodedString.getEncodedString(input);
        assertEquals(expected, actual);

        input = "aabccaa";
        expected = "a2bc2a2";
        actual = EncodedString.getEncodedString(input);
        assertEquals(expected, actual);
    }
}