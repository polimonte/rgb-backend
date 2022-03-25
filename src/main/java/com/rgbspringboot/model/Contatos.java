package com.rgbspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contatos")
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeContato", nullable = false)
    private String nomeCompleto;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mensagem", nullable = false)
    private String mensagem;
}
