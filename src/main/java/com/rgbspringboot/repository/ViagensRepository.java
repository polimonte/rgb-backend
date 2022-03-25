package com.rgbspringboot.repository;

import com.rgbspringboot.model.Viagens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagensRepository extends JpaRepository<Viagens, Integer> {
    //all crud database methods
}
