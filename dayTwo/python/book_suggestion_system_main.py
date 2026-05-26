from book_suggestion_system import BookSuggestionSystem

book_suggestion_system = BookSuggestionSystem()

while True:

    print("""Welcome to the Book Suggestion System!
1. Get Suggestions
2. Add Book
3. Remove Book
4. Update Book
5. Show Books""")

    operation = int(input("Enter operation: "))

    print()

    match operation:

        case 1:
            option = ""

            try:
                while True:

                    book_recommendation = book_suggestion_system.suggest_book()
                    print(book_recommendation)

                    option = input("Would you like to get another suggestion? (yes/no): ")

                    if option.strip().lower() != "yes":
                        break

                    print()

            except Exception as e:
                print(e)

        case 2:
            try:
                book_title = input("Enter the book title: ")

                book_suggestion_system.add_book(book_title)

                print("Book added successfully!")

            except Exception as e:
                print(e)

        case 3:
            try:
                book_title = input("Enter the book title: ")

                book_suggestion_system.remove_book(book_title)

                print("Book removed successfully!")

            except Exception as e:
                print(e)

        case 4:
            try:
                old_book_title = input("Enter old book title: ")
                new_book_title = input("Enter new book title: ")

                book_suggestion_system.update_book(
                    old_book_title,
                    new_book_title
                )
                print("Book updated successfully!")

            except Exception as e:
                print(e)

        case 5:
            book_list = book_suggestion_system.get_book_list()

            print("All Books")

            if len(book_list) == 0:
                print("Nothing to see here yet!")
            else:
                for index, book in enumerate(book_list):
                    print(f"{index + 1}. {book}")

        case _:
            print("Invalid operation!!!")

    print()