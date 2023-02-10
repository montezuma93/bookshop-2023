package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
