package com.mahidhar.database.dao.Impl;

import com.mahidhar.database.TestDatautil;
import com.mahidhar.database.domain.Book;
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
public class BookImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private BookDaoImpl bookDaoImpl;

    @Test
    public void testThatBookCreateGenerateSql(){
        Book book = TestDatautil.createBookA();
        bookDaoImpl.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn,title,author_id) VALUES (?,?,?)"),
                eq("123-256"),
                eq("java"),
                eq(1L)
        );
    }

    @Test
    public void testFindOneGenerateCorrectSql(){
        bookDaoImpl.findOne("123-256");
        verify(jdbcTemplate).query(eq("SELECT * FROM books WHERE isbn = ? LIMIT 1"),
                any(BookDaoImpl.BookRowMapper.class),
                eq("123-256")
        );
    }
    @Test
    public void testFindAllGenerateCorrectSql(){
        bookDaoImpl.findAll();
        verify(jdbcTemplate).query(eq("SELECT * FROM books"),
                any(BookDaoImpl.BookRowMapper.class));

    }
    @Test
    public void testUpdateGenerateCorrectSql(){
        TestDatautil.createAuthorA();
        Book book = TestDatautil.createBookA();
        bookDaoImpl.update(book.getSibn(),book);
        verify(jdbcTemplate).update("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                "123-256", "java", 1L , book.getSibn());
    }
}
