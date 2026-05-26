import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class BookSuggestionSystemTest {
    BookSuggestionSystem bookSuggestionSystem;

    @BeforeEach
    void setUp() {
        bookSuggestionSystem = new BookSuggestionSystem();
    }

    @Test
    public void testThatBookCountIsInitiallyZero() {
        assertEquals(0, bookSuggestionSystem.getBookCount());
    }

    @Test
    public void testThatAddBookPutsTheBookInTheListAndIncreasesBookCountBy1() {

        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book I");
        assertEquals(1, bookSuggestionSystem.getBookCount());

        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book II");
        assertEquals(2, bookSuggestionSystem.getBookCount());

        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book III");
        assertEquals(3, bookSuggestionSystem.getBookCount());
    }

    @Test
    public void testThatAddBookThrowsErrorIfTheBookIsAlreadyInTheList() {
        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book I");
        assertEquals(1, bookSuggestionSystem.getBookCount());

        assertThrows(
            IllegalArgumentException.class,
            ()-> bookSuggestionSystem.addBook("Avatar: The Last Airbender Book I")
        );
        assertEquals(1, bookSuggestionSystem.getBookCount());
    }

    @Test
    public void testThatRemoveBookRemovesTheBookInTheListAndReducesBookCountBy1() {

        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book I");
        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book II");
        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book III");
        assertEquals(3, bookSuggestionSystem.getBookCount());

        bookSuggestionSystem.removeBook("Avatar: The Last Airbender Book I");
        assertEquals(2, bookSuggestionSystem.getBookCount());

        bookSuggestionSystem.removeBook("Avatar: The Last Airbender Book II");
        assertEquals(1, bookSuggestionSystem.getBookCount());

        bookSuggestionSystem.removeBook("Avatar: The Last Airbender Book III");
        assertEquals(0, bookSuggestionSystem.getBookCount());
    }

    @Test
    public void testThatRemoveBookThrowsErrorIfTheBookIsNotInTheList() {
        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book I");
        assertEquals(1, bookSuggestionSystem.getBookCount());

        bookSuggestionSystem.removeBook("Avatar: The Last Airbender Book I");
        assertEquals(0, bookSuggestionSystem.getBookCount());

        assertThrows(
            IllegalArgumentException.class,
            ()-> bookSuggestionSystem.removeBook("Avatar: The Last Airbender Book I")
        );
        assertEquals(0, bookSuggestionSystem.getBookCount());
    }

    @Test
    public void testThatGetBookListReturnsListOfAllTheBooks() {

        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book I");
        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book II");
        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book III");

        List<String> expected = List.of(
            "Avatar: The Last Airbender Book I",
            "Avatar: The Last Airbender Book II",
            "Avatar: The Last Airbender Book III"
        );
        List<String> actual = bookSuggestionSystem.getBookList();
        assertEquals(expected, actual);

        bookSuggestionSystem.removeBook("Avatar: The Last Airbender Book I");
        bookSuggestionSystem.removeBook("Avatar: The Last Airbender Book II");
        bookSuggestionSystem.removeBook("Avatar: The Last Airbender Book III");

        expected = new ArrayList<String>();
        actual = bookSuggestionSystem.getBookList();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatUpdateBookUpdateThatParticularBookInTheList() {

        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book I");
        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book II");

        List<String> expected = List.of(
            "Avatar: The Last Airbender Book I",
            "Avatar: The Last Airbender Book II"
        );
        List<String> actual = bookSuggestionSystem.getBookList();
        assertEquals(expected, actual);

        bookSuggestionSystem.updateBook(
            "Avatar: The Last Airbender Book I",
            "Avatar: The Legend of Korra Book I"
        );
        expected = List.of(
            "Avatar: The Legend of Korra Book I",
            "Avatar: The Last Airbender Book II"
        );
        actual = bookSuggestionSystem.getBookList();
        assertEquals(expected, actual);

        bookSuggestionSystem.updateBook(
            "Avatar: The Last Airbender Book II",
            "Avatar: The Legend of Korra Book II"
        );
        expected = List.of(
            "Avatar: The Legend of Korra Book I",
            "Avatar: The Legend of Korra Book II"
        );
        actual = bookSuggestionSystem.getBookList();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatUpdateBookThrowsErrorIfTheBookIsNotInTheList() {
        bookSuggestionSystem.addBook("Avatar: The Last Airbender Book I");
        bookSuggestionSystem.updateBook(
            "Avatar: The Last Airbender Book I",
            "Avatar: The Legend of Korra Book I"
        );

        assertThrows(
            IllegalArgumentException.class,
            ()-> bookSuggestionSystem.updateBook(
                "Avatar: The Last Airbender Book I",
                "Avatar: The Legend of Korra Book II"
            )
        );
    }
}