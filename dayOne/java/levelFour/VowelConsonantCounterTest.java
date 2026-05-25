import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VowelConsonantCounterTest {

    @Test
    public void testThatIfACharacterIsVowelItReturnsTrue() {
        assertTrue(VowelConsonantCounter.isVowel('a'));

        assertTrue(VowelConsonantCounter.isVowel('E'));

        assertTrue(VowelConsonantCounter.isVowel('I'));

        assertTrue(VowelConsonantCounter.isVowel('o'));

        assertTrue(VowelConsonantCounter.isVowel('U'));
    }

    @Test
    public void testThatIfACharacterIsNotVowelItReturnsFalse() {
        assertFalse(VowelConsonantCounter.isVowel('b'));

        assertFalse(VowelConsonantCounter.isVowel('z'));

        assertFalse(VowelConsonantCounter.isVowel('q'));

        assertFalse(VowelConsonantCounter.isVowel('t'));
    }

    @Test
    public void testThatIPassAStringItReturnsAnArrayOfVowelsAndConsonantsWithTheirCount() {
        String input = "Hello - World";

        Object[][] expectedOne = {{"vowels", 3}, {"consonants", 7}};
        Object[][] actualOne = VowelConsonantCounter.getVowelConsonantCountArray(input);

        assertArrayEquals(expectedOne, actualOne);


        String inputTwo = "Good day Sir";

        Object[][] expectedTwo = {{"vowels", 4}, {"consonants", 6}};
        Object[][] actualTwo = VowelConsonantCounter.getVowelConsonantCountArray(inputTwo);

        assertArrayEquals(expectedTwo, actualTwo);
    }
}