package com.springpro.elibrary.controller.service;

import com.springpro.elibrary.controller.dao.LibrarianFunctionDao;
import com.springpro.elibrary.entity.AddBook;
import com.springpro.elibrary.entity.IssueBook;
import com.springpro.elibrary.entity.ReturnBook;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService {
    LibrarianFunctionDao dao;

    public LibrarianService() {
        dao = new LibrarianFunctionDao();
    }
    
    public int saveNewBook(AddBook book){
        return dao.saveBook(book);
    }
    
    public List<AddBook> viewBook(){
        return dao.viewBook();
    }
    
    public int issueNewBook(IssueBook book){
        return dao.issueBook(book);
    }
    
    public int returnBook(ReturnBook book){
        return dao.returnBook(book);
    }
    
}
