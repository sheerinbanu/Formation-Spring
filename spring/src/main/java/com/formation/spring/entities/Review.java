package com.formation.spring.entities;

import jakarta.persistence.*;


@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
        @JoinColumn(name="book_id", referencedColumnName = "id", nullable = false)
        private Book book;


    public Review(){

    }

    public Review(String comment, Book book) {
        this.comment = comment;
        this.book = book;
    }

    public long getId() {
        return id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
