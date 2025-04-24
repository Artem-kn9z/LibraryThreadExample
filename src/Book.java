public class Book {
    String title;
    private boolean isAvailable = true;

    public Book(String title) {
        this.title = title;
    }
    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    public boolean isAvailable() { return isAvailable; }

    public synchronized void borrow(String userName) {
        while (!isAvailable) {
            try {
                System.out.println(userName + " ждёт книгу " + title);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        //Книга доступна - можно взять
        isAvailable = false;
        System.out.println(userName + " взял книгу: " + title);
    }

    public synchronized void returnBook(String userName) {
        isAvailable = true;
        System.out.println(userName + " вернул книгу: " + title);

        notifyAll();
    }

    public void read(String userName) {
        try {
            int readingTime = 2000;
            System.out.println(userName + " читает книгу: " + title + " (" + readingTime + " ms)");
            Thread.sleep(readingTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return title + (isAvailable ? " (доступна)" : "(занята)");
    }
}
