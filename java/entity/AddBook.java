package com.springpro.elibrary.entity;

public class AddBook {
    
    private String bookRefNo;
    private String bookName;
    private String authorName;
    private String publisher;
    private String qunt;
    private String issuedBook;

    public AddBook() {
    }

    public AddBook(String bookRefNo, String bookName, String authorName, String publisher, String qunt) {
        this.bookRefNo = bookRefNo;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisher = publisher;
        this.qunt = qunt;
    }
    
    public AddBook(String bookRefNo, String bookName, String authorName, String publisher, String qunt,
            String issuedBook) {
        this.bookRefNo = bookRefNo;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisher = publisher;
        this.qunt = qunt;
        this.issuedBook = issuedBook;
    }

    
    public String getBookRefNo() {
        return bookRefNo;
    }

    public void setBookRefNo(String bookRefNo) {
        this.bookRefNo = bookRefNo;
    }

    public String getIssuedBook() {
        return issuedBook;
    }

    public void setIssuedBook(String issuedBook) {
        this.issuedBook = issuedBook;
    }
    
    
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getQunt() {
        return qunt;
    }

    public void setQunt(String qunt) {
        this.qunt = qunt;
    }
    
    
}
