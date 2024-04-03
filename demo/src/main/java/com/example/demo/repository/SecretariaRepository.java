package com.example.demo.repository;

import com.example.demo.model.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {
}