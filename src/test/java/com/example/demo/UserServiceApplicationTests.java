package com.example.demo;


import com.example.demo.controller.MainController;
import com.example.demo.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(MainController.class)
public class UserServiceApplicationTests {

    /*@Autowired
    private WebApplicationContext context;

    @MockBean
    private UserService userService;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void shouldSaveValidUser() throws Exception {
        this.mockMvc
                .perform(
                        post("/api/v1/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\": \"duke\", \"e_mail\":\"duke@mail.com\"}")
                )
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldNotSaveInvalidUser() throws Exception {
        this.mockMvc
                .perform(
                        post("/api/v1/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\": \"duke\", \"e_mail\":\"duke.mail.com\"}")
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    public void should() throws Exception {
        this.mockMvc
                .perform(
                        put("/api/v1/users/6")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"status\": \"Online\"}")
                )
                .andExpect(status().isNotFound());
    }*/



}