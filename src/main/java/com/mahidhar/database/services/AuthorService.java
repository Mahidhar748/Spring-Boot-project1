package com.mahidhar.database.services;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.domain.Entities.BookEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorEntity createAuthorEntity(AuthorEntity authorEntity);
    Optional<AuthorEntity> getAuthorById(Long id);

    List<AuthorEntity> findAll();
}
