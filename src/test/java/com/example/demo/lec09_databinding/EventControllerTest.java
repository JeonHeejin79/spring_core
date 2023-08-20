package com.example.demo.lec09_databinding;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getTest() throws Exception {
        // 문자로 들어온 1을 숫자로 변환해서 반환한다.
        mockMvc.perform(get("/event/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void getTestNew() throws Exception {
        // 문자로 들어온 1을 숫자로 변환해서 반환한다.
        mockMvc.perform(get("/event/new/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

}