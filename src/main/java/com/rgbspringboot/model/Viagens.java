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
@Table(name = "viagens")
public class Viagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "origem", nullable = false)
    private String origem;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "idDestinos", referencedColumnName = "id"),
            @JoinColumn(name = "destinos", referencedColumnName = "nomeDestino"),
            @JoinColumn(name = "preco", referencedColumnName = "preco"),
            @JoinColumn(name = "precoPromocao", referencedColumnName = "preco_promocao")
    })
    private Destinos destinos;

    @Column(name = "ida", nullable = false)
    private String ida;

    @Column(name = "volta", nullable = false)
    private String volta;

    @Column(name = "nPassageiros", nullable = false)
    private int nPassageiros;

    @Column(name = "classe", nullable = false)
    private String classe;
}
