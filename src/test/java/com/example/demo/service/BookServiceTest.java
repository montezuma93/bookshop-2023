package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.Recommandation;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.RecommandationRepository;
import org.apache.tomcat.util.file.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Mock
    BookRepository bookRepositoryMock;

    @Mock
    RecommandationRepository recommandationRepository;

    BookService underTest;

    @BeforeEach
    void setUp() {
            underTest = new BookService(bookRepositoryMock, recommandationRepository)
        }

        @Test
    public void addRecommandationByBook() {
        Mockito.when(bookRepositoryMock.findAll()).thenReturn(List.of(new com.example.demo.domain.Book(1L, "title1", "autor"),
                new Book(2L, "title1", "autor")));
         Recommandation recommandation =   new Recommandation("textt", 123)
        underTest.addRecommandationByBook("title", new Recommandation("textt", 123));

        Mockito.verify(recommandationRepository).save(recommandation);
        Mockito.verify(bookRepositoryMock).save(Matcher.match());



        }



}