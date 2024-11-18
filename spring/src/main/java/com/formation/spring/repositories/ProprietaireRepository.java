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

    @Query("SELECT p FROM Proprietaire p JOIN p.carte_grise c WHERE c.marque = :marque AND c.numero LIKE :numeroPrefix")
    List<Proprietaire> findProprietairesByMarqueAndNumeroPrefix(@Param("marque") String marque,
            @Param("numeroPrefix") String numeroPrefix);

}
