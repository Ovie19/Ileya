
const splitArray = (numbers) => {
    let even = [];
    let odd = [];

    for (let index = 0; index < numbers.length; index++) {

        if (numbers[index] % 2 == 0)
            even.push(numbers[index])

        else
            odd.push(numbers[index])
    }

    return [odd, even];
}

module.exports = { splitArray };