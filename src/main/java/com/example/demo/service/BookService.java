package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.Bookview;
import com.example.demo.domain.Recommandation;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.RecommandationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
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

    public List<Bookview> getAllBookViews(){
        List<Bookview> bookViews = new ArrayList<Bookview>();
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            Bookview bookview = new Bookview();
            bookview.setBook(book);
            List<Recommandation> recommandations = recommandationRepository.findAllByBookId(book.getId());
            int amountOfRecommandations = recommandations.size();
            int totalStars = 0;
            for (Recommandation recommandation : recommandations) {
                totalStars = totalStars + recommandation.getRating();
            }
            if (amountOfRecommandations > 0) {
                double averageRating = (double) totalStars / amountOfRecommandations;
                bookview.setRating(averageRating);
            }else {
                bookview.setRating(0);
            }
            bookViews.add(bookview);
        }
        return bookViews;
    }
}
