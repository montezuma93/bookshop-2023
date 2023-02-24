package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/saveBook")
    public void saveBook2(
            @RequestParam String author, @RequestParam String title, @RequestParam String description, @RequestParam int price) {
        bookService.save(new Book(author, title, description, price));
    }

    // Read operation
    @GetMapping("/books")
    public List<Book> fetchDepartmentList() {
        return bookService.getAllBooks();
    }
}

