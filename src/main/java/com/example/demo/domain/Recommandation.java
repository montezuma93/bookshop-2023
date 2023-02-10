package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    public Recommandation(String description, int rating) {
        this.description = description;
        this.rating = rating;
    }
}
