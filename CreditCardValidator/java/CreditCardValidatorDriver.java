import java.util.Scanner;

public class CreditCardValidatorDriver {

    public static void main(String... labaks) {

        Scanner inputCollector = new Scanner(System.in);

        System.out.println("Hello, Kindly Enter Card details to verify");
        String cardDetails = inputCollector.nextLine();

        String creditCardType = CreditCardValidator.getCreditCardType(cardDetails);
        int cardDigitLength = CreditCardValidator.getCreditCardLength(cardDetails);
        boolean isValid = CreditCardValidator.getCreditCardValidity(cardDetails);

        System.out.println("\nCredit Card Type: " + creditCardType);
        System.out.println("Credit Card Number: " + cardDetails);
        System.out.println("Credit Card Digit Length: " + cardDigitLength);
        System.out.println("Credit Card Validity Status: " + (isValid ? "Valid" : "Invalid"));
    }
}