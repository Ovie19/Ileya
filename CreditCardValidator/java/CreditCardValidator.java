public class CreditCardValidator {
    public static String getCreditCardType(String creditCard) {

        if (creditCard.startsWith("4"))
            return "Visa Cards";

        else if (creditCard.startsWith("5"))
            return "MasterCard";

        else if (creditCard.startsWith("37"))
            return "American Express Cards";

        else if (creditCard.startsWith("6"))
            return "Discover Cards";

        return "Invalid Card";
    }

    public static int getCreditCardLength(String creditCard) {

        return creditCard.length();
    }

    public static int getSumSecondDigitFromRightToLeft(String creditCard) {
        int total = 0;

        for(int index = creditCard.length() - 2; index >= 0; index -= 2) {
            int number = Integer.parseInt(creditCard.charAt(index) + "");
            number *= 2;

            if (number > 9)
                total += number - 9;

            else
                total += number;
        }

        return total;
    }

    public static int getSumDigitInOddPlacesFromRightToLeft(String creditCard) {

        int total = 0;

        for(int index = creditCard.length() - 1; index >= 0; index -= 2) {
            int number = Integer.parseInt(creditCard.charAt(index) + "");

            total += number;
        }

        return total;
    }

    public static boolean getCreditCardValidity(String creditCard) {
        if (creditCard.length() < 13 || creditCard.length() > 16)
            return false;

        if (getCreditCardType(creditCard).equals("Invalid Card"))
            return false;

        int total = getSumDigitInOddPlacesFromRightToLeft(creditCard) + getSumSecondDigitFromRightToLeft(creditCard);

        return total % 10 == 0;
    }
}
