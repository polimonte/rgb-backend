package com.rgbspringboot;

import com.rgbspringboot.model.Destinos;
import com.rgbspringboot.repository.ContatosRepository;
import com.rgbspringboot.repository.DestinosRepository;
import com.rgbspringboot.repository.ViagensCompradasRepository;
import com.rgbspringboot.repository.ViagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RgbBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RgbBackendApplication.class, args);
	}

	@Autowired
	private ContatosRepository contatosRepository;
	@Autowired
	private DestinosRepository destinosRepository;
	@Autowired
	private ViagensRepository viagensRepository;
	@Autowired
	private ViagensCompradasRepository viagensCompradasRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}
