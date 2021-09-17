package com.morgan.api;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class MovieApiTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testList() throws Exception {
        createMovie();
       MvcResult result = mockMvc.perform(get("/movies")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    public Long createMovie() throws Exception {
        return Long.parseLong(mockMvc.perform(post("/movies").content("{\n" +
                "\t\"title\": \"Spiral\",\n" +
                "\t\"genre\": \"Thriller\",\n" +
                "\t\"runtime\": 93,\n" +
                "\t\"rating\": \"18\",\n" +
                "\t\n" +
                "\t\"actors\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"name\": \"Chris Rock\",\n" +
                "\t\t\t\"age\": 53,\n" +
                "\t\t\t\"gender\": \"male\"\n" +
                "\t\t}\n" +
                "\t\t]\n" +
                "}").contentType("application/json")).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void testGet() throws Exception {
        Long id = createMovie();
        MvcResult result = mockMvc.perform(get("/movies/{id}", id).accept("application/json")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }



}
