public class Book {
    private String bookId;
    private String title;
    private String author;
    private int availableCopies;

    public Book() {
        this.bookId = "";
        this.title = "";
        this.author = "";
        this.availableCopies = 0;
    }

    public Book(String bookId, String title, String author, int availableCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public void displayInfo() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + availableCopies);
    }

    public void borrow() throws BookNotAvailableException {
        if (availableCopies <= 0) {
            throw new BookNotAvailableException("Book " + title + " is not available");
        }
        availableCopies--;
    }

    public void returnBook() {
        availableCopies++;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}