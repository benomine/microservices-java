package org.benomine.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.benomine.rest.models.Appel;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
@SpringBootTest
class AppelControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturn0() throws Exception {
        var result = mvc.perform(MockMvcRequestBuilders.post("/api/conversion/temperature")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new Appel("test", "test", 32, DateTime.now().toString(), 0))))
                .andExpect(status().isOk()).andReturn();

        var doubleResult = Double.valueOf(result.getResponse().getContentAsString());
        assertEquals(0.0, doubleResult);
    }

    @Test
    void shouldReturn32() throws Exception {
        var result = mvc.perform(MockMvcRequestBuilders.post("/api/conversion/temperature")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new Appel("test", "test", 0, DateTime.now().toString(), 1))))
                .andExpect(status().isOk()).andReturn();

        var doubleResult = Double.valueOf(result.getResponse().getContentAsString());
        assertEquals(32.0, doubleResult);
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