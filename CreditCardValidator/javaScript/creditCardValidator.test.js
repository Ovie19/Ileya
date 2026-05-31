const {
    getCreditCardType,
    getSumSecondDigitFromRightToLeft,
    getSumDigitInOddPlacesFromRightToLeft,
    getCreditCardValidity
} = require("./creditCardValidator");

test("test that I input MasterCard credit card it returns MasterCard", () => {
    let creditCardDetails = "5399831619690403";

    expect(getCreditCardType(creditCardDetails)).toBe("MasterCard");
});

test("test That I Input Any Credit Card I Get The Correct Card Type", () => {
    let creditCardDetails  = "5399831619690403";
    expect(getCreditCardType(creditCardDetails)).toBe("MasterCard");

    creditCardDetails  = "4299831619690403";
    expect(getCreditCardType(creditCardDetails)).toBe("Visa Cards");

    creditCardDetails  = "3799831619690403";
    expect(getCreditCardType(creditCardDetails)).toBe("American Express Cards");

    creditCardDetails  = "6199831619690403";
    expect(getCreditCardType(creditCardDetails)).toBe("Discover Cards");
});

test("test That I Input Invalid Credit Card It Returns Invalid Card", () => {
    let creditCardDetails = "2399831619690403";
    expect(getCreditCardType(creditCardDetails)).toBe("Invalid Card");
});

test("test That GetSumSecondDigitFromRightToLeft Returns Right Value", () => {
    let creditCardDetails  = "4388576018402626";
    expect(getSumSecondDigitFromRightToLeft(creditCardDetails)).toBe(37);
});

test(
    "test That GetSumSumDigitInOddPlacesFromRightToLeft Returns Right Value",
    () => {

    let creditCardDetails  = "4388576018402626";
    expect(getSumDigitInOddPlacesFromRightToLeft(creditCardDetails)).toBe(38);
});

test ("test That I Input Any Credit Card I Get Correct Validity", () => {

    let creditCardDetails  = "4388576018402626";
    expect(getCreditCardValidity(creditCardDetails)).toBe(false);

    creditCardDetails  = "4388576018410707";
    expect(getCreditCardValidity(creditCardDetails)).toBe(true);

    creditCardDetails  = "5399831619690404";
    expect(getCreditCardValidity(creditCardDetails)).toBe(false);

    creditCardDetails  = "5399831619690403";
    expect(getCreditCardValidity(creditCardDetails)).toBe(true);

    creditCardDetails  = "234319283049582";
    expect(getCreditCardValidity(creditCardDetails)).toBe(false);

});
