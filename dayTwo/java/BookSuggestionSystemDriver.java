import java.util.List;
import java.util.Scanner;

public class BookSuggestionSystemDriver {

    public static void main(String[] args) {

        Scanner inputCollector = new Scanner(System.in);
        BookSuggestionSystem bookSuggestionSystem = new BookSuggestionSystem();
        boolean keepSuggesting = true;

        while (keepSuggesting) {

            System.out.print(
                """
                Welcome to the Book Suggestion System!
                1. Get Suggestions
                2. Add Book
                3. Remove Book
                4. Update book
                5. Show books
                """
            );
            System.out.print("Enter operation: ");
            int operation = inputCollector.nextInt();
            inputCollector.nextLine();

            System.out.println();
            switch (operation) {
                case 1:
                    String option = "";

                    try {
                        do {
                            String bookRecommendation = bookSuggestionSystem.suggestBook();
                            System.out.println(bookRecommendation);

                            System.out.print("Would you like to get another suggestion? (yes/no): ");
                            option = inputCollector.nextLine();
                            if (option.trim().equalsIgnoreCase("yes"))
                                System.out.println("");

                        } while(option.trim().equalsIgnoreCase("yes"));
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter the book title: ");
                        String bookTitle = inputCollector.nextLine();

                        bookSuggestionSystem.addBook(bookTitle);
                        System.out.println("Book added successfully!");
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter the book title: ");
                        String bookTitle = inputCollector.nextLine();

                        bookSuggestionSystem.removeBook(bookTitle);
                        System.out.println("Book removed successfully!");
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter old book title: ");
                        String oldBookTitle = inputCollector.nextLine();
                        System.out.print("Enter new book title: ");
                        String newBookTitle = inputCollector.nextLine();

                        bookSuggestionSystem.updateBook(oldBookTitle, newBookTitle);
                        System.out.println("Book updated successfully!");
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    List<String> bookList = bookSuggestionSystem.getBookList();
                    System.out.println("All Books");
                    if (bookList.size() == 0) {
                        System.out.println("Nothing to see here yet!");
                        break;
                    }

                    int index = 1;
                    for (String book : bookList) {
                        System.out.printf("%d. %s%n", index, book);
                        index++;
                    }

                    break;
                default:
                    System.out.println("Invalid operation!!!");
            }
            System.out.println();
        }
    }
}