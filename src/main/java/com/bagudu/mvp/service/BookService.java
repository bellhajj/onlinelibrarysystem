/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.mvp.service;

import com.bagudu.mvp.model.Book;
import com.bagudu.mvp.repo.BookRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bbagudu
 */
@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    //Save New Book
    public void addBook(Book book) {
        bookRepo.save(book);
    }

    //Edit Book
    public Optional<Book> findById(Long id) {
        return bookRepo.findById(id);
    }

    //Delete Book
    public void delete(Long id) {
        bookRepo.deleteById(id);

    }

    //Return List of client
    public List<Book> getBooks() {
        
        return bookRepo.findAll();
    }
}
