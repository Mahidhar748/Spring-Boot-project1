package com.mahidhar.database.controllers;

import com.mahidhar.database.domain.Entities.BookEntity;
import com.mahidhar.database.domain.dto.BookDto;
import com.mahidhar.database.mappers.Mapper;
import com.mahidhar.database.services.BookService;
import com.mahidhar.database.services.impl.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class BookController {

    private final BookService bookService;

    private final Mapper<BookEntity,BookDto> bookMapper;

    public BookController(Mapper<BookEntity,BookDto> bookMapper, BookService bookService){
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn,
                                              @RequestBody BookDto bookDto){
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.CREATED);

    }
    @GetMapping(path = "/books")
    public List<BookDto> getBooks(){
        List<BookEntity> bookEntityList = bookService.findAll();
        return bookEntityList.stream()
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }
}
