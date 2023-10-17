package edu.livreny.api.dtos;

import edu.livreny.api.model.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateBookDto(@NotNull Long id, String title, String author, String isbn, String publisher, Genre genre,
                            BigDecimal price) {
}
