/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.mvp.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bbagudu
 */

@Entity
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String rev_num;
    private LocalDate pub_date;
    private String publisher;
    private String author;
    private LocalDate date_added;
    private String genre;
    private String coverImageUrl;

    public Book(){

    }

    public Book(String title, String isbn, String rev_num, LocalDate pub_date, String publisher, String author, LocalDate date_added, String genre, String coverImageUrl){

        this.title = title;
        this.rev_num = rev_num;
        this.isbn = isbn;
        this.pub_date = pub_date;
        this.publisher = publisher;
        this.author = author;
        this.date_added = date_added;
        this.genre = genre;
        this.coverImageUrl = coverImageUrl;

    }

    public void setId(Long id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setRevNum(String rev_num){
        this.rev_num = rev_num;
    }

    public void setPubDate(LocalDate pub_date){
        this.pub_date = pub_date;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setDateAdded(LocalDate date_added){
        this.date_added = date_added;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setCoverImageUrl(String coverImageUrl){
        this.coverImageUrl = coverImageUrl;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public Long getId(){
        return id;
    }

    public String getIsnb(){
        return isbn;
    }

    public String getRevNum(){
        return rev_num;
    }

    public LocalDate getPubDate(){
        return pub_date;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getAuthor(){
        return author;
    }

    public LocalDate getDateAdded(){
        return date_added;
    }

    public String getGenre(){
        return genre;
    }

    public String getCoverImageUrl(){
        return coverImageUrl;
    }

    public String getTitle(){
        return title;
    }
}
