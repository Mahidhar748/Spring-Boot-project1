package com.mahidhar.database.repositories;

import com.mahidhar.database.TestDatautil;
import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.domain.Entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityDaoImplIntegrationTests {

    private final AuthorRepository authorDao;

    private final BookRepository underTest;
    @Autowired
    public BookEntityDaoImplIntegrationTests(BookRepository underTest, AuthorRepository authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }
    @Test
    public void testThatBookCanCreateAndGetFromDB(){
        AuthorEntity authorEntity = TestDatautil.createAuthorA();
        authorDao.save(authorEntity);
        BookEntity bookEntity = TestDatautil.createBookA(authorEntity);
        underTest.save(bookEntity);
        Optional<BookEntity> result = underTest.findById(bookEntity.getSibn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntity);

    }
    @Test
    public void testThatFindAllIsGeneratingALLBooksFromDB(){
        underTest.save(TestDatautil.createBookA(TestDatautil.createAuthorA()));
        underTest.save(TestDatautil.createBookB(TestDatautil.createAuthorB()));
        Iterable<BookEntity> result = underTest.findAll();
        assertThat(result).hasSize(2);

    }
    @Test
    public void testThatUpdateBookIsCorrectlyUpdatingDB(){
        BookEntity bookEntity = TestDatautil.createBookA(TestDatautil.createAuthorA());
        underTest.save(bookEntity);
        bookEntity.setTitle("Java with Spring Boot");
        underTest.save(bookEntity);
        assertThat(underTest.findById(bookEntity.getSibn()).get().getTitle()).isEqualTo("Java with Spring Boot");
    }
    @Test
    public void testThatBookDeleteCanDeleteFromDB(){
        BookEntity bookEntity = TestDatautil.createBookA(TestDatautil.createAuthorA());
        underTest.save(bookEntity);
        underTest.deleteById(bookEntity.getSibn());
        Optional<BookEntity> result = underTest.findById(bookEntity.getSibn());
        assertThat(result).isEmpty();
    }
}
