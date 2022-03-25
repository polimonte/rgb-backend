package com.rgbspringboot.controller;

import com.rgbspringboot.exception.ResourceNotFoundException;
import com.rgbspringboot.model.ViagensCompradas;
import com.rgbspringboot.repository.ViagensCompradasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/viagenscompradas")
public class ViagensCompradasController {

    @Autowired
    private ViagensCompradasRepository viagensCompradasRepository;

    @GetMapping
    public List<ViagensCompradas> getAllViagensCompradas(){
        return viagensCompradasRepository.findAll();
    }

    //create ViagensCompradas REST API
    @PostMapping
    public ViagensCompradas createViagensCompradas(@RequestBody ViagensCompradas viagensCompradas){
        return viagensCompradasRepository.save(viagensCompradas);
    }

    //get ViagensCompradas by id REST API
    @GetMapping("{id}")
    public ResponseEntity<ViagensCompradas> getViagensCompradaById(@PathVariable int id){
        ViagensCompradas viagensCompradas = viagensCompradasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));
        return ResponseEntity.ok(viagensCompradas);
    }

    //delete ViagensCompradas REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteViagensCompradas(@PathVariable int id){

        ViagensCompradas viagensCompradas = viagensCompradasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));

        viagensCompradasRepository.delete(viagensCompradas);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
