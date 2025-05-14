package com.mahidhar.database.dao.Impl;

import com.mahidhar.database.TestDatautil;
import com.mahidhar.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatAuthorCreateGenerateCorrectly(){
        Author author = TestDatautil.createAuthorA();
        underTest.create(author);

        verify(jdbcTemplate).update(eq("INSERT INTO authors (id,name,age) VALUES (?,?,?)"),
                eq(1L),
                eq("mahi"),
                eq(23));
    }

    @Test
    public void testFindOneIsGeneratingCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(eq("SELECT * FROM authors WHERE id = ? LIMIT 1"),
                any(AuthorDaoImpl.AuthorRowMapper.class),
                eq(1L)
                );
    }
    @Test
    public void testFindAllIsGeneratingCorrectSql(){
        underTest.findAll();
        verify(jdbcTemplate).query(eq("SELECT * FROM authors"),
                any(AuthorDaoImpl.AuthorRowMapper.class));

    }
    @Test
    public void testUpdateIsGeneratingCorrectSql(){
        Author author = TestDatautil.createAuthorA();
        underTest.update(author.getId(), author);
        verify(jdbcTemplate).update("UPDATE authors SET id = ?, name = ?,age = ? WHERE id = ?",
                1L,"mahi",23,1L
                );
    }
    @Test
    public void testThatDeleteIsGeneratingCorrectSql(){
        underTest.delete(1L);
        verify(jdbcTemplate).update("DELETE FROM authors WHERE id = ?", 1L);
    }


}

