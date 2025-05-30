# Project Name: Library Management System

# 1 Overview 

***1.1 Objective:*** <br>
Design and implement a simple Java-based library management system that:<br>
• Stores data from Excel files (books, students, teachers)<br>
• Allows users (students and teachers) to borrow and return books<br>
• Demonstrates core OOP concepts and exception handling<br>

***1.2 Core Java Concepts to Cover*** <br>
• Class & Object<br>
• Constructor (default & parameterized)<br>
• Method overloading & overriding<br>
• Inheritance & polymorphism<br>
• Abstract class & interface<br>
• Exception handling (custom & built-in)<br>
• File reading (Excel/CSV)<br>
• Collection framework (ArrayList, HashMap, etc.)<br>

# 2. Class Overview

***2.1. Book*** <br>
• Fields: bookId, title, author, availableCopies<br>
• Constructors: overloaded<br>
• Methods: displayInfo(), borrow(), returnBook()<br>

***2.2. User (Abstract Class)*** <br>
• Fields: userId, name, borrowedBooks (List)<br>
• Constructor: parameterized<br>
• Methods:<br>
o abstract void borrowBook(Book book)<br>
o void returnBook(Book book)<br>
o void viewBorrowedBooks() <br>

***2.3. Student & Teacher (Subclasses of User)*** <br>
• Additional Fields:<br>
o Student: department<br>
o Teacher: designation<br>
• Override borrowBook(Book book) with different max borrow limits<br>
• Demonstrates inheritance + method overriding <br>

***2.4. Library*** <br>
• Fields: bookList (List of Book)<br>
• Methods:<br>
o loadBooksFromExcel(String filePath)<br>
o getBookById(String id)<br>
o displayAvailableBooks()<br>

***2.5. UserManager*** <br>
• Fields: userList (Students & Teachers)<br>
• Methods:<br>
o loadUsersFromExcel(String filePath, String userType)<br>
o getUserById(String id)<br>
o authenticateUser(String id)<br>
o displayAllUsers() <br>

***2.6. Borrowable (Interface)*** <br>
• Method: void borrowBook(Book book);<br>
• Both Student and Teacher implement this interface<br>

# 3. File Handling

***3.1 Excel Files:*** <br>
• books.xlsx: Columns: Book ID, Title, Author, Copies<br>
• students.xlsx: Columns: Student ID, Name, Department<br>
• teachers.xlsx: Columns: Teacher ID, Name, Designation<br>

# 4. Exception Handling

***Introduce and use:*** <br>
• Custom exception: BookNotAvailableException, UserNotFoundException<br>
• Built-in exceptions: IOException, NullPointerException<br>

***[ This is my university project for the course **CSE 110: Object-Oriented Programming (OOP)** . The goal of this project is to design and implement a basic **Library Management System** using core **Java OOP principles**, file handling, and exception handling. ]***
