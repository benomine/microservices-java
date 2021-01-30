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

import java.time.Instant;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
class AppelControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testUpdateAppelShouldReturnOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/api/conversion/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new Appel("6015ad2f014f6307dd4784c3", "test2", "test", 1, Date.from(Instant.now())))))
                .andExpect(jsonPath("$.nom").value("test2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testPatchAppelShouldReturnOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.patch("/api/conversion/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new Appel("6015ad2f014f6307dd4784c3", "test3", "test", 1, Date.from(Instant.now())))))
                .andExpect(jsonPath("$.nom").value("test3"))
                .andExpect(status().isOk())
                .andDo(print());
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