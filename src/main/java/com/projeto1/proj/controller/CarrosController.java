package com.projeto1.proj.controller;

import com.projeto1.proj.model.carros.CadastraCarros;
import com.projeto1.proj.model.carros.CarrosDTO;
import com.projeto1.proj.model.carros.CarrosRepository;
import com.projeto1.proj.model.carros.DadosAlteracaoCarros;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private CarrosRepository repository;

    @GetMapping("/modelos")
    public String carregaCarros(Long id, Model model){
        if(id != null){
            CarrosDTO C1 = repository.getReferenceById(id);
            model.addAttribute("carrosDTO", C1);
        }
        return "/carros/modelos";
    }

    @PostMapping("/modelos")
    public String cadastraCarros(CadastraCarros dados)
    {
        CarrosDTO F1 = new CarrosDTO(dados);
        repository.save(F1);
        return "redirect:/carros/listagem";
    }

    @PutMapping("/modelos")
    @Transactional
    public String alteraCarros(DadosAlteracaoCarros dados){
        CarrosDTO carro = repository.getReferenceById((dados.id()));
        carro.atualizaDados(dados);
        repository.save(carro);
        return "redirect:/carros/lista";
    }

    @GetMapping("/lista")
    public String carregaLista(Model model){
        model.addAttribute("lista", repository.findAll());
        return "/carros/listagem";
    }

    @DeleteMapping
    @Transactional
    public String removeCarro(Long id) {
        repository.deleteById(id);
        return "redirect:/carros/lista";
    }

}
