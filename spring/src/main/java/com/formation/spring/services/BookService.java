package com.formation.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.spring.entities.Book;
import com.formation.spring.entities.BookDetails;
import com.formation.spring.exceptions.BookNotFoundException;
import com.formation.spring.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBookWithDetails(Book book){
        BookDetails bookDetails = book.getDetails();
        book.setBookDetails(bookDetails);
        return bookRepository.save(book);
    }
 

    public Book updateBookDetails(Long id, BookDetails newDetails){
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        book.setBookDetails(newDetails);
        return bookRepository.save(book);
    }
    
}
