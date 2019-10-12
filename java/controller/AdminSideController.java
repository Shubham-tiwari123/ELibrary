package com.springpro.elibrary.controller;

import com.springpro.elibrary.controller.AdminService;
import com.springpro.elibrary.controller.AdminLoginService;
import com.springpro.elibrary.entity.AddLibrarian;
import com.springpro.elibrary.entity.LoginDetails;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminSideController {
    
    @Autowired
    AdminLoginService loginService;
    
    @Autowired
    AdminService adminService;
    
    @RequestMapping("/")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }

    @RequestMapping("/welcome")
    public ModelAndView adminLogin(LoginDetails adminDetails) {
        ModelAndView modelAndView = new ModelAndView();
        if(loginService.verifyAdmin(adminDetails)){
            modelAndView.setViewName("admin/admincarousel.jsp");
        }
        else{
            modelAndView.addObject("msg","Wrong details");
            modelAndView.setViewName("/index.jsp");
        }
        return modelAndView;
    }
    
    @RequestMapping("/homepage")
    public ModelAndView adminLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admincarousel.jsp");
        return modelAndView;
    }

    @RequestMapping("/addLibrarian")
    public ModelAndView addLibrarian() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "");
        modelAndView.setViewName("admin/addlibrarianform.jsp");
        return modelAndView;
    }

    @RequestMapping("/saveLibrarian")
    public ModelAndView saveNewLibrarian(AddLibrarian details) {
        ModelAndView modelAndView = new ModelAndView();
        if(adminService.addNewLibrarian(details)==200){
            modelAndView.addObject("msg", "Data saved");
            modelAndView.setViewName("admin/addlibrarianform.jsp");
        }
        else{
            modelAndView.addObject("msg", "Error..can not save.");
            modelAndView.setViewName("admin/addlibrarianform.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/viewLibrarian")
    public ModelAndView viewLibrarian() {
        ModelAndView modelAndView = new ModelAndView();
        List<AddLibrarian> result = adminService.viewLibrarian();
        System.out.println("reslut:-"+result);
        if(result.isEmpty()){
            modelAndView.addObject("msg", "No data present");
            modelAndView.setViewName("admin/viewlibrarian.jsp");
        }
        else{
            modelAndView.addObject("msg", result);
            modelAndView.setViewName("admin/viewlibrarian.jsp");
        }
        return modelAndView;
    }
    
    @RequestMapping("/deleteLibrarian/{email}")
    public void deleteLibrarian(@PathVariable String email,HttpServletResponse response) {
        System.out.println("email:-"+email);
        if(adminService.deleteLibrarian(email)==200){
            try {
                response.sendRedirect("/viewLibrarian");
            } catch (IOException ex) {
                System.out.println("ex:-"+ex);
            }
        }
    }
}
