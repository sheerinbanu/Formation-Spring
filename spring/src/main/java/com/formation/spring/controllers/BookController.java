package com.formation.spring.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.formation.spring.entities.Book;
import com.formation.spring.entities.BookDetails;
import com.formation.spring.exceptions.BookNotFoundException;
import com.formation.spring.exceptions.NegativePriceException;
import com.formation.spring.repositories.BookRepository;
import com.formation.spring.services.BookService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book findOneBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        if (updatedBook.getPrice() < 0) {
            throw new NegativePriceException();
        }
        Book oldBook = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        oldBook.setAuthor(updatedBook.getAuthor());
        oldBook.setName(updatedBook.getName());
        oldBook.setPrice(updatedBook.getPrice());
        return bookRepository.save(oldBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    @GetMapping("/author")
    public List<Book> findByAuthor(@RequestParam String author) {
        return bookRepository.findByAuthor(author);
    }

    @GetMapping("/search")
    public List<Book> findByNameAndPrice(@RequestParam String name, @RequestParam int price) {
        return entityManager
                .createQuery("SELECT b FROM Book b WHERE b.name = :name AND b.price = :price", Book.class)
                .setParameter("name", name)
                .setParameter("price", price)
                .getResultList();
    }

    @GetMapping("/search-jpa")
    public List<Book> findByNameAndPriceJPA(@RequestParam String name, @RequestParam int price) {
        return bookRepository.findByNameAndPrice(name, price);
    }

    @GetMapping("/find-minimum-query")
    public List<Book> getProductsAbovePrice(@RequestParam Double minPrice) {
        String query = "SELECT p FROM Product p WHERE p.price > :minPrice";
        return entityManager.createQuery(query, Book.class)
                .setParameter("minPrice", minPrice)
                .getResultList();
    }

    @GetMapping("/find-minimum")
    public List<Book> getBooksAbovePrice(@RequestParam Double minPrice) {
        return bookRepository.findByPriceGreaterThan(minPrice);
    }

    @GetMapping("/find-range-query")
    public List<Book> getProductsInPriceRange(
            @RequestParam String name,
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        String query = "SELECT p FROM Book p WHERE p.name = :name AND p.price BETWEEN :minPrice AND :maxPrice";
        return entityManager.createQuery(query, Book.class)
                .setParameter("name", name)
                .setParameter("minPrice", minPrice)
                .setParameter("maxPrice", maxPrice)
                .getResultList();
    }

    @GetMapping("/find-range")
    public List<Book> getBooksInPriceRange(
            @RequestParam String name,
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        return bookRepository.findByNameAndPriceBetween(name, minPrice, maxPrice);
    }

    @GetMapping("/sorted-query")
    public List<Book> getBooksSortedByPriceQuery() {
        String query = "SELECT p FROM Book p ORDER BY p.price ASC";
        return entityManager.createQuery(query, Book.class).getResultList();
    }

    @GetMapping("/sorted")
    public List<Book> getBooksSortedByPrice() {
        return bookRepository.findAllByOrderByPriceAsc();
    }

    @PutMapping("/{id}/details")
    public Book updateBookDetails(Long id,@RequestBody BookDetails details){
        return bookService.updateBookDetails(id, details);
    }

    @PostMapping("/details")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createWithDetails(@RequestBody Book book) {
      return bookService.createBookWithDetails(book);
    }
}
