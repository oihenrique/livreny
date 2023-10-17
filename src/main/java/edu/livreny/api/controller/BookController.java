package edu.livreny.api.controller;

import edu.livreny.api.dtos.BookDto;
import edu.livreny.api.model.Book;
import edu.livreny.api.repositories.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity registerBook(@RequestBody @Valid BookDto bookDto, UriComponentsBuilder uriBuilder) {

        Book book = new Book(bookDto);
        repository.save(book);

        var uri = uriBuilder.path("/{id}")
                .buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uri).body(book);
    }

//    @GetMapping
//    public ResponseEntity<Page<TopicListDTO>> list(@PageableDefault(sort = "creationDate", direction = Sort.Direction.ASC) Pageable paginate) {
//
//        Page<TopicListDTO> topicList = repository.findAll(paginate).map(TopicListDTO::new);
//
//        return ResponseEntity.ok(topicList);
//    }
//
//    @PutMapping
//    @Transactional
//    public ResponseEntity update(@RequestBody @Valid UpdateTopicDTO updateTopicDTO) {
//        Topic topic = repository.getReferenceById(updateTopicDTO.id());
//        topic.updatePost(updateTopicDTO);
//
//        return ResponseEntity.ok(new TopicListDTO(topic));
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity delete(@PathVariable Long id) {
//        Topic topic = repository.getReferenceById(id);
//        repository.delete(topic);
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/{id}")
//    @Transactional
//    public ResponseEntity detail(@PathVariable Long id) {
//        Topic topic = repository.getReferenceById(id);
//        return ResponseEntity.ok(new TopicListDTO(topic));
//    }
}
