from unittest import TestCase

from flatten_array import *

class TestFlattenArray(TestCase):

    def test_that_I_pass_a_list_in_a_list_it_returns_the_total_number_of_elements_present(self):

        array = [[9, 0, 7], [3, 5, 1], [8, 1, 7], [9, 9, 6]]

        expected =  12

        actual = get_total_element_count(array)

        self.assertEqual(expected, actual)


        array = [[9, 7], [3, 5, 1], [8, 1, 7], [9, 6]]

        expected =  10

        actual = get_total_element_count(array)

        self.assertEqual(expected, actual)



    def test_that_I_pass_a_list_in_a_list_it_returns_a_list_with_all_elements_present(self):

        array = [[9, 0, 7], [3, 5, 1], [8, 1, 7], [9, 9, 6]]

        expected =  [9, 0, 7, 3, 5, 1, 8, 1, 7, 9, 9, 6]

        actual = flatten(array)

        self.assertListEqual(expected, actual)



        array = [[9, 7], [3, 5, 1], [8, 1, 7], [9, 6]]

        expected =  [9, 7, 3, 5, 1, 8, 1, 7, 9, 6]

        actual = flatten(array)

        self.assertListEqual(expected, actual)
