package com.rgbspringboot.repository;

import com.rgbspringboot.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatosRepository extends JpaRepository<Contatos, Integer> {
    //all crud database methods
}
