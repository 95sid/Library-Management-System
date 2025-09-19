package com.LMS.Services;

import com.LMS.DTOs.BookLoanRequestDTO;
import com.LMS.DTOs.BookReturnRequestDTO;
import jakarta.validation.Valid;

public interface BookLoanService {
    BookLoanRequestDTO issueBook(@Valid BookLoanRequestDTO bookLoanRequestDTO);

    BookReturnRequestDTO returnBook(@Valid BookReturnRequestDTO bookLoanRequestDTO);
}
