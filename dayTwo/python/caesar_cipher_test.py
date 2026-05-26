from unittest import TestCase

from caesar_cipher import *


class TestCaesarCipher(TestCase):

    def test_get_encrypted_cipher_value(self):

        character = 'C'
        expected = 'F'
        actual = get_encrypted_cipher_value(character, 3)
        self.assertEqual(expected, actual)

        character = 'o'
        expected = 'x'
        actual = get_encrypted_cipher_value(character, 9)
        self.assertEqual(expected, actual)

        character = 'Y'
        expected = 'I'
        actual = get_encrypted_cipher_value(character, 10)
        self.assertEqual(expected, actual)

        character = 'v'
        expected = 'e'
        actual = get_encrypted_cipher_value(character, 9)
        self.assertEqual(expected, actual)

    def test_get_decrypted_cipher_value(self):

        character = 'F'
        expected = 'C'
        actual = get_decrypted_cipher_value(character, 3)
        self.assertEqual(expected, actual)

        character = 'x'
        expected = 'o'
        actual = get_decrypted_cipher_value(character, 9)
        self.assertEqual(expected, actual)

        character = 'I'
        expected = 'Y'
        actual = get_decrypted_cipher_value(character, 10)
        self.assertEqual(expected, actual)

        character = 'e'
        expected = 'v'
        actual = get_decrypted_cipher_value(character, 9)
        self.assertEqual(expected, actual)

    def test_get_encrypted_text_shift_3(self):

        message = "CALL ME TOMORROW"
        expected = "FDOO PH WRPRUURZ"
        actual = get_encrypted_text(message, 3)
        self.assertEqual(expected, actual)

        message = "Call me tomorrow"
        expected = "Fdoo ph wrpruurz"
        actual = get_encrypted_text(message, 3)
        self.assertEqual(expected, actual)

    def test_get_encrypted_text_shift_6(self):

        message = "CALL ME TOMORROW"
        expected = "IGRR SK ZUSUXXUC"
        actual = get_encrypted_text(message, 6)
        self.assertEqual(expected, actual)

        message = "Call me tomorrow"
        expected = "Igrr sk zusuxxuc"
        actual = get_encrypted_text(message, 6)
        self.assertEqual(expected, actual)

    def test_get_decrypted_text_shift_3(self):

        message = "FDOO PH WRPRUURZ"
        expected = "CALL ME TOMORROW"
        actual = get_decrypted_text(message, 3)
        self.assertEqual(expected, actual)

        message = "Fdoo ph wrpruurz"
        expected = "Call me tomorrow"
        actual = get_decrypted_text(message, 3)
        self.assertEqual(expected, actual)

    def test_get_decrypted_text_shift_6(self):

        message = "IGRR SK ZUSUXXUC"
        expected = "CALL ME TOMORROW"
        actual = get_decrypted_text(message, 6)
        self.assertEqual(expected, actual)

        message = "Igrr sk zusuxxuc"
        expected = "Call me tomorrow"
        actual = get_decrypted_text(message, 6)
        self.assertEqual(expected, actual)
