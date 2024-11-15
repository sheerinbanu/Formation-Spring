package com.formation.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.spring.entities.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);

    List<Book> findByNameAndPrice(String name, int price);

    List<Book> findByPriceGreaterThan(Double minPrice);
    List<Book> findByNameAndPriceBetween(String name, Double minPrice, Double maxPrice);
    List<Book> findAllByOrderByPriceAsc();

}