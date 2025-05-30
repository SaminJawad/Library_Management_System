# Project Name: Library Management System

# 1 Overview 

# 1.1 Objective:
Design and implement a simple Java-based library management system that:
• Stores data from Excel files (books, students, teachers)
• Allows users (students and teachers) to borrow and return books
• Demonstrates core OOP concepts and exception handling

# 1.2 Core Java Concepts to Cover
• Class & Object
• Constructor (default & parameterized)
• Method overloading & overriding
• Inheritance & polymorphism
• Abstract class & interface
• Exception handling (custom & built-in)
• File reading (Excel)
• Collection framework (ArrayList, HashMap, etc.)

# 2. Class Overview

# 2.1. Book
• Fields: bookId, title, author, availableCopies
• Constructors: overloaded
• Methods: displayInfo(), borrow(), returnBook()

# 2.2. User (Abstract Class)
• Fields: userId, name, borrowedBooks (List)
• Constructor: parameterized
• Methods:
o abstract void borrowBook(Book book)
o void returnBook(Book book)
o void viewBorrowedBooks() /n

# 2.3. Student & Teacher (Subclasses of User)
• Additional Fields:
o Student: department
o Teacher: designation
• Override borrowBook(Book book) with different max borrow limits
• Demonstrates inheritance + method overriding /n

# 2.4. Library
• Fields: bookList (List of Book)
• Methods:
o loadBooksFromExcel(String filePath)
o getBookById(String id)
o displayAvailableBooks()

# 2.5. UserManager
• Fields: userList (Students & Teachers)
• Methods:
o loadUsersFromExcel(String filePath, String userType)
o getUserById(String id)
o authenticateUser(String id)
o displayAllUsers() /n

# 2.6. Borrowable (Interface)
• Method: void borrowBook(Book book);
• Both Student and Teacher implement this interface/n

# 3. File Handling

# 3.1 Excel Files:
• books.xlsx: Columns: Book ID, Title, Author, Copies
• students.xlsx: Columns: Student ID, Name, Department
• teachers.xlsx: Columns: Teacher ID, Name, Designation

# 4. Exception Handling

# Introduce and use:
• Custom exception: BookNotAvailableException, UserNotFoundException
• Built-in exceptions: IOException, NullPointerException

[ This is my university project for the course **CSE 110: Object-Oriented Programming (OOP)** . The goal of this project is to design and implement a basic **Library Management System** using core **Java OOP principles**, file handling, and exception handling. ]
