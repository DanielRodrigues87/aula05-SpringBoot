package br.com.daniel.dominio.controller;

import br.com.daniel.dominio.entidades.Ordem;
import br.com.daniel.dominio.repositorios.OrdemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ordens")
public class OrdemController {

    @Autowired
    private OrdemRepositorio repositorio;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ordem> findById(@PathVariable Long id) {
        Ordem obj = repositorio.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
