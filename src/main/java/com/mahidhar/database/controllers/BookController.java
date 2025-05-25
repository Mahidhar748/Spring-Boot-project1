package com.mahidhar.database.controllers;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.domain.Entities.BookEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping(path = "/books")
    @ResponseBody
    public BookEntity getBook(){
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(1L)
                .name("abdul Kamal")
                .age(90)
                .build();
        return BookEntity.builder()
                .sibn("123-321")
                .title("wing of fire")
                .authorEntity(authorEntity)
                .build();
    }
}
