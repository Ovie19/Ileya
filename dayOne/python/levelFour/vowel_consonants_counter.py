vowels = "aeiou"

def is_vowel(character):
    if character in vowels:
        return True

    return False

def get_vowel_consonants_count(word):
    vowel_count = 0
    consonant_count = 0

    for character in word.lower():
        if character.isalpha():
            if is_vowel(character):
                vowel_count += 1
            else:
                consonant_count += 1

    return [["vowels", vowel_count], ["consonants", consonant_count]]