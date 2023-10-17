package edu.livreny.api.dtos;

import edu.livreny.api.model.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record BookDto(
        @NotBlank
        String title,
        @NotBlank
        String author,
        @NotBlank
        String isbn,
        String publisher,
        Genre genre,
        @NotNull
        BigDecimal price) {
}
