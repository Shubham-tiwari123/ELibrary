package com.springpro.elibrary.entity;

public class IssueBook {
    
    private String bookRegNo;
    private String studentId;
    private String studentName;
    private String mobileNo;

    public IssueBook() {
    }

    public IssueBook(String bookRegNo, String studentId, String studentName, String mobileNo) {
        this.bookRegNo = bookRegNo;
        this.studentId = studentId;
        this.studentName = studentName;
        this.mobileNo = mobileNo;
    }
    
    
    public String getBookRegNo() {
        return bookRegNo;
    }

    public void setBookRegNo(String bookRegNo) {
        this.bookRegNo = bookRegNo;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    
}
