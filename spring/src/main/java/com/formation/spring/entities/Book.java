package com.formation.spring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private BookDetails bookDetails;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = true)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="book_library", joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="library_id")
    )
    private Set<Library> libraries = new HashSet<>();


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


    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
