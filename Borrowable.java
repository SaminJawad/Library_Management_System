public interface Borrowable {
    void borrowBook(Book book) throws BookNotAvailableException;
}