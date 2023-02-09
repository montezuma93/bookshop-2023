package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void printAllBooks() {
        List<Book> books = bookRepository.findAll();
        for(Book book : books) {
            System.out.println("Book: " + book.getTitle() + " ,written by " + book.getAuthor());
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
