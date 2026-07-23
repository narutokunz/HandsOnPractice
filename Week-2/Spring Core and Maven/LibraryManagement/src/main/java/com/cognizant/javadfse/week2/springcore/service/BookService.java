package com.cognizant.javadfse.week2.springcore.service;

import com.cognizant.javadfse.week2.springcore.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageLibrary() {
        System.out.println("BookService invoked via setter injection.");
        System.out.println("Retrieved book: " + bookRepository.findBookTitle());
    }
}
