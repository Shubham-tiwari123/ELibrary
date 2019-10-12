package com.springpro.elibrary.dao;

import com.springpro.elibrary.entity.AddBook;
import com.springpro.elibrary.entity.IssueBook;
import com.springpro.elibrary.entity.LoginDetails;
import com.springpro.elibrary.entity.ReturnBook;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibrarianFunctionDao extends DbConnenction{
    
    private int CODE;
    
    public ResultSet checkDetails(LoginDetails details) throws SQLException{
        initializeDbConnection();
        resultSet = smt.executeQuery("SELECT * FROM E_LIBRARIAN WHERE Email='"+details.getEmail()+"'");
        return resultSet;
    }
    
    public int saveBook(AddBook book){
        try {
            initializeDbConnection();
            int qnt = Integer.parseInt(book.getQunt());
            int code =smt.executeUpdate("INSERT INTO E_BOOK (CALLNO,NAME,AUTHOR,PUBLISHER,QUANTITY) VALUES"
                    + " ('"+book.getBookRefNo()+"','"+book.getBookName()+"','"+book.getAuthorName()+"',"
                    + "'"+book.getPublisher()+"',"+qnt+")");
            if(code>0)
                CODE=200;
            else
                CODE=404;
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianFunctionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CODE;
    }
    
    public List viewBook(){
        List<AddBook> list= new ArrayList<>();
        try {
            initializeDbConnection();
            resultSet = smt.executeQuery("SELECT * FROM E_BOOK");
            while(resultSet.next()){
                AddBook obj = new AddBook(resultSet.getString("CALLNO"), 
                        resultSet.getString("NAME"), resultSet.getString("AUTHOR"), 
                        resultSet.getString("PUBLISHER"), String.valueOf(resultSet.getInt("QUANTITY")), 
                        String.valueOf(resultSet.getInt("ISSUED")));
                list.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("ex:-"+ex);
        }
        return list;
    }
    
    public int issueBook(IssueBook book){
        try {
            initializeDbConnection();
            long phone = Long.parseLong(book.getMobileNo());
            connection.setAutoCommit(false);
            
            resultSet = smt.executeQuery("SELECT * FROM E_BOOK WHERE CALLNO='"+book.getBookRegNo()+"'");
            System.out.println("11111");
            int val=0,qnt=0;
            String status="";
            while(resultSet.next()){
                val = resultSet.getInt("ISSUED");
                qnt = resultSet.getInt("QUANTITY");
            }
            resultSet = smt.executeQuery("SELECT * FROM E_ISSUEBOOK WHERE (CALLNO='"
                    +book.getBookRegNo()+"' AND STUDENTID='"+book.getStudentId()+"' )");
            System.out.println("22222");
            while(resultSet.next()){
                status = resultSet.getString("RETURNSTATUS");
            }
            val=val+1;
            if(qnt>=val && !"NO".equals(status)){
                int code =smt.executeUpdate("INSERT INTO E_ISSUEBOOK (CALLNO,STUDENTID,STUDENTNAME,STUDENTMOBILE) VALUES"
                    + " ('"+book.getBookRegNo()+"','"+book.getStudentId()+"','"+book.getStudentName()+"',"+phone+")");
            
                int code2 = smt.executeUpdate("UPDATE E_BOOK SET ISSUED="+val+" WHERE CALLNO='"+book.getBookRegNo()+"'");
                connection.commit();
                if(code>0 && code2>0)
                    CODE=200;
                else
                    CODE=404;
            }
            else
                CODE=404;
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianFunctionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CODE;
    }
    
    public int returnBook(ReturnBook book){
        try {
            initializeDbConnection();
            connection.setAutoCommit(false);
            String yes="YES";
            resultSet = smt.executeQuery("SELECT * FROM E_BOOK WHERE CALLNO='"+book.getBookRefNo()+"'");
            int val=0,qnt=0;
            while(resultSet.next()){
                val = resultSet.getInt("ISSUED");
                qnt = resultSet.getInt("QUANTITY");
            }
            val=val-1;
            if(val>=0){
                int code =smt.executeUpdate("UPDATE E_ISSUEBOOK SET RETURNSTATUS = '"+yes+"' WHERE (CALLNO='"+
                        book.getBookRefNo()+"' AND STUDENTID='"+book.getStudentId()+"')");
            
                int code2 = smt.executeUpdate("UPDATE E_BOOK SET ISSUED="+val+" WHERE CALLNO='"+book.getBookRefNo()+"'");
                connection.commit();
                if(code>0 && code2>0)
                    CODE=200;
                else
                    CODE=404;
            }
            else
                CODE=404;
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianFunctionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CODE;
    }
}
