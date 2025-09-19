package com.LMS.Services;

import com.LMS.DTOs.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();

    List<BookDTO> getBookBySearchText(String searchText);
}
