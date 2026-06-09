def get_credit_card_type(credit_card_details):

    if credit_card_details.startswith("4"):
        return "Visa Cards"

    elif credit_card_details.startswith("5"):
        return "MasterCard"

    elif credit_card_details.startswith("37"):
        return "American Express Cards"

    elif credit_card_details.startswith("6"):
        return "Discover Cards"

    return "Invalid Card"

def get_sum_second_digit_from_right_to_left(credit_card_details):
    length = len(credit_card_details)
    total = 0

    for index in range(length - 2, -1, -2):
        number = int(credit_card_details[index])
        number *= 2

        if number > 9:
            total += number - 9
        else:
            total += number

    return total

def get_sum_second_digit_in_odd_places_from_right_to_left(credit_card_details):
    length = len(credit_card_details)
    total = 0;

    for index in range(length - 1, -1, -2):
        number = int(credit_card_details[index])

        total += number

    return total

def get_credit_card_validity(credit_card_details):
    length = len(credit_card_details)

    if length < 13 or length > 16:
        return False

    if get_credit_card_type(credit_card_details) == "Invalid Card":
        return False

    total = get_sum_second_digit_from_right_to_left(credit_card_details) + get_sum_second_digit_in_odd_places_from_right_to_left(credit_card_details)

    return total % 10 == 0
