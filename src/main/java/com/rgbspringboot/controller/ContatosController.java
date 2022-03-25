package com.rgbspringboot.controller;

import com.rgbspringboot.exception.ResourceNotFoundException;
import com.rgbspringboot.model.Contatos;
import com.rgbspringboot.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/contatos")
public class ContatosController {

    @Autowired
    private ContatosRepository contatosRepository;

    @GetMapping
    public List<Contatos> getAllContatos(){
        return contatosRepository.findAll();
    }

    //create Contatos REST API
    @PostMapping
    public Contatos createContato(@RequestBody Contatos contato){
        return contatosRepository.save(contato);
    }

    //get Contatos by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Contatos> getContatoById(@PathVariable int id){
        Contatos contato =contatosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));
        return ResponseEntity.ok(contato);
    }

    //update Contatos REST API
    @PutMapping("{id}")
    public ResponseEntity<Contatos> updateContato(@PathVariable int id, @RequestBody Contatos contatoDetails){
        Contatos updateContato = contatosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));

        updateContato.setNomeCompleto(contatoDetails.getNomeCompleto());
        updateContato.setEmail(contatoDetails.getEmail());
        updateContato.setMensagem(contatoDetails.getMensagem());

        contatosRepository.save(updateContato);

        return ResponseEntity.ok(updateContato);
    }

    //delete Contatos REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteContato(@PathVariable int id){

        Contatos contato =contatosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com id: " + id + " não foi encontrado"));

        contatosRepository.delete(contato);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
