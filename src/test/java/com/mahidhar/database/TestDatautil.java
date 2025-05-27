package com.mahidhar.database;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.domain.Entities.BookEntity;
import com.mahidhar.database.domain.dto.AuthorDto;
import com.mahidhar.database.domain.dto.BookDto;

public final class TestDatautil {
    private TestDatautil(){

    }

    public static AuthorEntity createAuthorA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("mahi")
                .age(23)
                .build();
    }
    public static AuthorEntity createAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("abdhul kamal")
                .age(80)
                .build();
    }
    public static AuthorEntity createAuthorC() {
//        new AuthorEntity();
        return AuthorEntity.builder()
                .id(3L)
                .name("sri sri")
                .age(70)
                .build();
    }
    public static BookDto createBookDtoA(final AuthorDto authorDto){
        return BookDto.builder()
                .sibn("123-256")
                .title("java")
                .author(authorDto)
                .build();

    }


    public static BookEntity createBookA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .sibn("123-256")
                .title("java")
                .authorEntity(authorEntity)
                .build();
    }
    public static BookEntity createBookB(final AuthorEntity authorEntity){
        return BookEntity.builder()
                .sibn("434-256")
                .title("wings of fire")
                .authorEntity(authorEntity)
                .build();
    }
}
