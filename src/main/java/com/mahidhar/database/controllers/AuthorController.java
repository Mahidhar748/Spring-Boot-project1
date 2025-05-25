package com.mahidhar.database.controllers;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.domain.dto.AuthorDto;
import com.mahidhar.database.mappers.Mapper;
import com.mahidhar.database.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private final AuthorService authorService;
    private final Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper){
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto){
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthorEntity =  authorService.createAuthorEntity(authorEntity);
        return authorMapper.mapTo(savedAuthorEntity);
    }
}
