public class CaesarCipher {

    public static char getEncryptedCipherValue(char character, int shiftValue) {
        int asciiValue = (int) character;
        int newCharacterAsciiValue = asciiValue + shiftValue;

        if (Character.isUpperCase(character) && newCharacterAsciiValue > 90) {
            int remainder = newCharacterAsciiValue - 90;
            newCharacterAsciiValue = 65 + remainder - 1;
        }

        if (Character.isLowerCase(character) && newCharacterAsciiValue > 122) {
            int remainder = newCharacterAsciiValue - 122;
            newCharacterAsciiValue = 97 + remainder - 1;
        }

        return (char) newCharacterAsciiValue;
    }

    public static char getDecryptedCipherValue(char character, int shiftValue) {
        int asciiValue = (int) character;
        int newCharacterAsciiValue = asciiValue - shiftValue;

        if (Character.isUpperCase(character) && newCharacterAsciiValue < 65) {
            int remainder = 65 - newCharacterAsciiValue;
            newCharacterAsciiValue = 90 - remainder + 1;
        }

        if (Character.isLowerCase(character) && newCharacterAsciiValue < 97) {
            int remainder = 97 - newCharacterAsciiValue;
            newCharacterAsciiValue = 122 - remainder + 1;
        }

        return (char) newCharacterAsciiValue;
    }

    public static String getEncryptedTest(String message, int shiftValue) {
        String encryptedMessage = "";

        for (int index = 0; index < message.length(); index++) {
            char character = message.charAt(index);

            if (Character.isLetter(character))
                encryptedMessage += getEncryptedCipherValue(character, shiftValue);

            else
                encryptedMessage += character;
        }

        return encryptedMessage;
    }

    public static String getDecryptedText(String message, int shiftValue) {
        String decryptedMessage = "";

        for (int index = 0; index < message.length(); index++) {
            char character = message.charAt(index);

            if (Character.isLetter(character))
                decryptedMessage += getDecryptedCipherValue(character, shiftValue);

            else
                decryptedMessage += character;
        }

        return decryptedMessage;
    }
}
