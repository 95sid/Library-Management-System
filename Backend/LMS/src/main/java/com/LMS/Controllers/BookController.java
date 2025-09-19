package com.LMS.Controllers;


import com.LMS.DTOs.BookDTO;
import com.LMS.Services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/LMS/Book")
public class BookController {
//    /getall
///getbylike


    private final BookService bookServiceImpl;

    public BookController(BookService bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookServiceImpl.getAllBooks());
    }

    @GetMapping(value="/{search}")
    public ResponseEntity<List<BookDTO>> getBookBySearchText(@PathVariable("search") String searchText){
        if(searchText.isEmpty()){
            return ResponseEntity.ok(bookServiceImpl.getAllBooks());
        }
        return ResponseEntity.ok(bookServiceImpl.getBookBySearchText(searchText));
    }
}
