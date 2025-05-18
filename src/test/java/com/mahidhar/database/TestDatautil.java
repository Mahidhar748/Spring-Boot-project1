package com.mahidhar.database;

import com.mahidhar.database.domain.Author;
import com.mahidhar.database.domain.Book;

public final class TestDatautil {
    private TestDatautil(){

    }

    public static Author createAuthorA() {
        return Author.builder()
                .id(1L)
                .name("mahi")
                .age(23)
                .build();
    }
    public static Author createAuthorB() {
        return Author.builder()
                .id(2L)
                .name("abdhul kamal")
                .age(80)
                .build();
    }
    public static Author createAuthorC() {
//        new Author();
        return Author.builder()
                .id(3L)
                .name("sri sri")
                .age(70)
                .build();
    }


    public static Book createBookA(final Author author) {
        return Book.builder()
                .sibn("123-256")
                .title("java")
                .author(author)
                .build();
    }
    public static Book createBookB(final Author author){
        return Book.builder()
                .sibn("434-256")
                .title("wings of fire")
                .author(author)
                .build();
    }
}
