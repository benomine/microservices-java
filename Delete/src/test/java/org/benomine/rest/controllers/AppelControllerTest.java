package org.benomine.rest.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
class AppelControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testDeleteAppelById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/conversion/delete/6015ad2f014f6307dd4784c3"))
                .andExpect(status().isNoContent());
    }
}