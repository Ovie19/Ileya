from unittest import TestCase

from encoded_string import get_encoded_string

class TestEncodedString(TestCase):

    def test_that_I_pass_a_string_it_returns_an_encoded_string_with_character_and_successive_count(self):

        string = "aaabbc"

        expected = "a3b2c"

        actual = get_encoded_string(string)

        self.assertEqual(expected, actual)


        string = "aabccaa"

        expected = "a2bc2a2"

        actual = get_encoded_string(string)

        self.assertEqual(expected, actual)