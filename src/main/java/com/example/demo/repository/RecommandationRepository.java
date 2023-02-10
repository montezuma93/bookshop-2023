package com.example.demo.repository;

import com.example.demo.domain.Recommandation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

// Interface
public interface RecommandationRepository extends JpaRepository<Recommandation, Long> {


}