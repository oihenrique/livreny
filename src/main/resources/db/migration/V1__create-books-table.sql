CREATE TABLE books (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    isbn VARCHAR(13),
    publisher VARCHAR(255),
    genre VARCHAR(36),
    price DECIMAL(10, 2)
);
