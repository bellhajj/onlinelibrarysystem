/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.mvp.controller;

import com.bagudu.mvp.model.Book;
import com.bagudu.mvp.service.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bbagudu
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/book")
    public String viewBookPage(Model model) {
        
        //List<Book> bookList = bookService.getBooks();
	//model.addAttribute("books", bookList);
        return "book";
    }

    @PostMapping("/book")
    public String addClient(Book book) {

        bookService.addBook(book);
        return "redirect:/book";
    }

    @RequestMapping("/book/findbyid")
    @ResponseBody
    public Optional<Book> findById(Long id) {

        return bookService.findById(id);
    }

    @RequestMapping(value = "/book/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateBook(Book book) {
        bookService.addBook(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteBook(Long id) {
        bookService.delete(id);
        return "redirect:/book";
    }

}
