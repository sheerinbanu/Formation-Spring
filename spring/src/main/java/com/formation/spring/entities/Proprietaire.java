package com.formation.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Proprietaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @OneToOne(mappedBy = "proprietaire", cascade = CascadeType.ALL)
    @JsonIgnore
    private CarteGrise carte_grise;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public CarteGrise getCarteGrise() {
        return carte_grise;
    }

    public void setCarteGrise(CarteGrise carteGrise) {
        this.carte_grise = carteGrise;
        carteGrise.setProprietaire(this); // Met à jour automatiquement la relation dans l'autre sens
    }
}
