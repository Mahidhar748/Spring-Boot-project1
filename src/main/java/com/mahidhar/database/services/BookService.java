package com.mahidhar.database.services;

import com.mahidhar.database.domain.Entities.BookEntity;
import com.mahidhar.database.domain.dto.BookDto;

import java.util.List;

public interface BookService {
    BookEntity createBook(String isbn,BookEntity bookEntity);

    List<BookEntity> findAll();
}
