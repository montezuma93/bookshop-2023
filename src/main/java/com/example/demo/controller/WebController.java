package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.domain.Bookview;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getAllBooks")
    public ModelAndView getAllBooks() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        List<Bookview> books = bookService.getAllBookViews();
        modelAndView.addObject("books", books);
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("amount", books.size());
        return modelAndView;
    }

    @PostMapping("/saveBook")
    public ModelAndView saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        List<Bookview> books = bookService.getAllBookViews();
        modelAndView.addObject("books", books);
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("amount", books.size());
        return modelAndView;
    }


}
