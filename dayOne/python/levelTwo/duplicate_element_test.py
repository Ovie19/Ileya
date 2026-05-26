from unittest import TestCase

from duplicate_element import *


class TestDuplicateElement(TestCase):

    def test_that_I_pass_a_list_it_returns_a_list_of_all_duplicate_numbers(self):

        array =  [1, 2, 3, 2, 4, 3]

        expected = [2, 3]

        actual = get_duplicate_element_list(array)

        self.assertListEqual(expected, actual)


    def test_that_I_pass_a_list_it_returns_empty_list_if_no_duplicate_numbers(self):

        array =  [1, 2, 3, 4, 5, 6]

        actual = get_duplicate_element_list(array)

        self.assertListEqual([], actual)