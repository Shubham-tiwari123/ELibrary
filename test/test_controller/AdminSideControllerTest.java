package com.springpro.elibrary.controller;

import com.springpro.elibrary.entity.AddLibrarian;
import com.springpro.elibrary.service.AdminLoginService;
import com.springpro.elibrary.service.AdminService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = AdminSideController.class)
public class AdminSideControllerTest {
    
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    AdminLoginService loginService;
    
    @MockBean
    AdminService adminService;
    
    @Test
    public void testGetIndexPage() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/").
                accept(MediaType.APPLICATION_JSON_VALUE)).
                andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
    }
    

    @Test
    public void testAdminLoginPage() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/homepage").
                accept(MediaType.APPLICATION_JSON_VALUE)).
                andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testAddLibrarianPage() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/addLibrarian").
                accept(MediaType.APPLICATION_JSON_VALUE)).
                andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testViewLibrarian() throws Exception {
        List<AddLibrarian> list = new ArrayList<>();
        list.add(new AddLibrarian("Shubham", "st@gmail.com", "123", "1234"));
        when(adminService.viewLibrarian()).thenReturn(list);
        
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/viewLibrarian").
                accept(MediaType.APPLICATION_JSON_VALUE)).
                andReturn();
        int value = list.size();
        assertEquals(1, value);
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testDeleteLibrarian() throws Exception {
        List<AddLibrarian> list = new ArrayList<>();
        when(adminService.viewLibrarian()).thenReturn(list);
        when(adminService.deleteLibrarian("st@gmail.com")).thenReturn(200);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/deleteLibrarian/st@gmail.com").
                accept(MediaType.APPLICATION_JSON_VALUE)).
                andReturn();
        assertEquals(0,list.size());
    }
    
}
