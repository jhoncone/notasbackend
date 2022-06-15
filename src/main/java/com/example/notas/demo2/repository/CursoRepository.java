package com.example.notas.demo2.repository;

import com.example.notas.demo2.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
