package com.example.demo.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Recommandation {
    String description;
    int rating;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    @JsonIgnore
    public Book book;

    public Recommandation(String description, int rating) {
        this.description = description;
        this.rating = rating;
    }
}
