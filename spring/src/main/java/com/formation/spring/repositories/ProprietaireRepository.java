package com.formation.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.formation.spring.entities.Proprietaire;

import java.util.List;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {

    @Query("SELECT DISTINCT p FROM Proprietaire p JOIN p.carte_grise v WHERE v.marque = :marque")
    List<Proprietaire> findProprietairesByCarteGriseMarque(@Param("marque") String marque);
}
