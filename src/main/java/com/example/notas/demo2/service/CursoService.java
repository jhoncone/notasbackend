package com.example.notas.demo2.service;

import com.example.notas.demo2.model.Curso;
import com.example.notas.demo2.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    public CursoRepository cursoRepository;
    public Curso guardar(Curso curso){
       return cursoRepository.save(curso);
    }

    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerporId(Integer id) {
        return cursoRepository.findById(id);
    }

    public Curso getCurso(Integer id) {
        return cursoRepository.findById(id).get();
    }

    public void eliminar(Integer id) {
        cursoRepository.deleteById(id);
    }
}
