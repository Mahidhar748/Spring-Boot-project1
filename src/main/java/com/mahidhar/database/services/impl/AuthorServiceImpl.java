package com.mahidhar.database.services.impl;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.repositories.AuthorRepository;
import com.mahidhar.database.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public Optional<AuthorEntity> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return StreamSupport.stream(
                authorRepository.
                        findAll().
                        spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
