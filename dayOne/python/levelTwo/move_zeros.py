def move_zeros_in_list(array):
    non_zero_index = 0

    for index in range(len(array)):

        if array[index] != 0:
            temporary_value = array[index]
            array[index] = array[non_zero_index]
            array[non_zero_index] = temporary_value
            non_zero_index += 1