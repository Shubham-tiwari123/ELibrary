package com.springpro.elibrary.controller.dao;

import com.springpro.elibrary.entity.AddLibrarian;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminFunctionDao extends DbConnenction{
    
    private int CODE;
    
    public int saveLibrarian(AddLibrarian details){
        try {
            initializeDbConnection();
            long number = Long.parseLong(details.getNumber());
            int code = smt.executeUpdate("INSERT INTO E_LIBRARIAN (NAME,PASS,EMAIL,MOBILE) VALUES('"+details.getName()+"',"
                    + "'"+details.getPass()+"','"+details.getEmail()+"',"+number+")");
            if(code>0)
                CODE=200;
            else
                CODE=404;
        } catch (SQLException ex) {
            System.out.println("ex:-"+ex);
        }
        return CODE;
    }
    
    public List getAllLibrarian(){
        initializeDbConnection();
        List<AddLibrarian> result = new ArrayList<>();
        try{
            resultSet = smt.executeQuery("SELECT * FROM E_LIBRARIAN");
            while(resultSet.next()){
                AddLibrarian obj = new AddLibrarian(resultSet.getString("NAME"), 
                        resultSet.getString("EMAIL"), resultSet.getString("PASS"), 
                        String.valueOf(resultSet.getLong("MOBILE")));
                result.add(obj);
            }
        }catch(SQLException ex){
            System.out.println("ex:-"+ex);
        }
        return result;
    }
    
    public int  deleteLibrarian(String email){
        
        initializeDbConnection();
        try {
            int code= smt.executeUpdate("DELETE FROM E_LIBRARIAN WHERE Email='"+email+"'");
            if(code>0)
                CODE=200;
            else
                CODE=404;
        } catch (SQLException ex) {
            System.out.println("ex:-"+ex);;
        }
        return CODE;
    }
}
