package com.projeto1.proj.controller;

import com.projeto1.proj.model.modelos.CadastroModelo;
import com.projeto1.proj.model.modelos.DadosAlteracaoModelo;
import com.projeto1.proj.model.modelos.ModelosDTO;
import com.projeto1.proj.model.modelos.ModelosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/modelos")
public class ModelosController {

    @Autowired
    private ModelosRepository repository;

    @GetMapping("/lista")
    public String listaModelos(Model model){
        model.addAttribute("lista", repository.findAll());
        return "/modelos/listagem";
    }

    @PostMapping("/formulario")
    public String cadastraModelo(CadastroModelo dados)
    {
        ModelosDTO G1 = new ModelosDTO(dados);
        repository.save(G1);
        return "redirect:/modelos/lista";
    }

    @DeleteMapping
    @Transactional
    public String removeGenero(Long id) {
        repository.deleteById(id);
        return "redirect:/modelos/lista";
    }

    @GetMapping("/formulario")
    public String carregaFormulario(Long id, Model model){

        if(id != null){
            ModelosDTO M1 = repository.getReferenceById(id);
            model.addAttribute("modelosDTO", M1);
        }
        return "/modelos/formulario";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alterarGenero(DadosAlteracaoModelo dados){
        ModelosDTO G1 = repository.getReferenceById((dados.id()));
        G1.atualizaDados(dados);
        repository.save(G1);
        return "redirect:/modelos/lista";
    }
}
