from unittest import TestCase

from split_array import split_even_odd

class TestSplitArray(TestCase):

    def test_that_I_pass_a_list_it_returns_a_list_of_even_and_odd_list(self):

        array = [45, 60, 3, 10, 9, 22]

        expected = [[45, 3 , 9] , [60 , 10, 22]]

        actual = split_even_odd(array)

        self.assertListEqual(expected, actual)


    def test_that_I_pass_a_list_of_odd_numbers_it_returns_a_list_of_empty_even_and_odd_list(self):

        array = [45, 61, 3, 11, 9, 23]

        expected = [[45, 61, 3, 11, 9, 23] , []]

        actual = split_even_odd(array)

        self.assertListEqual(expected, actual)


    def test_that_I_pass_a_list_of_even_numbers_it_returns_a_list_of_even_and_empty_odd_list(self):

        array = [46, 60, 4, 10, 12, 22]

        expected = [[] , [46, 60, 4, 10, 12, 22]]

        actual = split_even_odd(array)

        self.assertListEqual(expected, actual)