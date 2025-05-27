package com.mahidhar.database.services.impl;

import com.mahidhar.database.domain.Entities.BookEntity;
import com.mahidhar.database.repositories.BookRepository;
import com.mahidhar.database.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public BookEntity createBook(String isbn,BookEntity bookEntity) {
        bookEntity.setSibn(isbn);
        return bookRepository.save(bookEntity);
    }
}
