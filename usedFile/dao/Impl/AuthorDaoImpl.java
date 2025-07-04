package com.mahidhar.database.dao.Impl;

import com.mahidhar.database.dao.AuthorDao;
import com.mahidhar.database.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Component
public class AuthorDaoImpl implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO authors (id,name,age) VALUES (?,?,?)",
                author.getId(),author.getName(),author.getAge());
    }

    @Override
    public Optional<Author> findOne(long authorId) {
        List<Author> authors =  jdbcTemplate.query("SELECT * FROM authors WHERE id = ? LIMIT 1",
                new AuthorRowMapper(),
                authorId);
        return authors.stream().findFirst();
    }

    @Override
    public List<Author> findAll() {
        return jdbcTemplate.query("SELECT * FROM authors",new AuthorRowMapper());
    }

    @Override
    public void update(Long id, Author author) {
        jdbcTemplate.update("UPDATE authors SET id = ?, name = ?,age = ? WHERE id = ?",
                author.getId(), author.getName(), author.getAge(), author.getId());
    }

    @Override
    public void delete(long authorId) {
        jdbcTemplate.update("DELETE FROM authors WHERE id = ?",
                authorId);
    }

    public static class AuthorRowMapper implements RowMapper<Author>{

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Author().builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }



}
