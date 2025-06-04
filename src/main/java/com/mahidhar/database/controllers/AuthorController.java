package com.mahidhar.database.controllers;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.domain.dto.AuthorDto;
import com.mahidhar.database.mappers.Mapper;
import com.mahidhar.database.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private final AuthorService authorService;
    private final Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper){
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthorEntity =  authorService.createAuthorEntity(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }
    @GetMapping(path = "/authors")
    public List<AuthorDto> listAuthors(){
        List<AuthorEntity> authorEntityList = authorService.findAll();

        return authorEntityList.
                stream().
                map(authorMapper::mapTo)
                .collect(Collectors.toList());
    }
    @GetMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable("id") Long id){
        Optional<AuthorEntity> authorEntity = authorService.getAuthorById(id);
        return authorEntity.map(authorEntity1 -> {
            AuthorDto authorDto = authorMapper.mapTo(authorEntity1);
            return new ResponseEntity<AuthorDto>(authorDto,HttpStatus.OK);
        }).orElse(
                 new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body("bad Request");
    }
}
