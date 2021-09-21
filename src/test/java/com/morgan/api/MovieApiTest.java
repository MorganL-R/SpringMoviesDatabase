package com.morgan.api;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.text.Format;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class MovieApiTest {
    @Autowired
    private MockMvc mockMvc;
    private String movieJson = "{\"title\":\"Spiral\",\"genre\":\"Thriller\",\"runtime\":93,\"rating\":\"18\",\"actors\":[{\"name\":\"Chris Rock\",\"age\":53,\"gender\":\"male\"}]}";
    private String updatedMovieJson = "{\"id\":%s,\"title\":\"John\",\"genre\":\"Thriller\",\"runtime\":93,\"rating\":\"18\",\"actors\":[{\"id\":2,\"name\":\"Chris Rock\",\"age\":53,\"gender\":\"male\"}]}";


    @Test
    public void testList() throws Exception {
        createMovie();
       MvcResult result = mockMvc.perform(get("/movies")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    public Long createMovie() throws Exception {
        return Long.parseLong(mockMvc.perform(post("/movies")
                .content(movieJson).contentType("application/json")).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void testGet() throws Exception {
        Long id = createMovie();
        MvcResult result = mockMvc.perform(get("/movies/{id}", id).accept("application/json")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = createMovie();
        updateMovie(id);
        MvcResult result = mockMvc.perform(get("/movies/{id}", id)).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        String json = result.getResponse().getContentAsString();
        assertEquals(format(updatedMovieJson, id), json);
        System.out.print(json);
    }
    public void updateMovie(Long id) throws Exception {
            mockMvc.perform(put("/movies")
                    .content(format(updatedMovieJson, id)).contentType("application/json")).andReturn().getResponse().getContentAsString();
    }



}
