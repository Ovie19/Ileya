def get_encrypted_cipher_value(character, shift_value):
    ascii_value = ord(character)
    new_character_ascii_value = ascii_value + shift_value

    if character.isupper() and new_character_ascii_value > 90:
        remainder = new_character_ascii_value - 90
        new_character_ascii_value = 65 + remainder - 1

    if character.islower() and new_character_ascii_value > 122:
        remainder = new_character_ascii_value - 122
        new_character_ascii_value = 97 + remainder - 1

    return chr(new_character_ascii_value)


def get_decrypted_cipher_value(character, shift_value):
    ascii_value = ord(character)
    new_character_ascii_value = ascii_value - shift_value

    if character.isupper() and new_character_ascii_value < 65:
        remainder = 65 - new_character_ascii_value
        new_character_ascii_value = 90 - remainder + 1

    if character.islower() and new_character_ascii_value < 97:
        remainder = 97 - new_character_ascii_value
        new_character_ascii_value = 122 - remainder + 1

    return chr(new_character_ascii_value)


def get_encrypted_text(message, shift_value):
    encrypted_message = ""

    for character in message:
        if character.isalpha():
            encrypted_message += get_encrypted_cipher_value(character, shift_value)
        else:
            encrypted_message += character

    return encrypted_message


def get_decrypted_text(message, shift_value):
    decrypted_message = ""

    for character in message:
        if character.isalpha():
            decrypted_message += get_decrypted_cipher_value(character, shift_value)
        else:
            decrypted_message += character

    return decrypted_message
