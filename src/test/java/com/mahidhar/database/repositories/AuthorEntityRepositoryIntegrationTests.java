package com.mahidhar.database.repositories;

import com.mahidhar.database.TestDatautil;
import com.mahidhar.database.domain.Entities.AuthorEntity;
import jakarta.transaction.Transactional;
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
public class AuthorEntityRepositoryIntegrationTests {

    private final AuthorRepository underTest;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorEntityRepositoryIntegrationTests(AuthorRepository underTest, BookRepository bookRepository){
        this.underTest = underTest;
        this.bookRepository = bookRepository;
    }

    @Test
    public void testThatAuthorCanBeCreateAndFetchFromDb(){
        AuthorEntity authorEntity = TestDatautil.createAuthorB();
        System.out.println(authorEntity.toString());
        System.out.println(underTest.findAll());
        underTest.save(authorEntity);
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntity);
        System.out.println(underTest.findAll());
        assertThat(result.get().getId()).isEqualTo(authorEntity.getId());
    }

    @Test
    public void testThatAuthorsCanBeFetchedFromDB(){
        AuthorEntity authorEntityA = TestDatautil.createAuthorA();
        underTest.save(authorEntityA);
        AuthorEntity authorEntityB = TestDatautil.createAuthorB();
        underTest.save(authorEntityB);
        AuthorEntity authorEntityC = TestDatautil.createAuthorC();
        underTest.save(authorEntityC);
        Iterable<AuthorEntity> result = underTest.findAll();
        assertThat(result).hasSize(3);
    }

    @Test
    public void testThatUpdateCanFetchFromDB(){
        AuthorEntity authorEntity = TestDatautil.createAuthorA();
        underTest.save(authorEntity);
        authorEntity.setName("mahidhar");
        underTest.save(authorEntity);
        assertThat(underTest.findById(authorEntity.getId()).get().getName()).isEqualTo("mahidhar");
    }
    @Transactional
    @Test
    public void testThatDeleteCanRemoveRecordsFromDB(){
        AuthorEntity authorEntity = TestDatautil.createAuthorA();
        underTest.save(authorEntity);
        bookRepository.deleteBooksByTheAuthorsId(authorEntity.getId());
        underTest.deleteById(authorEntity.getId());
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isEmpty();
    }

}
