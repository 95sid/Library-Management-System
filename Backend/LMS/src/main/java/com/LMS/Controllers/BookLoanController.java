package com.LMS.Controllers;

import com.LMS.DTOs.BookLoanRequestDTO;
import com.LMS.DTOs.BookReturnRequestDTO;
import com.LMS.Services.BookLoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

///issuebook
///returnbook
@RestController
@RequestMapping(value="/LMS/LoanBook")
@CrossOrigin(origins = "http://localhost:5173")
public class BookLoanController {
    private final BookLoanService bookLoanServiceImpl;

    public BookLoanController(BookLoanService bookLoanServiceImpl) {
        this.bookLoanServiceImpl = bookLoanServiceImpl;
    }

    @PostMapping("/issue")
    // your transaction id is this :
    public ResponseEntity<BookLoanRequestDTO> issueBook(@Valid @RequestBody BookLoanRequestDTO bookLoanRequestDTO){
        System.out.println(bookLoanRequestDTO.getIsbn() + " " + bookLoanRequestDTO.getId());
        return ResponseEntity.ok(bookLoanServiceImpl.issueBook(bookLoanRequestDTO));
    }

    @PostMapping("/return")
    public ResponseEntity<BookReturnRequestDTO> returnBook(@Valid @RequestBody BookReturnRequestDTO bookReturnRequestDTO){

        return ResponseEntity.ok(bookLoanServiceImpl.returnBook(bookReturnRequestDTO));
    }
}
