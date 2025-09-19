package com.LMS.Repository;

import com.LMS.Entity.BookLoan;
import com.LMS.Entity.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.LockModeType;
import java.util.Optional;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

    // get the latest (or only) loan record for an ISBN (no lock — optimistic)
    Optional<BookLoan> findTopByIsbnOrderByIssueDateTimeDesc(String isbn);

    // find by isbn + userId (use camelCase property names)
    Optional<BookLoan> findByIsbnAndUserId(String isbn, Long userId);

    // find by isbn + userId + status (useful for checks)
    Optional<BookLoan> findByIsbnAndUserIdAndStatus(String isbn, Long userId, LoanStatus status);
}
