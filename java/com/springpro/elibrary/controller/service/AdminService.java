package com.springpro.elibrary.controller.service;

import com.springpro.elibrary.controller.dao.AdminFunctionDao;
import com.springpro.elibrary.entity.AddLibrarian;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    AdminFunctionDao adminDao;

    public AdminService() {
        this.adminDao = new AdminFunctionDao();
    }
    
    
    public int addNewLibrarian(AddLibrarian details){
        return adminDao.saveLibrarian(details);
    }
    
    public List<AddLibrarian> viewLibrarian(){
        return adminDao.getAllLibrarian();
    }
    
    public int deleteLibrarian(String email){
        return adminDao.deleteLibrarian(email);
    }
}
