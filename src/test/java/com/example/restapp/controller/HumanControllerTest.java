package com.example.restapp.controller;

import com.example.restapp.entity.Human;
import com.example.restapp.service.HumanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HumanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HumanController humanController;

    @Autowired
    private HumanService humanService;


    @Test
    public void connectionTest() throws Exception {
        Human human = new Human("Peter", "Peterson", "01.01.2000");
        humanService.saveHuman(human);
        Long id = human.getId();
        mockMvc.perform(get("/"+id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(human.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("age").value(23));
    }

}