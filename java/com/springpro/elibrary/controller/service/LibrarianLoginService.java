package com.springpro.elibrary.controller.service;

import com.springpro.elibrary.controller.dao.LibrarianFunctionDao;
import com.springpro.elibrary.entity.LoginDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class LibrarianLoginService {
    
    LibrarianFunctionDao dao;

    public LibrarianLoginService() {
        dao = new LibrarianFunctionDao();
    }
    
    
    public int checkDetails(LoginDetails details){
        int code=404;
        try {
            ResultSet rs = dao.checkDetails(details);
            while(rs.next()){
                if(details.getEmail().equals(rs.getString("Email")) && 
                        details.getPass().equals(rs.getString("Pass")))
                    code=200;
                else
                    code=404;
            }
        } catch (SQLException ex) {
            System.out.println("ex:-"+ex);
        }
        return code;
    }
}
