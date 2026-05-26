from unittest import TestCase
from book_suggestion_system import BookSuggestionSystem


class TestBookSuggestionSystem(TestCase):

    def setUp(self):
        self.book_suggestion_system = BookSuggestionSystem()

    def test_book_count_is_initially_zero(self):
        self.assertEqual(0, self.book_suggestion_system.get_book_count())

    def test_I_add_book_it_increases_book_count_by_1(self):

        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book I"
        )
        self.assertEqual(1, self.book_suggestion_system.get_book_count())

        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book II"
        )
        self.assertEqual(2, self.book_suggestion_system.get_book_count())

        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book III"
        )
        self.assertEqual(3, self.book_suggestion_system.get_book_count())

    def test_I_add_book_it_throws_error_if_book_exists(self):

        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book I"
        )
        self.assertEqual(1, self.book_suggestion_system.get_book_count())

        self.assertRaises(
            ValueError,
            self.book_suggestion_system.add_book,
            "Avatar: The Last Airbender Book I"
        )
        self.assertEqual(1, self.book_suggestion_system.get_book_count())

    def test_I_remove_book_it_reduces_book_count_by_1(self):

        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book I"
        )
        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book II"
        )
        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book III"
        )

        self.assertEqual(3, self.book_suggestion_system.get_book_count())

        self.book_suggestion_system.remove_book(
            "Avatar: The Last Airbender Book I"
        )
        self.assertEqual(2, self.book_suggestion_system.get_book_count())

        self.book_suggestion_system.remove_book(
            "Avatar: The Last Airbender Book II"
        )
        self.assertEqual(1, self.book_suggestion_system.get_book_count())

        self.book_suggestion_system.remove_book(
            "Avatar: The Last Airbender Book III"
        )
        self.assertEqual(0, self.book_suggestion_system.get_book_count())

    def test_I_remove_book_throws_error_if_book_not_found(self):

        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book I"
        )
        self.assertEqual(1, self.book_suggestion_system.get_book_count())

        self.book_suggestion_system.remove_book(
            "Avatar: The Last Airbender Book I"
        )
        self.assertEqual(0, self.book_suggestion_system.get_book_count())

        self.assertRaises(
            ValueError,
            self.book_suggestion_system.remove_book,
            "Avatar: The Last Airbender Book I"
        )
        self.assertEqual(0, self.book_suggestion_system.get_book_count())

    def test_get_book_list_returns_all_books(self):

        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book I"
        )
        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book II"
        )
        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book III"
        )

        expected = [
            "Avatar: The Last Airbender Book I",
            "Avatar: The Last Airbender Book II",
            "Avatar: The Last Airbender Book III"
        ]

        actual = self.book_suggestion_system.get_book_list()

        self.assertEqual(expected, actual)

        self.book_suggestion_system.remove_book(
            "Avatar: The Last Airbender Book I"
        )
        self.book_suggestion_system.remove_book(
            "Avatar: The Last Airbender Book II"
        )
        self.book_suggestion_system.remove_book(
            "Avatar: The Last Airbender Book III"
        )

        expected = []
        actual = self.book_suggestion_system.get_book_list()

        self.assertEqual(expected, actual)

    def test_I_update_book_it_updates_the_particular_book(self):

        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book I"
        )
        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book II"
        )

        expected = [
            "Avatar: The Last Airbender Book I",
            "Avatar: The Last Airbender Book II"
        ]

        actual = self.book_suggestion_system.get_book_list()

        self.assertEqual(expected, actual)

        self.book_suggestion_system.update_book(
            "Avatar: The Last Airbender Book I",
            "Avatar: The Legend of Korra Book I"
        )

        expected = [
            "Avatar: The Legend of Korra Book I",
            "Avatar: The Last Airbender Book II"
        ]

        actual = self.book_suggestion_system.get_book_list()

        self.assertEqual(expected, actual)

        self.book_suggestion_system.update_book(
            "Avatar: The Last Airbender Book II",
            "Avatar: The Legend of Korra Book II"
        )

        expected = [
            "Avatar: The Legend of Korra Book I",
            "Avatar: The Legend of Korra Book II"
        ]

        actual = self.book_suggestion_system.get_book_list()

        self.assertEqual(expected, actual)

    def test_I_update_book_it_throws_error_if_book_not_found(self):

        self.book_suggestion_system.add_book(
            "Avatar: The Last Airbender Book I"
        )

        self.book_suggestion_system.update_book(
            "Avatar: The Last Airbender Book I",
            "Avatar: The Legend of Korra Book I"
        )

        self.assertRaises(
            ValueError,
            self.book_suggestion_system.update_book,
            "Avatar: The Last Airbender Book I",
            "Avatar: The Legend of Korra Book II"
        )
