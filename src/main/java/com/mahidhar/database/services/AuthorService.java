package com.mahidhar.database.services;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.domain.Entities.BookEntity;

public interface AuthorService {
    AuthorEntity createAuthorEntity(AuthorEntity authorEntity);
    AuthorEntity getAuthorById(Long id);
}
