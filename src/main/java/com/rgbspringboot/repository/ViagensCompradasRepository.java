package com.rgbspringboot.repository;

import com.rgbspringboot.model.ViagensCompradas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagensCompradasRepository extends JpaRepository<ViagensCompradas, Integer> {
    //all crud database methods
}
