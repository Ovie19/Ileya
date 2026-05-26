def get_two_sum(numbers, target):
    new_numbers = []

    for index in range(len(numbers)):

        for inner_index in range(len(numbers) - 1, index, -1):

            if numbers[index] + numbers[inner_index] == target:

                new_numbers.append(index)

                new_numbers.append(inner_index)

                return new_numbers

    return new_numbers