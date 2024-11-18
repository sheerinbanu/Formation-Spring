package com.formation.spring.services;

import com.formation.spring.entities.Review;
import com.formation.spring.exceptions.ReviewNotFoundException;
import com.formation.spring.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    private ReviewRepository reviewRepository;

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

    @Transactional //A début ça  a marché, si on plein milieu j 1 erreur, annulle tt ce que j fait
    public Book addReviewToBook(Long bookId, Review review){
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        review.setBook(book);
        book.getReviews().add(review);
        reviewRepository.save(review);
        return bookRepository.save(book);
    }

    @Transactional
    public Book removeReviewToBook(Long book_id, Long review_Id){
        Book book = bookRepository.findById(book_id).orElseThrow(BookNotFoundException::new);
        Review review = reviewRepository.findById(review_Id).orElseThrow(ReviewNotFoundException::new);

        if(review.getBook().equals(book)){
            book.getReviews().remove(review);
            reviewRepository.delete(review);
        }else {
            throw new RuntimeException("Review does not belong to the book");
        }
        return bookRepository.save(book);
    }
}
