package edu.livreny.api.controller;

import edu.livreny.api.dtos.BookDto;
import edu.livreny.api.dtos.BookListDto;
import edu.livreny.api.dtos.UpdateBookDto;
import edu.livreny.api.model.Book;
import edu.livreny.api.repositories.BookRepository;
import edu.livreny.api.utils.Utils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> register(@RequestBody @Valid BookDto bookDto, UriComponentsBuilder uriBuilder) {

        Book book = new Book(bookDto);
        repository.save(book);

        var uri = uriBuilder.path("/{id}")
                .buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uri).body(book);
    }

    @GetMapping
    public ResponseEntity<Page<BookListDto>> list(@PageableDefault(sort = "title") Pageable paginate) {

        Page<BookListDto> bookList = repository.findAll(paginate).map(BookListDto::new);

        return ResponseEntity.ok(bookList);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateBookDto updateBookDto) {
        Book book = repository.getReferenceById(updateBookDto.id());
        Utils.copyNonNullProperties(updateBookDto, book);

        return ResponseEntity.ok().body(this.repository.save(book));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        Book book = repository.getReferenceById(id);
        repository.delete(book);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detail(@PathVariable Long id) {
        Book book = repository.getReferenceById(id);
        return ResponseEntity.ok(new BookListDto(book));
    }
}
