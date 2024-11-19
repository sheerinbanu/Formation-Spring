package com.formation.spring.controllers;

import com.formation.spring.entities.Book;
import com.formation.spring.entities.Product;
import com.formation.spring.repositories.ProductRepository;
import com.formation.spring.services.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;


    @PersistenceContext
    private EntityManager entityManager;

    //visualiser tous les produits
    @GetMapping()
    public Iterable<Product>  findAllProducts(){
        return productRepository.findAll();
    }

    //Trouver un produit avec son nom et son prix en utilisant le jpaRepository
    @GetMapping("/search")
    public List<Product> finfByNameAndPrice(@RequestParam String name, @RequestParam double price){
        return productRepository.findByNameAndPrice(name,price);
    }

    //Trouver un produit avec son nom et son prix en utilisant le entityManager
    @GetMapping("/searchBy")
    public List<Product> findByNameAndPrice(@RequestParam String name, @RequestParam double price) {
        return entityManager
                .createQuery("SELECT p FROM Product p WHERE p.name = :name AND p.price = :price", Product.class)
                .setParameter("name", name)
                .setParameter("price", price)
                .getResultList();
    }

    //Trouver tous les produits qui coûtent plus de x euros
    @GetMapping("/find-minimum")
    public List<Product> findByPriceGreaterThan(@RequestParam double price){
        return productRepository.findByPriceGreaterThan(price);
    }

    //Trouver les produits ayant le même nom et qui coûtent entre x et y euros
    @GetMapping("find-range")
    public List<Product> findByNameAndPriceBetween(@RequestParam String name, @RequestParam double minPrice, @RequestParam double maxPrice){
        return productRepository.findByNameAndPriceBetween(name, minPrice,maxPrice);
    }

    //Trouver les produits par prix ascendants
    @GetMapping("sorted-price")

    //supprimer un produit
    @DeleteMapping("{id_product}")
    @ResponseStatus(HttpStatus.OK)
    public void dremoveProduct(@PathVariable Long id_product){
        productService.removeProduct(id_product);
    }


}
