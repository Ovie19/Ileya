const BookSuggestionSystem = require('./bookSuggestionSystem');

let bookSuggestionSystem;

beforeEach(() => {
    bookSuggestionSystem = new BookSuggestionSystem();
});

test("book count initial value is zero", () => {
    expect(bookSuggestionSystem.getBookCount()).toBe(0);
});

test("I add book it increases book count by 1", () => {
    bookSuggestionSystem.addBook("Avatar Book I");
    expect(bookSuggestionSystem.getBookCount()).toBe(1);

    bookSuggestionSystem.addBook("Avatar Book II");
    expect(bookSuggestionSystem.getBookCount()).toBe(2);

    bookSuggestionSystem.addBook("Avatar Book III");
    expect(bookSuggestionSystem.getBookCount()).toBe(3);
});

test("I add book it throws error if book is already in list", () => {
    bookSuggestionSystem.addBook("Avatar Book I");

    expect(() => bookSuggestionSystem.addBook("Avatar Book I")).toThrow();
});


test("I remove book it reduces book count by 1", () => {
    bookSuggestionSystem.addBook("Avatar Book I");
    bookSuggestionSystem.addBook("Avatar Book II");
    bookSuggestionSystem.addBook("Avatar Book III");
    expect(bookSuggestionSystem.getBookCount()).toBe(3);

    bookSuggestionSystem.removeBook("Avatar Book I");
    expect(bookSuggestionSystem.getBookCount()).toBe(2);

    bookSuggestionSystem.removeBook("Avatar Book II");
    expect(bookSuggestionSystem.getBookCount()).toBe(1);

    bookSuggestionSystem.removeBook("Avatar Book III");
    expect(bookSuggestionSystem.getBookCount()).toBe(0);
});

test("I remove book it throws error if book is not in list", () => {
    bookSuggestionSystem.addBook("Avatar Book I");
    bookSuggestionSystem.removeBook("Avatar Book I");

    expect(() => bookSuggestionSystem.removeBook("Avatar Book I")).toThrow();
});

test("getBookList returns a list of all books", () => {
    bookSuggestionSystem.addBook("Avatar Book I");
    bookSuggestionSystem.addBook("Avatar Book II");
    bookSuggestionSystem.addBook("Avatar Book III");

    let expected = ["Avatar Book I","Avatar Book II", "Avatar Book III"];
    expect(bookSuggestionSystem.getBookList()).toEqual(expected)

    bookSuggestionSystem.removeBook("Avatar Book I");
    bookSuggestionSystem.removeBook("Avatar Book II");
    bookSuggestionSystem.removeBook("Avatar Book III");

    expect(bookSuggestionSystem.getBookList()).toEqual([])
});

test("I update book it changes book title in the list", () => {
    bookSuggestionSystem.addBook("Avatar Book I");
    bookSuggestionSystem.addBook("Avatar Book II");

    bookSuggestionSystem.updateBook(
        "Avatar Book I",
        "Avatar: Lengend of Korra I"
    );

    let expected = ["Avatar: Lengend of Korra I", "Avatar Book II"];
    expect(bookSuggestionSystem.getBookList()).toEqual(expected)

    bookSuggestionSystem.updateBook(
        "Avatar Book II",
        "Avatar: Lengend of Korra II"
    );

    expected = ["Avatar: Lengend of Korra I", "Avatar: Lengend of Korra II"];
    expect(bookSuggestionSystem.getBookList()).toEqual(expected)
});

test("I update book it throws error if book is not in list", () => {
    bookSuggestionSystem.addBook("Avatar Book I");
    bookSuggestionSystem.removeBook("Avatar Book I");

    expect(
        () => bookSuggestionSystem.updateBook(
            "Avatar Book I",
            "Avatar: Lengend of Korra I"
        )
    ).toThrow();
});