package com.mahidhar.database.repositories;

import com.mahidhar.database.TestDatautil;
import com.mahidhar.database.domain.Author;
import com.mahidhar.database.domain.Book;
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
public class BookDaoImplIntegrationTests {

    private final AuthorRepository authorDao;

    private final BookRepository underTest;
    @Autowired
    public BookDaoImplIntegrationTests(BookRepository underTest,AuthorRepository authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }
    @Test
    public void testThatBookCanCreateAndGetFromDB(){
        Author author = TestDatautil.createAuthorA();
        authorDao.save(author);
        Book book = TestDatautil.createBookA(author);
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getSibn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }
    @Test
    public void testThatFindAllIsGeneratingALLBooksFromDB(){
        underTest.save(TestDatautil.createBookA(TestDatautil.createAuthorA()));
        underTest.save(TestDatautil.createBookB(TestDatautil.createAuthorB()));
        Iterable<Book> result = underTest.findAll();
        assertThat(result).hasSize(2);

    }
    @Test
    public void testThatUpdateBookIsCorrectlyUpdatingDB(){
        Book book = TestDatautil.createBookA(TestDatautil.createAuthorA());
        underTest.save(book);
        book.setTitle("Java with Spring Boot");
        underTest.save(book);
        assertThat(underTest.findById(book.getSibn()).get().getTitle()).isEqualTo("Java with Spring Boot");
    }
    @Test
    public void testThatBookDeleteCanDeleteFromDB(){
        Book book = TestDatautil.createBookA(TestDatautil.createAuthorA());
        underTest.save(book);
        underTest.deleteById(book.getSibn());
        Optional<Book> result = underTest.findById(book.getSibn());
        assertThat(result).isEmpty();
    }
}
