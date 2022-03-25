package com.rgbspringboot.controller;
;
import com.rgbspringboot.exception.ResourceNotFoundException;

import com.rgbspringboot.model.Destinos;
import com.rgbspringboot.repository.DestinosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/destinos")
public class DestinosController {

    @Autowired
    private DestinosRepository destinosRepository;

    @GetMapping
    public List<Destinos> getAllDestinos(){
        return destinosRepository.findAll();
    }

    //create Destinos REST API
    @PostMapping
    public Destinos createDestino(@RequestBody Destinos destino){
        return destinosRepository.save(destino);
    }

    //get Destinos by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Destinos> getDestinoById(@PathVariable int id){
        Destinos destino = destinosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));
        return ResponseEntity.ok(destino);
    }

    //update Destinos REST API
    @PutMapping("{id}")
    public ResponseEntity<Destinos> updateDestino(@PathVariable int id, @RequestBody Destinos destinoDetails){
        Destinos updateDestino = destinosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));

        updateDestino.setNome(destinoDetails.getNome());
        updateDestino.setPreco(destinoDetails.getPreco());
        updateDestino.setPrecoPromocao(destinoDetails.getPrecoPromocao());

        destinosRepository.save(updateDestino);

        return ResponseEntity.ok(updateDestino);
    }

    //delete Destinos REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDestino(@PathVariable int id){

        Destinos destino = destinosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));

        destinosRepository.delete(destino);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
