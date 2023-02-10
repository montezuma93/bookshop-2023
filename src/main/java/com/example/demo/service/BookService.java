package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.Recommandation;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.RecommandationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RecommandationRepository recommandationRepository;

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

    public void addRecommandationByBook(String title, Recommandation recommandation) {
        List<Book> books = bookRepository.findAll();
        for(Book book : books){
            if (title.equals(book.getTitle())){
                recommandation.setBook(book);
                recommandationRepository.save(recommandation);
                save(book);
            }
        }
    }
}
