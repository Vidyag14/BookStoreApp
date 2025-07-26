CREATE DATABASE bookstore;

USE bookstore;

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    name VARCHAR(100),
    author VARCHAR(100),
    price DECIMAL(10,2),
    status ENUM('available', 'issued', 'rented') DEFAULT 'available'
);

CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    user_id INT,
    type ENUM('issue', 'return', 'rent'),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
