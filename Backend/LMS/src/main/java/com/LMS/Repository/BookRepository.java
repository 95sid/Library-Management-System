package com.LMS.Repository;

import com.LMS.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    @Query("SELECT b FROM BookEntity b " +
            "WHERE LOWER(b.name) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
            "   OR LOWER(b.author) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
            "   OR LOWER(b.isbn) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
            "   OR LOWER(b.category) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<BookEntity> searchBooks(@Param("searchText") String searchText);
    Optional<BookEntity> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
}
