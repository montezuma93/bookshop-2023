package com.example.demo.repository;

import com.example.demo.domain.Recommandation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

// Interface
public interface RecommandationRepository extends JpaRepository<Recommandation, Long> {


    List<Recommandation> findAllByBookId(Long id);
}