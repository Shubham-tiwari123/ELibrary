package com.springpro.elibrary.controller;

import com.springpro.elibrary.controller.LibrarianLoginService;
import com.springpro.elibrary.controller.LibrarianService;
import com.springpro.elibrary.entity.AddBook;
import com.springpro.elibrary.entity.IssueBook;
import com.springpro.elibrary.entity.LoginDetails;
import com.springpro.elibrary.entity.ReturnBook;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LibrarianSideController {

    @Autowired
    LibrarianLoginService loginService;
    
    @Autowired
    LibrarianService service;
    
    @RequestMapping("/welcomeLibrarian")
    public ModelAndView librarianLogin(LoginDetails details) {
        ModelAndView modelAndView = new ModelAndView();
        if(loginService.checkDetails(details)==200){
            modelAndView.setViewName("librarian/librariancarousel.jsp");
        }
        else{
            modelAndView.setViewName("/index.jsp");
        }
        return modelAndView;
    }
    
    @RequestMapping("/home")
    public ModelAndView librarianHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("librarian/librariancarousel.jsp");
        return modelAndView;
    }

    @RequestMapping("/addBook")
    public ModelAndView addBook() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("librarian/addbookform.jsp");
        return modelAndView;
    }

    @RequestMapping("/saveBook")
    public ModelAndView saveBook(AddBook addBook) {
        ModelAndView modelAndView = new ModelAndView();
        if(service.saveNewBook(addBook)==200){
            modelAndView.addObject("msg", "Book added");
            modelAndView.setViewName("librarian/addbookform.jsp");
        }
        else{
            modelAndView.addObject("msg", "Error Can not save data....");
            modelAndView.setViewName("librarian/addbookform.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/viewBook")
    public ModelAndView viewBook() {
        List<AddBook> list = service.viewBook();
        ModelAndView modelAndView = new ModelAndView();
        if(list.isEmpty()){
            modelAndView.addObject("msg","No book present");
            modelAndView.setViewName("librarian/viewbook.jsp");
        }
        else{
            modelAndView.addObject("msg",list);
            modelAndView.setViewName("librarian/viewbook.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/issueBookform")
    public ModelAndView issueBookform() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("librarian/issuebook.jsp");
        return modelAndView;
    }

    @RequestMapping("/issueBook")
    public ModelAndView issueBook(IssueBook details) {
        ModelAndView modelAndView = new ModelAndView();
        if(service.issueNewBook(details)==200){
            modelAndView.addObject("msg", "Book issued");
            modelAndView.setViewName("librarian/issuebook.jsp");
        }
        else{
            modelAndView.addObject("msg", "Error...can't issue book");
            modelAndView.setViewName("librarian/issuebook.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/returnBookForm")
    public ModelAndView returnBookForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("librarian/returnbook.jsp");
        return modelAndView;
    }

    @RequestMapping("/returnBook")
    public ModelAndView returnBook(ReturnBook details) {
        ModelAndView modelAndView = new ModelAndView();
        if(service.returnBook(details)==200){
            modelAndView.addObject("msg", "Book returned");
            modelAndView.setViewName("librarian/returnbook.jsp");
        }
        else{
            modelAndView.addObject("msg", "Error...can't return book");
            modelAndView.setViewName("librarian/returnbook.jsp");
        }
        return modelAndView;
    }
}
