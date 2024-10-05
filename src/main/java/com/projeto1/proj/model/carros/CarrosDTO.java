package com.projeto1.proj.model.carros;

import jakarta.persistence.*;

@Entity
@Table(name="filmesDTO")
public class CarrosDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String modelo;

    public String getModelo() {
        return modelo;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public CarrosDTO(){}

    public CarrosDTO(CadastraCarros dados){
        this.nome = dados.nome();
        this.modelo = dados.modelo();
    }



}
