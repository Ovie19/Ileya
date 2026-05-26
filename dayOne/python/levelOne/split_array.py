def split_even_odd(array):
    even_list = []
    odd_list = []

    for element in array:
        if element % 2 == 0:
            even_list.append(element)
        else:
            odd_list.append(element)

    return [odd_list, even_list]