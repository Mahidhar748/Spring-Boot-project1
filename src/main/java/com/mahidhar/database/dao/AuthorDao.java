package com.mahidhar.database.dao;

import com.mahidhar.database.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long authorId);

    List<Author> findAll();

    void update(Long id, Author author);

    void delete(long l);
}
