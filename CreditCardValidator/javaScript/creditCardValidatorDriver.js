const prompt = require("prompt-sync")();

const {
    getCreditCardType,
    getSumSecondDigitFromRightToLeft,
    getSumDigitInOddPlacesFromRightToLeft,
    getCreditCardValidity
} = require("./creditCardValidator");

let creditCardDetails = prompt("Hello, Kindly Enter Card details to verify: ")

let creditCardType = getCreditCardType(creditCardDetails)
let cardDigitlength = creditCardDetails.length
let isValid = getCreditCardValidity(creditCardDetails)

console.log(`
Credit Card Type: ${creditCardType}
Credit Card Number: ${creditCardDetails}
Credit Card Digit Length: ${cardDigitlength}
Credit Card Validity Status: ${isValid ? "Valid" : "Invalid"}
`)