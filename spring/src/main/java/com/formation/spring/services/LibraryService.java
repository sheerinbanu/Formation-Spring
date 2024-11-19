package com.formation.spring.services;

import com.formation.spring.entities.Book;
import com.formation.spring.entities.Library;
import com.formation.spring.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;


}
