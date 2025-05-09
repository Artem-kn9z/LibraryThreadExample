import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(List.of(
                new Book("Java"),
                new Book("Python"),
                new Book("C++")
        ));

        Library library = new Library(books);

        // Несколько пользователей хотят одну и ту же книгу
        UserThread user1 = new UserThread("Java", library, "Пользователь 1");
        UserThread user2 = new UserThread("Java", library, "Пользователь 2");
        UserThread user3 = new UserThread("Python", library, "Пользователь 3");

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nФинальное состояние книг:");
        library.showAllBooks();
    }
}