package com.mahidhar.database.dao;

import com.mahidhar.database.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> findAll();

    void update(String sibn, Book book);

    void delete(String s);
}
