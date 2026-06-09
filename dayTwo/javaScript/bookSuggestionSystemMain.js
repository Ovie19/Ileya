const BookSuggestionSystem = require('./bookSuggestionSystem');

const prompt = require('prompt-sync')();

const bookSuggestionSystem = new BookSuggestionSystem();

let keepSuggesting = true;

while (keepSuggesting) {
    console.log(`Welcome to the Book Suggestion System!
1. Get Suggestions
2. Add Book
3. Remove Book
4. Update book
5. Show books`)
    let operation = Number(prompt("Enter operation: "))

    console.log()
    switch (operation) {
        case 1:
            let option = "";

            try {
                do {
                    let bookRecommendation = bookSuggestionSystem.suggestBook();
                    console.log(bookRecommendation);

                    option = prompt("Would you like to get another suggestion? (yes/no): ");
                    if (option.trim().toLowerCase() === "yes")
                        console.log("");

                } while(option.trim().toLowerCase() === "yes");
            } catch(error) {
                console.log(error.message);
            }
            break;
        case 2:
            try {
                let bookTitle = prompt("Enter the book title: ");
                bookSuggestionSystem.addBook(bookTitle);
                console.log("Book added successfully!");
            } catch(error) {
                console.log(error.message);
            }
            break;
        case 3:
            try {
                let bookTitle = prompt("Enter the book title: ");
                bookSuggestionSystem.removeBook(bookTitle);
                console.log("Book removed successfully!");
            } catch(error) {
                console.log(error.message);
            }
            break;
        case 4:
            try {
                let oldBookTitle = prompt("Enter old book title: ");
                let newBookTitle = prompt("Enter new book title: ");

                bookSuggestionSystem.updateBook(oldBookTitle, newBookTitle);
                console.log("Book updated successfully!");
            } catch(error) {
                console.log(error.message);
            }
            break;
        case 5:
            let bookList = bookSuggestionSystem.getBookList();
            console.log("All Books");

            if (bookList.length == 0) {
                console.log("Nothing to see here yet!");
                break;
            }

            let index = 1;
            for (let book of bookList) {
                console.log(`${index}. ${book}`);
                index++;
            }

            break;
        default:
            console.log("Invalid operation!!!");
    }

    console.log()
}