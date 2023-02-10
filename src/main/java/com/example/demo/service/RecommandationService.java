package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Recommandation;
import com.example.demo.repository.RecommandationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RecommandationService {
    @Autowired
    RecommandationRepository recommandationRepository;

    public void save(Recommandation recommandation) {
        recommandationRepository.save(recommandation);
    }
    }
