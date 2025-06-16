package com.mahidhar.database.repositories;

import com.mahidhar.database.domain.Entities.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<BookEntity, String>,
        PagingAndSortingRepository<BookEntity,String> {
    @Modifying
    @Transactional
    @Query("DELETE FROM BookEntity b WHERE b.authorEntity.id = :authorId")
    void deleteBooksByTheAuthorsId(@Param("authorId") Long id);
}
