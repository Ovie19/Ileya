

const isPerfectSquare = (number) => {
    let numberSquareRoot = Math.sqrt(number);

    return numberSquareRoot == Math.floor(numberSquareRoot);
};

const getPerfectSquares = (numbers) => {
    let perfectSquareArray = [];

    for (let index = 0; index < numbers.length; index++)
        if (isPerfectSquare(numbers[index]))
            perfectSquareArray.push(numbers[index])

    return perfectSquareArray;
};


module.exports = { isPerfectSquare, getPerfectSquares };