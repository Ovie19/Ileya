def get_duplicate_element_list(array):
    duplicate_element_list = []
    array.sort()

    for index in range(len(array) - 1):

        if array[index] == array[index + 1]:
            if array[index] not in duplicate_element_list:
                duplicate_element_list.append(array[index])

    return duplicate_element_list