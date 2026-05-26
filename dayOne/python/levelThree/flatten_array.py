def get_total_element_count(array):
    total = 0

    for element in array:
        total += len(element)

    return total

def flatten(array):
    flattened_array = []

    for listItems in array:

        for items in listItems:
            flattened_array.append(items)

    return flattened_array