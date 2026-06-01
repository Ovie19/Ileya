const { isPalindrome } = require("./palindromeArray");

test("I pass an array it returns true if it is a palindrome", () => {

    let numbers = [45, 0, 8, 0, 45];

    expect(isPalindrome(numbers)).toBe(true);

    numbers = [32, 45, 45, 32];

    expect(isPalindrome(numbers)).toBe(true);


    numbers = [0, 1, 2, 1, 0];

    expect(isPalindrome(numbers)).toBe(true);

});

test("I pass an array it returns false if it is not a palindrome", () => {

    let numbers = [45, 10, 8, 0, 45];

    expect(isPalindrome(numbers)).toBe(false);

    numbers = [32, 45, 15, 32];

    expect(isPalindrome(numbers)).toBe(false);


    numbers = [0, 1, 2, 0, 1];

    expect(isPalindrome(numbers)).toBe(false);

});