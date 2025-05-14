package com.mahidhar.database.dao.Impl;

import com.mahidhar.database.dao.BookDao;
import com.mahidhar.database.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn,title,author_id) VALUES (?,?,?)",
                book.getSibn(),book.getTitle(),book.getId());
    }

    @Override
    public Optional<Book> findOne(String isbn) {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books WHERE isbn = ? LIMIT 1",
                new BookRowMapper(),isbn);
        return books.stream().findFirst();
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", new BookRowMapper());
        return books;
    }

    @Override
    public void update(String sibn, Book book) {
        jdbcTemplate.update("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                book.getSibn(), book.getTitle(), book.getId(), book.getSibn());
    }

    @Override
    public void delete(String isbn) {
        jdbcTemplate.update("DELETE FROM books WHERE isbn = ?", isbn);
    }

    public static class BookRowMapper implements RowMapper<Book>{

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Book().builder()
                    .sibn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .id(rs.getLong("author_id"))
                    .build();
        }
    }

}
