package edu.livreny.api.dtos;

import edu.livreny.api.model.Book;
import edu.livreny.api.model.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record BookListDto(String title, String author, String isbn, String publisher, Genre genre, BigDecimal price) {

    public BookListDto(Book book) {
        this(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublisher(), book.getGenre(), book.getPrice());
    }
}
