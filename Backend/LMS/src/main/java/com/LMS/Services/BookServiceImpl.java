package com.LMS.Services;

import com.LMS.DTOs.BookDTO;
import com.LMS.Entity.BookEntity;
import com.LMS.Repositor.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;


    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        return books.
                stream()
                .map(book->modelMapper.map(book, BookDTO.class))
                .toList();
    }

    @Override
    public List<BookDTO> getBookBySearchText(String searchText) {
        if(searchText == null || searchText.isEmpty()) return List.of();

        List<BookEntity> books = bookRepository.searchBooks(searchText);

        return books
                .stream()
                .map(book->modelMapper.map(book,BookDTO.class))
                .toList();

    }
}
