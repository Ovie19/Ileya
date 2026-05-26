import java.util.ArrayList;
import java.util.List;


public class BookSuggestionSystem {
    List<String> myBooks = new ArrayList<>();
    int bookCount = 0;

    public int getBookCount() {
        return bookCount;
    }

    public String suggestBook() {
        int bookIndex = (int) (Math.random() * bookCount);
        int pageNumber = (int) (Math.random() * 100) + 1;

        String recommendedBook = myBooks.get(bookIndex);

        return String.format("Book Title: %s\nPage: %d", recommendedBook, pageNumber);
    }

    public void addBook(String bookTitle) {
        if (!myBooks.contains(bookTitle)) {
            myBooks.add(bookTitle);
            bookCount++;
        }
        else
            throw new IllegalArgumentException("Book already exists!!!");
   }

    public void removeBook(String bookTitle) {
        boolean result = myBooks.remove(bookTitle);

        if (result)
            bookCount--;
        else
            throw new IllegalArgumentException("Book does not exist!!!");
    }

    public void updateBook(String oldBookTitle, String newBookTitle) {
        int index = myBooks.indexOf(oldBookTitle);

        if (index == -1)
            throw new IllegalArgumentException("Book does not exist!!!");

        myBooks.set(index, newBookTitle);
    }

    public List<String> getBookList() {
        return List.copyOf(myBooks);
    }
}