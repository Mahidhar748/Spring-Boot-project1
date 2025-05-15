//package com.mahidhar.database.repositories;
//
//import com.mahidhar.database.TestDatautil;
//import com.mahidhar.database.domain.Author;
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
//public class AuthorDaoImplIntegrationTests {
//
//    private AuthorDaoImpl underTest;
//
//    @Autowired
//    public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest){
//        this.underTest = underTest;
//    }
//
//    @Test
//    public void testThatAuthorCanBeCreateAndFetchFromDb(){
//        Author author = TestDatautil.createAuthorA();
//        underTest.create(author);
//        Optional<Author> result = underTest.findOne(author.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(author);
//    }
//    @Test
//    public void testThatAuthorsCanBeFetchedFromDB(){
//        Author authorA = TestDatautil.createAuthorA();
//        underTest.create(authorA);
//        Author authorB = TestDatautil.createAuthorB();
//        underTest.create(authorB);
//        Author authorC = TestDatautil.createAuthorC();
//        underTest.create(authorC);
//        List<Author> result = underTest.findAll();
//        assertThat(result.size()).isEqualTo(3);
//        assertThat(result.get(1)).isEqualTo(authorB);
//
//    }
//    @Test
//    public void testThatUpdateCanFetchFromDB(){
//        Author author = TestDatautil.createAuthorA();
//        underTest.create(author);
//        author.setName("mahidhar");
//        underTest.update(1L,author);
//
//        assertThat(underTest.findOne(1L).get().getName()).isEqualTo("mahidhar");
//    }
//    @Test
//    public void testThatDeleteCanRemoveRecordsFromDB(){
//        Author author = TestDatautil.createAuthorA();
//        underTest.create(author);
//        underTest.delete(author.getId());
//        Optional<Author> result = underTest.findOne(author.getId());
//        assertThat(result).isEmpty();
//    }
//
//}
