package com.projeto1.proj.controller;

import com.projeto1.proj.model.carros.CadastraCarros;
import com.projeto1.proj.model.carros.CarrosDTO;
import com.projeto1.proj.model.carros.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private CarrosRepository repository;

    @GetMapping("/modelos")
    public String carregaCarros(){
        return "carros/modelos";
    }

    @PostMapping("/modelos")
    public String cadastraCarros(CadastraCarros dados)
    {
        CarrosDTO F1 = new CarrosDTO(dados);
        repository.save(F1);
        return "redirect:/carros/listagem";
    }

    @GetMapping("/lista")
    public String carregaLista(Model model){
        model.addAttribute("lista", repository.findAll());
        return "/carros/listagem";
    }

}
