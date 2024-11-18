package com.formation.spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int pageCount;

    @Column(nullable = true)
    private String publisher;

    @OneToOne(mappedBy = "bookDetails")
    private Book book;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BookDetails() {
    }

    public BookDetails(int pageCount, String publisher) {
        this.pageCount = pageCount;
        this.publisher = publisher;
    }
}
