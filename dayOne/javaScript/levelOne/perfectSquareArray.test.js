const { isPerfectSquare, getPerfectSquares } = require("./perfectSquareArray");

test("I pass in a number it returns true if number is a perfect square", () => {

    expect(isPerfectSquare(4)).toBe(true);

    expect(isPerfectSquare(16)).toBe(true);

    expect(isPerfectSquare(9)).toBe(true);
});

test("I pass in a number it returns false if number is a perfect square", () => {

    expect(isPerfectSquare(5)).toBe(false);

    expect(isPerfectSquare(17)).toBe(false);

    expect(isPerfectSquare(92)).toBe(false);
});

test("I pass an array and it returns an array of only perfect squares", () => {

    let numbers = [4, 7, 9, 10, 16, 18];

    let actual = [4, 9, 16];

    expect(getPerfectSquares(numbers)).toEqual(actual);
});

test("I pass an array and it returns an empty array if there are no perfect squares",
    () => {

    let numbers = [5, 7, 12, 10, 17, 18];

    let actual = [];

    expect(getPerfectSquares(numbers)).toEqual(actual);
});