# Project Name: Library Management System

# 1 Overview 

***1.1 Objective:*** </n>
Design and implement a simple Java-based library management system that:/n
• Stores data from Excel files (books, students, teachers)/n
• Allows users (students and teachers) to borrow and return books/n
• Demonstrates core OOP concepts and exception handling/n

***1.2 Core Java Concepts to Cover***/n
• Class & Object/n
• Constructor (default & parameterized)/n
• Method overloading & overriding/n
• Inheritance & polymorphism/n
• Abstract class & interface/n
• Exception handling (custom & built-in)/n
• File reading (Excel/CSV)/n
• Collection framework (ArrayList, HashMap, etc.)/n

# 2. Class Overview

***2.1. Book***/n
• Fields: bookId, title, author, availableCopies/n
• Constructors: overloaded/n
• Methods: displayInfo(), borrow(), returnBook()/n

***2.2. User (Abstract Class)***/n
• Fields: userId, name, borrowedBooks (List)/n
• Constructor: parameterized/n
• Methods:/n
o abstract void borrowBook(Book book)/n
o void returnBook(Book book)/n
o void viewBorrowedBooks() /n

***2.3. Student & Teacher (Subclasses of User)***/n
• Additional Fields:/n
o Student: department/n
o Teacher: designation/n
• Override borrowBook(Book book) with different max borrow limits/n
• Demonstrates inheritance + method overriding /n

***2.4. Library***/n
• Fields: bookList (List of Book)/n
• Methods:/n
o loadBooksFromExcel(String filePath)/n
o getBookById(String id)/n
o displayAvailableBooks()/n

***2.5. UserManager***/n
• Fields: userList (Students & Teachers)/n
• Methods:/n
o loadUsersFromExcel(String filePath, String userType)/n
o getUserById(String id)/n
o authenticateUser(String id)/n
o displayAllUsers() /n

***2.6. Borrowable (Interface)***/n
• Method: void borrowBook(Book book);/n
• Both Student and Teacher implement this interface/n

# 3. File Handling

***3.1 Excel Files:***/n
• books.xlsx: Columns: Book ID, Title, Author, Copies/n
• students.xlsx: Columns: Student ID, Name, Department/n
• teachers.xlsx: Columns: Teacher ID, Name, Designation/n

# 4. Exception Handling

***Introduce and use:***/n
• Custom exception: BookNotAvailableException, UserNotFoundException/n
• Built-in exceptions: IOException, NullPointerException/n/n

***[ This is my university project for the course **CSE 110: Object-Oriented Programming (OOP)** . The goal of this project is to design and implement a basic **Library Management System** using core **Java OOP principles**, file handling, and exception handling. ]***
