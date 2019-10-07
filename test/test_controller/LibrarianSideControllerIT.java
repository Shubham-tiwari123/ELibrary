package com.springpro.elibrary.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springpro.elibrary.entity.LoginDetails;
import com.springpro.elibrary.service.LibrarianService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LibrarianSideControllerIT {
    
    @Autowired
    MockMvc mvc;
    
    @Autowired
    LibrarianService service;
    
    @Test
    public void testLibrarianLogin() throws Exception {
        LoginDetails details = new LoginDetails("s890@gmail.com", "qwer");
        ObjectMapper mapper = new ObjectMapper();
        String detail = mapper.writeValueAsString(details);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/welcomeLibrarian")
                .content(detail))
                .andReturn();
        int code = result.getResponse().getStatus();
        assertEquals(200, code);
    }
    
    
    @Test
    public void testLibrarianHomePage() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/home"))
                .andReturn();
        int code = result.getResponse().getStatus();
        assertEquals(200, code);
    }
}
