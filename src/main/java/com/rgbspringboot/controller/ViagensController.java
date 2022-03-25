package com.rgbspringboot.controller;

import com.rgbspringboot.exception.ResourceNotFoundException;
import com.rgbspringboot.model.Viagens;
import com.rgbspringboot.repository.DestinosRepository;
import com.rgbspringboot.repository.ViagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/viagens")
public class ViagensController {

    @Autowired
    private ViagensRepository viagensRepository;

    @Autowired
    private DestinosRepository destinosRepository;

    @GetMapping
    public List<Viagens> getAllViagens(){
        return viagensRepository.findAll();
    }

    //create Viagens REST API
    @PostMapping
    public Viagens createViagens(@RequestBody Viagens viagens){
        viagens.setDestinos(destinosRepository.getById(viagens.getDestinos().getId()));
        return viagensRepository.save(viagens);
    }

    //get Viagens by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Viagens> getViagemById(@PathVariable int id){
        Viagens viagens = viagensRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));
        return ResponseEntity.ok(viagens);
    }

    //update Viagens REST API
    @PutMapping("{id}")
    public ResponseEntity<Viagens> updateViagens(@PathVariable int id, @RequestBody Viagens viagemDetails){
        Viagens updateViagem = viagensRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));

        updateViagem.setOrigem(viagemDetails.getOrigem());
        updateViagem.setDestinos(viagemDetails.getDestinos());
        updateViagem.setIda(viagemDetails.getIda());
        updateViagem.setVolta(viagemDetails.getVolta());
        updateViagem.setNPassageiros(viagemDetails.getNPassageiros());
        updateViagem.setClasse(viagemDetails.getClasse());

        viagensRepository.save(updateViagem);

        return ResponseEntity.ok(updateViagem);
    }

    //delete Viagens REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteViagens(@PathVariable int id){

        Viagens viagens = viagensRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));

        viagensRepository.delete(viagens);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
