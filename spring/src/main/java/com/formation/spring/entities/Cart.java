package com.formation.spring.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cart;


    Set<Product> products = new HashSet<>();

    public Cart(){

    }

    public Cart(Set<Product> products) {
        this.products = products;
    }

    public Long getId_cart() {
        return id_cart;
    }


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
