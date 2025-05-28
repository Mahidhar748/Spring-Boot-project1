package com.mahidhar.database.services.impl;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.repositories.AuthorRepository;
import com.mahidhar.database.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthorEntity(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);

    }

    @Override
    public AuthorEntity getAuthorById(Long id) {
        return authorRepository.findById(id).isPresent() ?
                authorRepository.findById(id).get():null;
    }
}
