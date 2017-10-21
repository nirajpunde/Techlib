package com.niraj.learn.dummy;

/**
 * Created by niraj on 12/10/17.
 */

public class Validator {
    private String bookname;
    private String subject;
    private String author;
    private String edition;
    private String publisher;
    private String link;
    private String contributer;

    public Validator(String bookname, String subject,String author,String edition,String publisher,String link,String contributer) {
        super();
        this.bookname = bookname;
        this.subject = subject;
        this.author = author;
        this.edition = edition;
        this.publisher = publisher;
        this.contributer = contributer;
        this.link=link;
    }

    public boolean isvalid()
    {
        if(this.bookname.length()==0)
        {
            return false;
        }
        if(this.subject.length()==0)
        {
            return false;
        }
        if(this.author.length()==0)
        {
            return false;
        }
        if(this.edition.length()==0)
        {
            return false;
        }
        if(this.publisher.length()==0)
        {
            return false;
        }
        if(!(this.link.contains("https://")&&this.link.contains(".")))
        {
            return false;
        }
        if(this.contributer.length()==0)
        {
            return false;
        }

        return  true;
    }



}
