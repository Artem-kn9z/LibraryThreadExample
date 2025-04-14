import java.util.Optional;

public class UserThread extends Thread {
    private String bookTitle;
    private Library library;

    public UserThread(String bookTitle, Library library) {
        this.bookTitle = bookTitle;
        this.library = library;
    }

    public void run() {
        Optional<Book> book = library.findAvaiableBook(bookTitle);
        if (book.isPresent()) {
            if (book.get().borrow()) {
                System.out.println(Thread.currentThread().getName() + " взял книгу: " + book.get().getTitle());
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                book.get().returnBook();
                System.out.println(Thread.currentThread().getName() + " вернул книгу: " + book.get().getTitle());
            }
            else {
                System.out.println(Thread.currentThread().getName() + " не смог взять книгу: " + book.get().getTitle());
            }
        }
        else {
            System.out.println(Thread.currentThread().getName() + ": Книга не найдена или занята");
        }
    }

}
