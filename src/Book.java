public class Book {
    String title;
    private boolean isAvailable = true;

    public Book(String title) {
        this.title = title;
    }
    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    public boolean isAvailable() { return isAvailable; }

    public synchronized boolean borrow() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public synchronized void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return title + (isAvailable ? " (доступна)" : "(занята)");
    }
}
