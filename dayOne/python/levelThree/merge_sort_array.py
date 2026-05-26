def merge_sort(listOne, listTwo):
    new_list = listOne + listTwo

    for index in range(len(new_list)):
        current_index = index

        for inner_index in range(index + 1, len(new_list)):

            if new_list[current_index] > new_list[inner_index]:
                current_index = inner_index

        if current_index != index:
            temporary_value = new_list[index]
            new_list[index] = new_list[current_index]
            new_list[current_index] = temporary_value

    return new_list
