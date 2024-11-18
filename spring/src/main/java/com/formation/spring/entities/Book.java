package com.formation.spring.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id", nullable = false)
    private BookDetails bookDetails;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = true)
    private List<Review> reviews;


    public Book() {
    }

    public Book(String name, String author, Integer price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public BookDetails getDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails details) {
        this.bookDetails = details;
    }

    public List<Review> getReviews(){
        return this.reviews;
    }

    public void setReviews(List<Review> reviews){
        this.reviews = reviews;
    }

}
