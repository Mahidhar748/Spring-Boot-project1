package com.mahidhar.database.repositories;

import com.mahidhar.database.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}
