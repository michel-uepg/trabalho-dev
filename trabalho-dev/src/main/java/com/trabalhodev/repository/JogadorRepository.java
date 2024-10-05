package com.trabalhodev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhodev.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
