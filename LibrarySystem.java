import java.io.IOException;
import java.util.Scanner;

public class LibrarySystem {
    private Library library;
    private UserManager userManager;
    private Scanner scanner;

    public LibrarySystem() {
        this.library = new Library();
        this.userManager = new UserManager();
        this.scanner = new Scanner(System.in);
    }

    public void initialize() {
        try {
            library.loadBooksFromCSV("books.xlsx.csv");
            userManager.loadUsersFromCSV("students.xlsx.csv", "student");
            userManager.loadUsersFromCSV("teachers.xlsx.csv", "teacher");
            System.out.println("Library system initialized successfully!");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    public void start() {
        initialize();

        System.out.println("Welcome to Library Management System");
        System.out.print("Enter your User ID: ");
        String userId = scanner.nextLine();

        try {
            User currentUser = userManager.getUserById(userId);
            System.out.println("Login successful! Welcome " + currentUser.getName());

            boolean running = true;
            while (running) {
                displayMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        library.displayAvailableBooks();
                        break;
                    case 2:
                        borrowBook(currentUser);
                        break;
                    case 3:
                        returnBook(currentUser);
                        break;
                    case 4:
                        currentUser.viewBorrowedBooks();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Thank you for using Library Management System!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. View Available Books");
        System.out.println("2. Borrow a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. View Borrowed Books");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void borrowBook(User user) {
        System.out.print("Enter Book ID to borrow: ");
        String bookId = scanner.nextLine();

        try {
            Book book = library.getBookById(bookId);
            if (book == null) {
                throw new BookNotAvailableException("Book with ID " + bookId + " not found");
            }
            user.borrowBook(book);
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void returnBook(User user) {
        if (user.getBorrowedBooks().isEmpty()) {
            System.out.println("You have no books to return.");
            return;
        }

        System.out.println("Your borrowed books:");
        for (int i = 0; i < user.getBorrowedBooks().size(); i++) {
            System.out.println((i + 1) + ". " + user.getBorrowedBooks().get(i).getTitle());
        }

        System.out.print("Enter book number to return: ");
        try {
            int bookIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (bookIndex >= 0 && bookIndex < user.getBorrowedBooks().size()) {
                Book book = user.getBorrowedBooks().get(bookIndex);
                user.returnBook(book);
            } else {
                System.out.println("Invalid book number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        boolean Hi= false;
        Scanner in = new Scanner(System.in);
        while(!Hi){
            system.start();
            System.out.println("Want to access anything else?\n   Enter yes / no");
            char a = in.next().charAt(0);
            if(a=='y'){
                System.out.println("Reloading the console.");
            }
            else{
                System.out.println("Thanks! Ending the console.");
                Hi=true;
            }
        }
    }
}