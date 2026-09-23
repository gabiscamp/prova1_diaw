package com.example.Prova1.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Prova1.model.Candidato;
import com.example.Prova1.service.CandidatosTseService; 
@Controller
public class CandidatosTseController{

    private final CandidatosTseService candidatoService;

    public CandidatosTseController(CandidatosTseService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String cargo, @RequestParam(required = false) String partido, @RequestParam(required = false) String texto , Model model ) {
        if(cargo != null || partido != null || texto != null){
            IO.print(candidatoService.filtrar(cargo, partido, texto));
           return "index";     
        }
        
        IO.print(candidatoService.listarTodos());
        return "index";
    }

    @GetMapping("/listarCargos")
    public String listarCargos(@RequestParam(required = false) String cargo) {
        if(cargo != null){
           IO.print( candidatoService.listarCargos());
        }
        return "Nenhum selecionado";
    }
    
    
}
