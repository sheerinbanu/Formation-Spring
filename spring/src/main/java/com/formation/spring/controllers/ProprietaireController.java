package com.formation.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.formation.spring.entities.Proprietaire;
import com.formation.spring.repositories.ProprietaireRepository;

import java.util.List;

@RestController
@RequestMapping("/api/proprietaires")
public class ProprietaireController {

    @Autowired
    private ProprietaireRepository proprietaireRepository;

    @GetMapping("/par-marque")
    public List<Proprietaire> getProprietairesByCarteGriseMarque(@RequestParam String marque) {
        return proprietaireRepository.findProprietairesByCarteGriseMarque(marque);
    }
}
