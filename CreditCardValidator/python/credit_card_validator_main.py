from credit_card_validator import *

credit_card_details = input("Hello, Kindly Enter Card details to verify\n")

credit_card_type = get_credit_card_type(credit_card_details)
credit_card_length = len(credit_card_details)
is_valid = get_credit_card_validity(credit_card_details)

print(f"""
Credit Card Type: {credit_card_type}
Credit Card Number: {credit_card_details}
Credit Card Digit Length: {credit_card_length}
Credit Card Validity Status: {"Valid" if is_valid else "Invalid"}
""")