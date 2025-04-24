public class UserThread extends Thread {
    private String bookTitle;
    private Library library;

    public UserThread(String bookTitle, Library library, String name) {
        super(name);
        this.bookTitle = bookTitle;
        this.library = library;
    }

    @Override
    public void run() {
        Book book = library.findBook(bookTitle);

        if (book != null) {
            book.borrow(getName());
            book.read(getName());
            book.returnBook(getName());
        } else {
            System.out.println(getName() + ": Книга не найдена.");
        }
    }

}
