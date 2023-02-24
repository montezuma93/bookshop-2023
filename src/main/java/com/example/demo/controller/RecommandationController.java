package com.example.demo.controller;

import com.example.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Recommandation;
import com.example.demo.service.BookService;
import com.example.demo.service.RecommandationService;

@RestController

public class RecommandationController {

    @Autowired
    private RecommandationService recommandationService;
    @Autowired
    private BookService bookservice;
    
    // Save operation
    @PostMapping("/recommandations")
    public void saveRecommandation(
        @RequestParam String booktitle,
        @RequestBody Recommandation recommandation) {
        bookservice.addRecommandationByBook(booktitle, recommandation);
        recommandationService.save(recommandation);
    }

    @GetMapping("/saveRecommandation")
    public void saveRecommandation (
        @RequestParam String title, @RequestParam String recommandationText, @RequestParam int rating) {
        Recommandation recommandation = new Recommandation (recommandationText, rating);
        bookservice.addRecommandationByBook(title, recommandation);
        recommandationService.save(recommandation);
    }
}
