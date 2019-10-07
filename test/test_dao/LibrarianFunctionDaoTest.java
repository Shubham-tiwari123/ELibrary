package com.springpro.elibrary.dao;

import com.springpro.elibrary.dao.LibrarianFunctionDao;
import com.springpro.elibrary.dao.DbConnenction;
import com.springpro.elibrary.entity.AddBook;
import com.springpro.elibrary.entity.IssueBook;
import com.springpro.elibrary.entity.ReturnBook;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class LibrarianFunctionDaoTest {
    
    LibrarianFunctionDao dao = new LibrarianFunctionDao();
    
    @Test
    public void testSaveBook() throws SQLException {
        DbConnenction.setCONNECTION("jdbc:mysql://127.0.0.1/test");
        AddBook book = new AddBook("12345", "Maths", "RS", "NCERT", "20");
        int code = dao.saveBook(book);
        assertEquals(200, code);
    }
    
    @Test
    public void testViewBook() throws SQLException {
        DbConnenction dc = new DbConnenction();
        dc.initializeDbConnection();
        dc.resultSet = dc.smt.executeQuery("SELECT * FROM E_BOOK");
        int count = 0;
        while (dc.resultSet.next()) {
            count++;
        }
        List<AddBook> list = dao.viewBook();
        assertEquals(count, list.size());
    }
    
    @Test
    public void testIssueBook(){
        DbConnenction.setCONNECTION("jdbc:mysql://127.0.0.1/test");
        IssueBook book = new IssueBook("12345", "1234", "Shubham", "09004318447");
        int code = dao.issueBook(book);
        assertEquals(200, code);
    }
    
    @Test
    public void testReturnBook(){
        DbConnenction.setCONNECTION("jdbc:mysql://127.0.0.1/test");
        ReturnBook book = new ReturnBook("12345", "1234");
        int code = dao.returnBook(book);
        assertEquals(200, code);
    }
}
