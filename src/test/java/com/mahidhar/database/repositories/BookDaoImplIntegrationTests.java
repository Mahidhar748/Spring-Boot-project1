//package com.mahidhar.database.repositories;
//
//import com.mahidhar.database.TestDatautil;
//import com.mahidhar.database.dao.AuthorDao;
//import com.mahidhar.database.domain.Author;
//import com.mahidhar.database.domain.Book;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class BookDaoImplIntegrationTests {
//
//    private AuthorDao authorDao;
//
//    private BookDaoImpl underTest;
//    @Autowired
//    public BookDaoImplIntegrationTests(BookDaoImpl underTest,AuthorDao authorDao) {
//        this.underTest = underTest;
//        this.authorDao = authorDao;
//    }
//    @Test
//    public void testThatBookCanCreateAndGetFromDB(){
//        Author author = TestDatautil.createAuthorA();
//        authorDao.create(author);
//        Book book = TestDatautil.createBookA();
//        underTest.create(book);
//        Optional<Book> result = underTest.findOne(book.getSibn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//    }
//    @Test
//    public void testThatFindAllIsGeneratingALLBooksFromDB(){
//        authorDao.create(TestDatautil.createAuthorA());
//        authorDao.create(TestDatautil.createAuthorB());
//        authorDao.create(TestDatautil.createAuthorC());
//
//        underTest.create(TestDatautil.createBookA());
//        underTest.create(TestDatautil.createBookB());
//        List<Book> result = underTest.findAll();
//        assertThat(result.size()).isEqualTo(2);
//        Assertions.assertEquals(result.get(1), TestDatautil.createBookB());
//
//    }
//    @Test
//    public void testThatUpdateBookIsCorrectlyUpdatingDB(){
//        authorDao.create(TestDatautil.createAuthorA());
//        Book book = TestDatautil.createBookA();
//        underTest.create(book);
//        book.setTitle("Java with Spring Boot");
//        underTest.update(book.getSibn(),book);
//        assertThat(underTest.findOne(book.getSibn()).get().getTitle()).isEqualTo("Java with Spring Boot");
//    }
//    @Test
//    public void testThatBookDeleteCanDeleteFromDB(){
//        authorDao.create(TestDatautil.createAuthorA());
//        Book book = TestDatautil.createBookA();
//        underTest.create(book);
//        underTest.delete(book.getSibn());
//        Optional<Book> result = underTest.findOne(book.getSibn());
//        assertThat(result).isEmpty();
//    }
//}
