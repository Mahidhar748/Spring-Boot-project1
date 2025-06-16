package com.mahidhar.database.services;

import com.mahidhar.database.domain.Entities.BookEntity;
import com.mahidhar.database.domain.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookEntity createBook(String isbn,BookEntity bookEntity);

    List<BookEntity> findAll();
    Page<BookEntity> findAll(Pageable pageable);
}
