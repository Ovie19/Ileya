import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherTest {

    @Test
    public void testThatIPassACharacterAndShiftValueItReturnsTheEncryptedCaesarCipherValue() {

        char character = 'C';

        char expected = 'F';

        char actual = CaesarCipher.getEncryptedCipherValue(character, 3);

        assertEquals(expected, actual);


        character = 'o';

        expected = 'x';

        actual = CaesarCipher.getEncryptedCipherValue(character, 9);

        assertEquals(expected, actual);


        character = 'Y';

        expected = 'I';

        actual = CaesarCipher.getEncryptedCipherValue(character, 10);

        assertEquals(expected, actual);


        character = 'v';

        expected = 'e';

        actual = CaesarCipher.getEncryptedCipherValue(character, 9);

        assertEquals(expected, actual);
    }

    @Test
    public void testThatIPassACharacterAndShiftValueItReturnsTheDecryptedCaesarCipherValue() {

        char character = 'F';

        char expected = 'C';

        char actual = CaesarCipher.getDecryptedCipherValue(character, 3);

        assertEquals(expected, actual);


        character = 'x';

        expected = 'o';

        actual = CaesarCipher.getDecryptedCipherValue(character, 9);

        assertEquals(expected, actual);


        character = 'I';

        expected = 'Y';

        actual = CaesarCipher.getDecryptedCipherValue(character, 10);

        assertEquals(expected, actual);


        character = 'e';

        expected = 'v';

        actual = CaesarCipher.getDecryptedCipherValue(character, 9);

        assertEquals(expected, actual);
    }


    @Test
    public void testThatIPassAStringAndShiftValueItReturnsTheCaesarCipherValue() {
        String message = "CALL ME TOMORROW";

        String expected = "FDOO PH WRPRUURZ";

        String actual = CaesarCipher.getEncryptedTest(message, 3);

        assertEquals(expected, actual);


        message = "Call me tomorrow";

        expected = "Fdoo ph wrpruurz";

        actual = CaesarCipher.getEncryptedTest(message, 3);

        assertEquals(expected, actual);
    }


    @Test
    public void testThatIPassAStringAndADifferentShiftValueItReturnsTheCaesarCipherValue() {
        String message = "CALL ME TOMORROW";

        String expected = "IGRR SK ZUSUXXUC";

        String actual = CaesarCipher.getEncryptedTest(message, 6);

        assertEquals(expected, actual);


        message = "Call me tomorrow";

        expected = "Igrr sk zusuxxuc";

        actual = CaesarCipher.getEncryptedTest(message, 6);

        assertEquals(expected, actual);
    }


    @Test
    public void testThatIPassAStringAndShiftValueItReturnsTheDecipherCaesarCipherValue() {
        String message = "FDOO PH WRPRUURZ";

        String expected = "CALL ME TOMORROW";

        String actual = CaesarCipher.getDecryptedText(message, 3);

        assertEquals(expected, actual);


        message = "Fdoo ph wrpruurz";

        expected = "Call me tomorrow";

        actual = CaesarCipher.getDecryptedText(message, 3);

        assertEquals(expected, actual);
    }


    @Test
    public void testThatIPassAStringAndADifferentShiftValueItReturnsTheDecryptedCaesarCipherValue() {
        String message = "IGRR SK ZUSUXXUC";

        String expected = "CALL ME TOMORROW";

        String actual = CaesarCipher.getDecryptedText(message, 6);

        assertEquals(expected, actual);


        message = "Igrr sk zusuxxuc";

        expected = "Call me tomorrow";

        actual = CaesarCipher.getDecryptedText(message, 6);

        assertEquals(expected, actual);
    }

}