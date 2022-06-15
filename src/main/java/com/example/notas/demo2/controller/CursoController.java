package com.example.notas.demo2.controller;

import com.example.notas.demo2.model.Curso;
import com.example.notas.demo2.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CursoController {

    @Autowired
    public CursoService cursoService;


    @PostMapping("/agregar")
    public  ResponseEntity<?> guardarCurso(@RequestBody Curso curso){
        cursoService.guardar(curso);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getcursos",produces = "application/json")
    public List<Curso>  listacursos(){
        List<Curso> listaCursos = cursoService.getAll();
        return listaCursos;
    }

    @GetMapping(path = "/curso/{id}")
    public Optional<Curso> getCursoById(@PathVariable("id") Integer id){
        return cursoService.obtenerporId(id);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@RequestBody Curso curso, @PathVariable Integer id) {
        try {
            Curso curso1 = cursoService.getCurso(id);
            curso.setId(id);
            cursoService.guardar(curso);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<?> eliminarCurso(@PathVariable("id") Integer id, Model modelo){
        cursoService.eliminar(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


}
