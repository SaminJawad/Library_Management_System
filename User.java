import java.util.ArrayList;
import java.util.List;

public abstract class User implements Borrowable {
    protected String userId;
    protected String name;
    protected List<Book> borrowedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public abstract void borrowBook(Book book) throws BookNotAvailableException;

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
            System.out.println("Book returned successfully: " + book.getTitle());
        } else {
            System.out.println("You haven't borrowed this book");
        }
    }

    public void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                book.displayInfo();
            }
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}