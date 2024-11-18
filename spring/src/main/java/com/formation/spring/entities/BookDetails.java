package com.formation.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="book_details")
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "page_count",nullable = false)
    private int pageCount;

    @Column(nullable = false)
    private String publisher;

    @OneToOne(mappedBy = "bookDetails")
    @JsonBackReference
    private Book book;

    public BookDetails(){

    }

    public BookDetails(int pageCount, String publisher, Book book) {
        this.pageCount = pageCount;
        this.publisher = publisher;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
