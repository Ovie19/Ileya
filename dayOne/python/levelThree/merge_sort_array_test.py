from unittest import TestCase

from merge_sort_array import merge_sort

class TestMergeSortArray(TestCase):

    def test_that_I_pass_two_list_it_returns_a_list_with_all_elements_sorted(self):

        listOne = [3, 5, 1]
        listTwo = [2, 4, 6]

        expected = [1, 2, 3, 4, 5, 6]
        actual = merge_sort(listOne, listTwo)

        self.assertListEqual(expected, actual)


    def test_that_I_pass_two_list_with_positive_and_negative_it_returns_a_list_with_all_elements_sorted(self):

        listOne = [-3, 5, -1]
        listTwo = [-2, 0, 6]

        expected = [-3, -2, -1, 0, 5, 6]
        actual = merge_sort(listOne, listTwo)

        self.assertListEqual(expected, actual)