from unittest import TestCase
from credit_card_validator import *

class TestCreditCardValidator(TestCase):

    def test_that_I_input_a_mastercard_credit_card_it_returns_MasterCard(self):

        credit_card_details  = "5399831619690403"

        expected = get_credit_card_type(credit_card_details)
        actual = "MasterCard"

        self.assertEqual(actual, expected)


    def test_that_I_input_any_credit_card_it_returns_correct_type(self):

        credit_card_details  = "5399831619690403"
        expected = get_credit_card_type(credit_card_details)
        actual = "MasterCard"
        self.assertEqual(actual, expected)


        credit_card_details  = "4299831619690403"
        expected = get_credit_card_type(credit_card_details)
        actual = "Visa Cards"
        self.assertEqual(actual, expected)


        credit_card_details  = "3799831619690403"
        expected = get_credit_card_type(credit_card_details)
        actual = "American Express Cards"
        self.assertEqual(actual, expected)


        credit_card_details  = "6199831619690403"
        expected = get_credit_card_type(credit_card_details)
        actual = "Discover Cards"
        self.assertEqual(actual, expected)


    def test_that_I_input_invalid_credit_card_it_returns_invalid_card(self):
        credit_card_details  = "2399831619690403"

        expected = get_credit_card_type(credit_card_details)
        actual = "Invalid Card"

        self.assertEqual(actual, expected)


    def test_that_GetSumSecondDigitFromRightToLeft_returns_right_value(self):
        credit_card_details  = "4388576018402626"

        expected = get_sum_second_digit_from_right_to_left(credit_card_details)
        actual = 37

        self.assertEqual(actual, expected)


    def test_that_GetSumSumDigitInOddPlacesFromRightToLeft_returns_right_value(self):
        credit_card_details  = "4388576018402626"

        expected = get_sum_second_digit_in_odd_places_from_right_to_left(credit_card_details)
        actual = 38

        self.assertEqual(actual, expected)


    def test_that_I_input_any_credit_card_it_returns_correct_validity(self):
        credit_card_details  = "4388576018402626"
        self.assertFalse(get_credit_card_validity(credit_card_details))

        credit_card_details  = "4388576018410707"
        self.assertTrue(get_credit_card_validity(credit_card_details))

        credit_card_details  = "5399831619690404"
        self.assertFalse(get_credit_card_validity(credit_card_details))

        credit_card_details  = "5399831619690403"
        self.assertTrue(get_credit_card_validity(credit_card_details))

        credit_card_details  = "234319283049582"
        self.assertFalse(get_credit_card_validity(credit_card_details))
