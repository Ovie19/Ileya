const { replaceNonPerfectSquares } = require("./nonPerfectSquareArray");


test("I pass an array and it returns an array with non perfect squares as -1",
    () => {

    let numbers = [4, 7, 9, 10, 16, 18];

    let actual = [4, -1, 9, -1, 16, -1];

    expect(replaceNonPerfectSquares(numbers)).toEqual(actual);
});

test("I pass an array and it returns an array of filled with -1 if there are no perfect squares",
    () => {

    let numbers = [5, 7, 12, 10, 17, 18];

    let actual = [-1, -1, -1, -1, -1, -1];

    expect(replaceNonPerfectSquares(numbers)).toEqual(actual);
});