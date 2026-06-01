
const isPalindrome = (numbers) => {
    let left = 0;
    let right = numbers.length - 1;

    while (left < right) {
        if (numbers[left] != numbers[right])
            return false;

        left++;
        right--;
    }

    return true;
};


module.exports = { isPalindrome };