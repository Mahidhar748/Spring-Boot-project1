package com.mahidhar.database;

import com.mahidhar.database.domain.Author;
import com.mahidhar.database.domain.Book;

public final class TestDatautil {
    private TestDatautil(){

    }

    public static Author createAuthorA() {
        return new Author().builder()
                .id(1L)
                .name("mahi")
                .age(23)
                .build();
    }
    public static Author createAuthorB() {
        return new Author().builder()
                .id(2L)
                .name("abdhul kamal")
                .age(80)
                .build();
    }
    public static Author createAuthorC() {
        return new Author().builder()
                .id(3L)
                .name("sri sri")
                .age(90)
                .build();
    }


    public static Book createBookA() {
        return new Book().builder()
                .sibn("123-256")
                .title("java")
                .id(1L)
                .build();
    }
    public static Book createBookB(){
        return new Book().builder()
                .sibn("434-256")
                .title("wings of fire")
                .id(2L)
                .build();
    }
}
