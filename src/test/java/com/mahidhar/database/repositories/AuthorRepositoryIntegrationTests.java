package com.mahidhar.database.repositories;

import com.mahidhar.database.TestDatautil;
import com.mahidhar.database.domain.Author;
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
public class AuthorRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreateAndFetchFromDb(){
        Author author = TestDatautil.createAuthorB();
        System.out.println(author.toString());
        System.out.println(underTest.findAll());
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
        System.out.println(underTest.findAll());
        assertThat(result.get().getId()).isEqualTo(author.getId());
    }

    @Test
    public void testThatAuthorsCanBeFetchedFromDB(){
        Author authorA = TestDatautil.createAuthorA();
        underTest.save(authorA);
        Author authorB = TestDatautil.createAuthorB();
        underTest.save(authorB);
        Author authorC = TestDatautil.createAuthorC();
        underTest.save(authorC);
        Iterable<Author> result = underTest.findAll();
        assertThat(result).hasSize(3);
    }

    @Test
    public void testThatUpdateCanFetchFromDB(){
        Author author = TestDatautil.createAuthorA();
        underTest.save(author);
        author.setName("mahidhar");
        underTest.save(author);
        assertThat(underTest.findById(author.getId()).get().getName()).isEqualTo("mahidhar");
    }
    @Test
    public void testThatDeleteCanRemoveRecordsFromDB(){
        Author author = TestDatautil.createAuthorA();
        underTest.save(author);
        underTest.delete(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isEmpty();
    }

}
