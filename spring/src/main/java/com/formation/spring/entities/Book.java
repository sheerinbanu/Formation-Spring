package com.formation.spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public void setName(String newName){
        this.name=newName;
    }

    public void setAuthor(String newAuthor){
        this.author=newAuthor;
    }
    
    
}
