class BookSuggestionSystem {
    constructor() {
        this.myBooks = [];
    }

    getBookCount() {
        return this.myBooks.length;
    }

    suggestBook() {
        if (this.getBookCount() == 0) {
            throw new Error("No books available!!!");
        }

        const bookIndex = Math.floor(Math.random() * this.getBookCount());
        const pageNumber = Math.floor(Math.random() * 100) + 1;

        return `Book Title: ${this.myBooks[bookIndex]}\nPage: ${pageNumber}`;
    }

    addBook(bookTitle) {
        if (!this.myBooks.includes(bookTitle))
            this.myBooks.push(bookTitle);
        else
            throw new Error("Book already exists!!!");
    }

    removeBook(bookTitle) {
        const bookIndex = this.myBooks.indexOf(bookTitle);

        if (bookIndex == -1)
            throw new Error("Book does not exist!!!");

        this.myBooks.splice(bookIndex, 1);
    }

    updateBook(oldBookTitle, newBookTitle) {
        const bookIndex = this.myBooks.indexOf(oldBookTitle);

        if (bookIndex == -1)
            throw new Error("Book does not exist!!!");

        this.myBooks[bookIndex] = newBookTitle;
    }

    getBookList() {
        return [...this.myBooks];
    }
}

module.exports = BookSuggestionSystem;