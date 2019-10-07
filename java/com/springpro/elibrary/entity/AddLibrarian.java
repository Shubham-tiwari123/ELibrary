package com.springpro.elibrary.entity;

public class AddLibrarian {
    
    private String name;
    private String email;
    private String pass;
    private String number;

    public AddLibrarian() {
    }

    public AddLibrarian(String name, String email, String pass, String number) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
