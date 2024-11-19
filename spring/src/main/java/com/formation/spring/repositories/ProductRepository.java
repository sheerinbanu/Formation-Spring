package com.formation.spring.repositories;

import com.formation.spring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameAndPrice(String name, double price);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByNameAndPriceBetween(String name, double minPrice, double maxPrice);
    List<Product> findAllByOrderByPriceAsc();
}
