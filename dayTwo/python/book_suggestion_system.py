import random

class BookSuggestionSystem:

    def __init__(self):
        self.my_books = []

    def get_book_count(self):
        return len(self.my_books)

    def suggest_book(self):
        book_count = len(self.my_books)
        if book_count == 0:
            raise ValueError("No books available!!!")

        book_index = random.randint(0, book_count - 1)
        page_number = random.randint(1, 100)

        recommended_book = self.my_books[book_index]

        return f"Book Title: {recommended_book}\nPage: {page_number}"

    def add_book(self, book_title):
        if book_title not in self.my_books:
            self.my_books.append(book_title)
        else:
            raise ValueError("Book already exists!!!")

    def remove_book(self, book_title):
        if book_title in self.my_books:
            self.my_books.remove(book_title)
        else:
            raise ValueError("Book does not exist!!!")

    def update_book(self, old_book_title, new_book_title):
        if old_book_title not in self.my_books:
            raise ValueError("Book does not exist!!!")

        index = self.my_books.index(old_book_title)
        self.my_books[index] = new_book_title

    def get_book_list(self):
        return self.my_books.copy()
