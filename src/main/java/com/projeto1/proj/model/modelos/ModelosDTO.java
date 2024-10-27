package com.projeto1.proj.model.modelos;

import com.projeto1.proj.model.carros.CarrosDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="modelosDTO")
public class ModelosDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModelo;
    private String nomeModelo;

    @OneToMany(mappedBy = "modelo")
    private List<CarrosDTO> listaModelos = new ArrayList<>();

    public Long getIdModelo() {
        return idModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public List<CarrosDTO> getListaModelos() {
        return listaModelos;
    }

    public ModelosDTO(CadastroModelo modelo) {
        this.nomeModelo = modelo.nomeModelo();
    }

    public void atualizaDados(DadosAlteracaoModelo dados){
        this.nomeModelo = dados.nomeModelo();
    }

    public ModelosDTO() {}
}
