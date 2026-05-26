from unittest import TestCase

from two_sum import get_two_sum

class TestTwoSum(TestCase):

    def test_that_get_two_sum_returns_an_array_of_index_of_numbers_that_equals_the_sum_of_the_target(self):

        numbers = [8, 4, -2, 7, 1]

        target = 6

        expected = get_two_sum(numbers, target)

        actual = [0, 2]

        self.assertListEqual(actual, expected)

    def test_that_get_two_sum_returns_an_array_of_index_of_numbers_of_the_first_occurrence_that_equals_the_sum_of_the_target(self):

        numbers = [2, 6, 2, -2, 9, 4, 7, 1]

        target = 10

        expected = get_two_sum(numbers, target)

        actual = [1, 5]

        self.assertListEqual(actual, expected)