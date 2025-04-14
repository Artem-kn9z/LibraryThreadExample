import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public synchronized Optional<Book> findAvaiableBook(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title) && b.isAvailable())
                .findFirst();
    }

    public synchronized void showAllBooks() {
        books.forEach(System.out::println);
    }
}
