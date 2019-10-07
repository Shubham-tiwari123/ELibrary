package com.springpro.elibrary.controller.service;

import com.springpro.elibrary.entity.LoginDetails;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {
    
    public boolean verifyAdmin(LoginDetails details){
        return details.getEmail().equals("st@gmail.com") && details.getPass().equals("shubham");
    } 
}
