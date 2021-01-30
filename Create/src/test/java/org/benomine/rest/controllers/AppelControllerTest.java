package org.benomine.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.benomine.rest.models.Appel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
public class AppelControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void postAppelShouldReturnCreatedAndId() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/conversion/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new Appel(null,"test", "test", 1, Date.from(Instant.now()))))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
