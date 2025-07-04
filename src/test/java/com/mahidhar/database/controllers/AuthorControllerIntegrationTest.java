package com.mahidhar.database.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahidhar.database.TestDatautil;
import com.mahidhar.database.domain.Entities.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    @Autowired
    public AuthorControllerIntegrationTest(MockMvc mockMvc){
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
    }
    //To test the status code from RESTAPI
    @Test
    public void testThatCreateAuthorIsReturning201Code() throws Exception {
        AuthorEntity authorEntity = TestDatautil.createAuthorA();
        String authorJson = objectMapper.writeValueAsString(authorEntity);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

    }
    //To Test the Input Data In RESTAPI
    @Test
    public void testThatCreateAuthorIsSaved() throws Exception {
        AuthorEntity authorEntity = TestDatautil.createAuthorA();
        String authorJson = objectMapper.writeValueAsString(authorEntity);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.name").value("mahi")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.age").value(23)
        );

    }
    @Test
    public void testThatListAuthorsGenerateAuthors() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/authors")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }
    @Test
    public void testThatGetAuthorsByIdGenerateStatusCode200Ok() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/authors/1")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(
                MockMvcResultMatchers.status()
                        .isOk()
        );
    }

}
