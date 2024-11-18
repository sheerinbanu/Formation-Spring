package com.formation.spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;


    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Book book;

    public Review(){

    }

    public Review (String comment, Book book){
        this.book = book;
        this.comment = comment; 
    }

    public Book getBook(){
        return this.book;
    }

    public void setBook(Book book){
        this.book = book;
    }

    public String getComment(){
        return this.comment;
    }

    public void setBook(String comment){
        this.comment = comment;
    }
    
}
