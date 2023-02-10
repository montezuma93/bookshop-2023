package com.example.demo.repository;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Book;
import com.example.demo.domain.Recommandation;
@SpringBootTest

public class BookRepositoryTest {
    @Autowired
    BookRepository repB;
    @Autowired
    RecommandationRepository repR;

    @Test
    public void testBookRepository() throws Exception {
        ArrayList<Recommandation> recommendations = new ArrayList<Recommandation>();
        Book book = new Book(1L,"Hebt die Titanic", "Clive Cussler",recommendations);
        repB.save(book);
        assertThat(repB.findById(1L).get().getAuthor()).isEqualTo("Clive Cussler");
        Recommandation rec1 = new Recommandation("Tolles Buch",1);
        repR.save(rec1);
        book.getRecommendations().add(rec1);
        repB.save(book);
        assertThat(repB.findById(1L).get().getRecommendations().get(0).getDescription()).isEqualTo("Tolles Buch");
    }
}

