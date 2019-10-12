package com.springpro.elibrary.entity;

public class ReturnBook {
    
    private String bookRefNo;
    private String studentId;

    public ReturnBook() {
    }

    public ReturnBook(String bookRefNo, String studentId) {
        this.bookRefNo = bookRefNo;
        this.studentId = studentId;
    }
    
    public String getBookRefNo() {
        return bookRefNo;
    }

    public void setBookRefNo(String bookRefNo) {
        this.bookRefNo = bookRefNo;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
}
