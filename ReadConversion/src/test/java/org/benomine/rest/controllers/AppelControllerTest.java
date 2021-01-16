package org.benomine.rest.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class AppelControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/conversion").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":\"5ff77fc83e29f681cbf70c39\",\"nom\":\"BEN-PC\",\"nomUser\":\"Bob\",\"valeur\":17.0,\"dateAppel\":\"2021-01-02T20:35:27.276+00:00\"},{\"id\":\"5ff7b6da3e29f681cbf72d45\",\"nom\":\"BEN-MOBILE\",\"nomUser\":\"Benjamin\",\"valeur\":32.0,\"dateAppel\":\"2021-08-02T20:35:27.276+00:00\"},{\"id\":\"5ff7bed23e29f681cbf72fa8\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":13.0,\"dateAppel\":\"2021-01-08T02:09:19.236+00:00\"},{\"id\":\"5ff7c1343e29f681cbf730a2\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":0.0,\"dateAppel\":\"2021-01-08T02:19:32.120+00:00\"},{\"id\":\"5ff8c5a50415eb975b187d8e\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":32.0,\"dateAppel\":\"2021-08-02T20:35:27.276+00:00\"},{\"id\":\"5ff8c5b40415eb975b187d98\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":0.0,\"dateAppel\":\"2021-08-02T20:35:27.276+00:00\"},{\"id\":\"5ffa4b2b65462f6b9a1265f6\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":0.0,\"dateAppel\":\"2021-08-02T20:35:27.276+00:00\"},{\"id\":\"5ffb995c919eee77e811cf52\",\"nom\":\"BEN-PC\",\"nomUser\":\"Node\",\"valeur\":17.0,\"dateAppel\":\"2021-01-02T20:35:27.276+00:00\"},{\"id\":\"5ffbb921f28f224f8ce81376\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":0.0,\"dateAppel\":\"2021-08-02T20:35:27.276+00:00\"},{\"id\":\"5ffbb935f28f224f8ce81377\",\"nom\":\"NODE\",\"nomUser\":\"JS\",\"valeur\":0.0,\"dateAppel\":\"2021-08-02T20:35:27.276+00:00\"},{\"id\":\"5ffd0d1abb17de62800d8572\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":32.0,\"dateAppel\":\"2021-01-12T02:44:40.175+00:00\"},{\"id\":\"5ffd0d26bb17de62800d8573\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":0.0,\"dateAppel\":\"2021-01-12T02:44:52.469+00:00\"},{\"id\":\"5ffd0d57bb17de62800d8574\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":2.5,\"dateAppel\":\"2021-01-12T02:45:41.694+00:00\"},{\"id\":\"5ffedf73f1b22167d31a5eb5\",\"nom\":\"BEN-PC\",\"nomUser\":\"Benjamin\",\"valeur\":32.0,\"dateAppel\":\"2021-08-02T20:35:27.276+00:00\"}]")));
    }

    @Test
    public void getHelloById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/conversion/5ff77fc83e29f681cbf70c39").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":\"5ff77fc83e29f681cbf70c39\",\"nom\":\"BEN-PC\",\"nomUser\":\"Bob\",\"valeur\":17.0,\"dateAppel\":\"2021-01-02T20:35:27.276+00:00\"}")));
    }
}
