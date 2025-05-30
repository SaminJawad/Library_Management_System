import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;

    public Library() {
        this.bookList = new ArrayList<>();
    }

    public void loadBooksFromCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String bookId = data[0].trim();
                    String title = data[1].trim();
                    String author = data[2].trim();
                    int copies = Integer.parseInt(data[3].trim());

                    Book book = new Book(bookId, title, author, copies);
                    bookList.add(book);
                }
            }
        }
    }

    public Book getBookById(String id) {
        for (Book book : bookList) {
            if (book.getBookId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : bookList) {
            if (book.getAvailableCopies() > 0) {
                book.displayInfo();
            }
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }
}