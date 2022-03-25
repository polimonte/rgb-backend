package com.rgbspringboot.repository;

import com.rgbspringboot.model.Destinos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinosRepository extends JpaRepository<Destinos, Integer> {
    // all crud database methods
}
