const { splitArray } = require("./splitArray");

test("I pass an array and it split it into two arrays of even and odds", () => {

    let numbers = [45, 60, 3, 10, 9, 22];

    let expected = [[45, 3, 9], [60, 10, 22]];

    let actual = splitArray(numbers);

    expect(actual).toEqual(expected);
});

test("I pass an array of odd numbers and it split it into two arrays of empty even and odds",
    () => {

    let numbers = [45, 61, 3, 11, 9, 23];

    let expected = [[45, 61, 3, 11, 9, 23], []];

    let actual = splitArray(numbers);

    expect(actual).toEqual(expected);
});

test("I pass an array of even numbers and it split it into two arrays of even and empty odds",
    () => {

    let numbers = [46, 60, 4, 10, 16, 22];

    let expected = [[], [46, 60, 4, 10, 16, 22]];

    let actual = splitArray(numbers);

    expect(actual).toEqual(expected);
});
