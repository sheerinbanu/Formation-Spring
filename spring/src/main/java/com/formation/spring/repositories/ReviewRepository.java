package com.formation.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.spring.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    
}
