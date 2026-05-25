public class EncodedString {

    public static String getEncodedString(String input) {
        String encodedString = "";

        int count = 1;
        for (int index = 0; index < input.length() - 1; index++) {

            if (input.charAt(index) == input.charAt(index + 1))
                count++;

            else {
                System.out.print(input.charAt(index) + " ");
                encodedString += input.charAt(index) + (count == 1 ? "" : count + "");
                count = 1;
            }
        }

        encodedString += input.charAt(input.length() - 1) + (count == 1 ? "" : count + "");

        return encodedString;
    }
}