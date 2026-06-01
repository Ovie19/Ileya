

const isPerfectSquare = (number) => {
    let numberSquareRoot = Math.sqrt(number);

    return numberSquareRoot == Math.floor(numberSquareRoot);
};

const replaceNonPerfectSquares = (numbers) => {
    let newArray = [];

    for (let index = 0; index < numbers.length; index++) {
        if (!isPerfectSquare(numbers[index]))
            newArray.push(-1)
        else
            newArray.push(numbers[index])

    }

    return newArray;
};


module.exports = { replaceNonPerfectSquares };