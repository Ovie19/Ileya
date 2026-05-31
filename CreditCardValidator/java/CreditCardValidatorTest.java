import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class CreditCardValidatorTest {
    @Test
    public void testThatIInputMyAMastercardCreditCardIGetMasterCard() {
        String creditCardDetails  = "5399831619690403";

        String expected = CreditCardValidator.getCreditCardType(creditCardDetails);
        String actual = "MasterCard";

        assertEquals(actual, expected);
    }

    @Test
    public void testThatIInputAnyCreditCardIGetCorrectCardType() {
        String creditCardDetails  = "5399831619690403";
        String expected = CreditCardValidator.getCreditCardType(creditCardDetails);
        String actual = "MasterCard";
        assertEquals(actual, expected);


        creditCardDetails  = "4299831619690403";
        expected = CreditCardValidator.getCreditCardType(creditCardDetails);
        actual = "Visa Cards";
        assertEquals(actual, expected);


        creditCardDetails  = "3799831619690403";
        expected = CreditCardValidator.getCreditCardType(creditCardDetails);
        actual = "American Express Cards";
        assertEquals(actual, expected);


        creditCardDetails  = "6199831619690403";
        expected = CreditCardValidator.getCreditCardType(creditCardDetails);
        actual = "Discover Cards";
        assertEquals(actual, expected);
    }

    @Test
    public void testThatIInputInvalidCreditCardItReturnsInvalidCard() {
        String creditCardDetails  = "2399831619690403";

        String expected = CreditCardValidator.getCreditCardType(creditCardDetails);
        String actual = "Invalid Card";

        assertEquals(actual, expected);
    }

    @Test
    public void testThatIInputAnyCreditCardIGetTheActualLengthOfTheCard() {
        String creditCardDetails  = "5399831619690403";
        int expected = CreditCardValidator.getCreditCardLength(creditCardDetails);
        int actual = 16;

        assertEquals(actual, expected);
    }

    @Test
    public void testThatITheGetSumSecondDigitFromRightToLeftReturnsRightValue() {
        String creditCardDetails  = "4388576018402626";

        int expected = CreditCardValidator.getSumSecondDigitFromRightToLeft(creditCardDetails);
        int actual = 37;

        assertEquals(actual, expected);
    }

    @Test
    public void testThatITheGetSumSumDigitInOddPlacesFromRightToLeftReturnsRightValue() {
        String creditCardDetails  = "4388576018402626";

        int expected = CreditCardValidator.getSumDigitInOddPlacesFromRightToLeft(creditCardDetails);
        int actual = 38;

        assertEquals(actual, expected);
    }

    @Test
    public void testThatIInputAnyCreditCardIGetCorrectValidity() {
        String creditCardDetails  = "4388576018402626";
        assertFalse(CreditCardValidator.getCreditCardValidity(creditCardDetails));

        creditCardDetails  = "4388576018410707";
        assertTrue(CreditCardValidator.getCreditCardValidity(creditCardDetails));

        creditCardDetails  = "5399831619690404";
        assertFalse(CreditCardValidator.getCreditCardValidity(creditCardDetails));

        creditCardDetails  = "5399831619690403";
        assertTrue(CreditCardValidator.getCreditCardValidity(creditCardDetails));

        creditCardDetails  = "234319283049582";
        assertFalse(CreditCardValidator.getCreditCardValidity(creditCardDetails));
    }
}