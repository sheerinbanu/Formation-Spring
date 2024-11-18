package com.formation.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.spring.entities.BookDetails;

public interface BookDetailsRepository extends JpaRepository<BookDetails, Long>{
    
}
