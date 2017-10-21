package com.niraj.learn;

import java.io.Serializable;

/**
 * Created by niraj on 26/9/17.
 */

public class BookModel implements Serializable {
    private String bookname;
    private String subject;
    private String author;
    private String edition;
    private String publisher;
    private String link;
    private String contributer;
    private Integer id;



    public BookModel(String bookname, String subject,String author,String edition,String publisher,String link,String contributer) {
        super();
        this.bookname = bookname;
        this.subject = subject;
        this.author = author;
        this.edition = edition;
        this.publisher = publisher;
        this.contributer = contributer;
        this.link=link;
        this.id=0;
    }

    public BookModel(String bookname, String subject,String author,String edition,String publisher,String link,String contributer,Integer id) {
        super();
        this.bookname = bookname;
        this.subject = subject;
        this.author = author;
        this.edition = edition;
        this.publisher = publisher;
        this.contributer = contributer;
        this.link=link;
        this.id=id;
    }

    public String getBookname() {
        return bookname;
    }

    public String getSubject() {
        return subject;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLink() {
        return link;
    }

    public String getContributer() {
        return contributer;
    }

    public Integer getId(){ return id;}





}
