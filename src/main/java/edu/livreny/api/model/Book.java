package edu.livreny.api.model;

import edu.livreny.api.dtos.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "books")
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    public BigDecimal price;

    public Book(BookDto bookDto) {
        this.title = bookDto.title();
        this.author = bookDto.author();
        this.publisher = bookDto.publisher();
        this.genre = bookDto.genre();
        this.isbn = bookDto.isbn();
        this.price = bookDto.price();
    }
}
