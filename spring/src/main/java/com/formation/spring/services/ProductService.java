package com.formation.spring.services;

import com.formation.spring.entities.Product;
import com.formation.spring.exceptions.ProductNotFoundException;
import com.formation.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //Ajouter un produit
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    //supprimer un produit
    public void removeProduct(Long id_product){
        if(!productRepository.existsById(id_product)){
            throw new ProductNotFoundException();
        }
        productRepository.deleteById(id_product);
    }
}
