public class Student extends User {
    private String department;
    private static final int MAX_BORROW_LIMIT = 3;

    public Student(String userId, String name, String department) {
        super(userId, name);
        this.department = department;
    }

    @Override
    public void borrowBook(Book book) throws BookNotAvailableException {
        if (borrowedBooks.size() >= MAX_BORROW_LIMIT) {
            throw new BookNotAvailableException("Student borrow limit exceeded. Maximum " + MAX_BORROW_LIMIT + " books allowed");
        }
        book.borrow();
        borrowedBooks.add(book);
        System.out.println("Book borrowed successfully: " + book.getTitle());
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + userId + ", Name: " + name + ", Department: " + department);
    }
}