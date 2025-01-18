package com.elasticdata.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ExampleApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Check if application context loads successfully")
    void contextLoads() {
        // Context loading test
    }

    @Test
    @DisplayName("Homepage endpoint should return 200 OK") 
    void homepageShouldBeAccessible() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Invalid endpoint should return 404")
    void invalidEndpointShouldReturnNotFound() throws Exception {
        mockMvc.perform(get("/invalid-endpoint"))
               .andExpect(status().isNotFound());
    }

}
