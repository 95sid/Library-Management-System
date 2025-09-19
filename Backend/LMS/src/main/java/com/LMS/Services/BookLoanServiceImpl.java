package com.LMS.Services;

import com.LMS.DTOs.BookLoanRequestDTO;
import com.LMS.DTOs.BookReturnRequestDTO;
import com.LMS.Entity.BookEntity;
import com.LMS.Entity.BookLoan;
import com.LMS.Entity.LoanStatus;
import com.LMS.Exceptions.BookAlreadyReturnedException;
import com.LMS.Exceptions.BookNotAvailableExcepiton;
import com.LMS.Exceptions.BookNotFoundExcepiton;
import com.LMS.Exceptions.UserNotFoundExcetpion;
import com.LMS.Repository.BookLoanRepository;
import com.LMS.Repository.BookRepository;
import com.LMS.Repository.UserReposiitory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepository bookLoanRepository;
    private final ModelMapper modelMapper;
    private final UserReposiitory userReposiitory;
    private final BookRepository bookRepository;

    public BookLoanServiceImpl(BookLoanRepository bookLoanRepository,
                               ModelMapper modelMapper,
                               UserReposiitory userReposiitory,
                               BookRepository bookRepository) {
        this.bookLoanRepository = bookLoanRepository;
        this.modelMapper = modelMapper;
        this.userReposiitory = userReposiitory;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookLoanRequestDTO issueBook(BookLoanRequestDTO bookLoanRequest) {
        searchUserId(bookLoanRequest.getId());
        BookEntity book = bookRepository.findByIsbn(bookLoanRequest.getIsbn())
                .orElseThrow(() -> new BookNotFoundExcepiton("Please enter a valid ISBN number"));

        if (book.getBook_copies() == null || book.getBook_copies() <= 0) {
            throw new BookNotAvailableExcepiton("No copies available for ISBN " + book.getIsbn());
        }

        // Check if the same user has an outstanding loan for the same book
        Optional<BookLoan> existingActiveLoan = bookLoanRepository.findByIsbnAndUserIdAndStatus(
                bookLoanRequest.getIsbn(),
                bookLoanRequest.getId(),
                LoanStatus.NOT_RETURNED
        );

        if (existingActiveLoan.isPresent()) {
            throw new BookNotAvailableExcepiton("You have already borrowed this book and have not returned it.");
        }

        // Create a new loan record
        BookLoan newLoan = new BookLoan();
        newLoan.setIsbn(bookLoanRequest.getIsbn());
        newLoan.setUserId(bookLoanRequest.getId());
        newLoan.setDueDate(bookLoanRequest.getDueDate());
        newLoan.setStatus(LoanStatus.NOT_RETURNED);

        // Decrement copies and save the book entity
        book.setBook_copies(book.getBook_copies() - 1);
        bookRepository.save(book);

        // Save the new loan record
        BookLoan saved = bookLoanRepository.save(newLoan);
        return modelMapper.map(saved, BookLoanRequestDTO.class);
    }

    @Override
    public BookReturnRequestDTO returnBook(BookReturnRequestDTO bookReturnRequestDto) {
        searchUserId(bookReturnRequestDto.getId());
        BookEntity book = bookRepository.findByIsbn(bookReturnRequestDto.getIsbn())
                .orElseThrow(() -> new BookNotFoundExcepiton("Please enter a valid ISBN number"));

        // Find the specific loan record that is currently NOT_RETURNED
        Optional<BookLoan> opt = bookLoanRepository.findByIsbnAndUserIdAndStatus(
                bookReturnRequestDto.getIsbn(),
                bookReturnRequestDto.getId(),
                LoanStatus.NOT_RETURNED
        );

        if (opt.isEmpty()) {
            // This means no active loan was found for this user and book
            throw new BookAlreadyReturnedException("Book with ISBN " + bookReturnRequestDto.getIsbn() + " has already been returned or was never issued to this user.");
        }

        BookLoan loan = opt.get();

        // Set status to AVAILABLE
        loan.setStatus(LoanStatus.AVAILABLE);

        // Increment book copies and save the book entity
        Integer copies = book.getBook_copies() == null ? 0 : book.getBook_copies();
        book.setBook_copies(copies + 1);
        bookRepository.save(book);

        // Save the updated loan record
        BookLoan saved = bookLoanRepository.save(loan);
        return modelMapper.map(saved, BookReturnRequestDTO.class);
    }


    private void searchUserId(Long userId) {
        if (!userReposiitory.existsById(userId))
            throw new UserNotFoundExcetpion("Please enter a valid user id or create new user.");
    }
}
