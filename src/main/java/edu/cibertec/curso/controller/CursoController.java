
package edu.cibertec.curso.controller;

import edu.cibertec.curso.dao.entity.CursoEntity;
import edu.cibertec.curso.dto.ErrorDTO;
import edu.cibertec.curso.service.CursoService;
import jakarta.websocket.server.PathParam;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CursoController {
    
    @Autowired
    private CursoService cursoService;
    
    @GetMapping("/cursos")
    public List<CursoEntity> listarTodos(){
        return cursoService.listarTodos();
    }
    
    @GetMapping("/cursos/{id}")
    public CursoEntity obtenerUno(@PathVariable("id") int codigo){
        try {
            return cursoService.obtenerUno(codigo);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no localizado", e);
        }
        
    }
    
    @PostMapping("/cursos")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody CursoEntity ce){
        try {
            cursoService.insertar(ce);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Curso no pudo ser procesado", null);
        }
        
    }
    
    @PutMapping("/cursos/{id}")
    public void modificar(@RequestBody CursoEntity ce, 
            @PathVariable("id") int codigo){
        ce.setIdCurso(codigo);
        cursoService.modificar(ce);
    }
    
    @DeleteMapping("cursos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("id") int codigo){
        cursoService.eliminar(codigo);
    }
    
    @ExceptionHandler(Exception.class)
    private ResponseEntity manejarExcepciones(){
        ErrorDTO err = new ErrorDTO(HttpStatus.CONFLICT.toString(), "Problema interno.", "Ha ocurrido un error en la aplicación. Verifique su request.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }
}
