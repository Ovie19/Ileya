from unittest import TestCase

from palindrome_array import is_palindrome

class TestPalindromeArray(TestCase):

    def test_that_I_pass_an_array_it_returns_true_if_array_is_a_a_palindrome(self):

        array = [45, 0, 8, 0, 45 ]
        self.assertTrue(is_palindrome(array))

        array = [3, 2, 1, 2, 3]
        self.assertTrue(is_palindrome(array))

        array = [4, 5, 6, 5, 4]
        self.assertTrue(is_palindrome(array))
