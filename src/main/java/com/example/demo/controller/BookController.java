package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // Save operation
    @PostMapping("/books")
    public void saveBook(
            @RequestBody Book book) {
        bookService.save(book);
    }

    // Read operation
    @GetMapping("/books")
    public List<Book> fetchDepartmentList() {
        return bookService.getAllBooks();
    }
}

