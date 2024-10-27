package com.projeto1.proj.model.carros;

import com.projeto1.proj.model.modelos.ModelosDTO;
import jakarta.persistence.*;

@Entity
@Table(name="carrosDTO")
public class CarrosDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "idModelo")
    private ModelosDTO modelo;

    public ModelosDTO getModelo() {
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

    public void atualizaDados(DadosAlteracaoCarros dados){
        this.nome = dados.nome();
        this.modelo = dados.modelo();
    }

}
