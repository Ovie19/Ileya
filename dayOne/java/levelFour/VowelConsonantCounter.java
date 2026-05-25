public class VowelConsonantCounter {

    public static boolean isVowel(char character) {
        switch (Character.toLowerCase(character)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }

        return false;
    }

    public static Object[][] getVowelConsonantCountArray(String input) {
        Object[][] result = {{"vowels", 0}, {"consonants", 0}};

        int vowelCount = 0;
        int consonantCount = 0;

        for (int index = 0; index < input.length(); index++) {
            char character = input.charAt(index);

            if (!Character.isLetter(character))
                continue;

            if (isVowel(character))
                vowelCount++;
            else
                consonantCount++;
        }

        result[0][1] = vowelCount;
        result[1][1] = consonantCount;

        return result;
    }
}