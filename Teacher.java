public class Teacher extends User {
    private String designation;
    private static final int MAX_BORROW_LIMIT = 5;

    public Teacher(String userId, String name, String designation) {
        super(userId, name);
        this.designation = designation;
    }

    @Override
    public void borrowBook(Book book) throws BookNotAvailableException {
        if (borrowedBooks.size() >= MAX_BORROW_LIMIT) {
            throw new BookNotAvailableException("Teacher borrow limit exceeded. Maximum " + MAX_BORROW_LIMIT + " books allowed");
        }
        book.borrow();
        borrowedBooks.add(book);
        System.out.println("Book borrowed successfully: " + book.getTitle());
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void displayInfo() {
        System.out.println("Teacher ID: " + userId + ", Name: " + name + ", Designation: " + designation);
    }
}