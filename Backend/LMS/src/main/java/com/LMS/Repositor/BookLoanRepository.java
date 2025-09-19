package com.LMS.Repositor;

import com.LMS.Entity.BookLoan;
import com.LMS.Entity.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {
    // find by isbn + userId + status
    Optional<BookLoan> findByIsbnAndUserIdAndStatus(String isbn, Long userId, LoanStatus status);
}
