const getCreditCardType = (creditCardDetails) => {
    if (creditCardDetails.startsWith("4"))
        return "Visa Cards";

    else if (creditCardDetails.startsWith("5"))
        return "MasterCard";

    else if (creditCardDetails.startsWith("37"))
        return "American Express Cards";

    else if (creditCardDetails.startsWith("6"))
        return "Discover Cards";

    return "Invalid Card";
};

const getSumSecondDigitFromRightToLeft = (creditCardDetails) => {
    let total = 0;

    for(let index = creditCardDetails.length - 2; index >= 0; index -= 2) {
        let number = Number(creditCardDetails[index]);
        number *= 2;

        if (number > 9)
            total += number - 9;

        else
            total += number;
    }

    return total;
};

const getSumDigitInOddPlacesFromRightToLeft = (creditCardDetails) => {
    let total = 0;

    for(let index = creditCardDetails.length - 1; index >= 0; index -= 2) {
        let number = Number(creditCardDetails[index]);

        total += number;
    }

    return total;
};

const getCreditCardValidity = (creditCardDetails) => {
    if (getCreditCardType(creditCardDetails) == "Invalid Card")
        return false;

    let total = getSumDigitInOddPlacesFromRightToLeft(creditCardDetails) + getSumSecondDigitFromRightToLeft(creditCardDetails);

    return total % 10 == 0;
};


module.exports = {
    getCreditCardType,
    getSumSecondDigitFromRightToLeft,
    getSumDigitInOddPlacesFromRightToLeft,
    getCreditCardValidity
};