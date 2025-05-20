package com.mahidhar.database.controllers;

import com.mahidhar.database.domain.Author;
import com.mahidhar.database.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping(path = "/books")
    @ResponseBody
    public Book getBook(){
        Author author = Author.builder()
                .id(1L)
                .name("abdul Kamal")
                .age(90)
                .build();
        return Book.builder()
                .sibn("123-321")
                .title("wing of fire")
                .author(author)
                .build();
    }
}
