from unittest import TestCase

from vowel_consonants_counter import *

class TestVowelConsonantsCounter(TestCase):

    def test_that_isVowel_returns_true_if_character_is_a_vowel(self):
        self.assertTrue(is_vowel("a"))
        self.assertTrue(is_vowel("e"))
        self.assertTrue(is_vowel("i"))
        self.assertTrue(is_vowel("o"))
        self.assertTrue(is_vowel("u"))

    def test_that_isVowel_returns_false_if_character_is_not_a_vowel(self):
        self.assertFalse(is_vowel("q"))
        self.assertFalse(is_vowel("s"))
        self.assertFalse(is_vowel("c"))
        self.assertFalse(is_vowel("v"))
        self.assertFalse(is_vowel("p"))

    def test_that_i_pass_a_list_it_returns_a_list_of_list_with_vowels_consonants_and_their_count(self):

        word = "Hello - world"

        expected = [["vowels", 3], ["consonants", 7]]

        actual = get_vowel_consonants_count(word)

        self.assertListEqual(expected, actual)


        word = "Barcelona"

        expected = [["vowels", 4], ["consonants", 5]]

        actual = get_vowel_consonants_count(word)

        self.assertListEqual(expected, actual)