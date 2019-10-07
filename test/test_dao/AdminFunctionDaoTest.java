package com.springpro.elibrary.dao;

import com.springpro.elibrary.entity.AddLibrarian;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminFunctionDaoTest {
    
    private  AdminFunctionDao dao;

    public AdminFunctionDaoTest() {
        dao = new AdminFunctionDao();
    }

    @Test
    public void testSaveLibrarian() throws SQLException {
        DbConnenction.setCONNECTION("jdbc:mysql://127.0.0.1/test");
        AddLibrarian addLibrarian = new AddLibrarian("shiva", "s45@gmail.com", "qwer", "09004318556");
        int code = dao.saveLibrarian(addLibrarian);
        assertEquals(200, code);
    }

    @Test
    public void testGetAllLibrarian() throws SQLException {
        DbConnenction dc = new DbConnenction();
        dc.initializeDbConnection();
        dc.resultSet = dc.smt.executeQuery("SELECT * FROM E_LIBRARIAN");
        int count = 0;
        while (dc.resultSet.next()) {
            count++;
        }
        List<AddLibrarian> list = dao.getAllLibrarian();
        assertEquals(count, list.size());

    }

    @Test
    public void testDeleteLibrarian() {
        DbConnenction.setCONNECTION("jdbc:mysql://127.0.0.1/test");
        int code = dao.deleteLibrarian("s45@gmail.com");
        assertEquals(200, code);
    }

}
