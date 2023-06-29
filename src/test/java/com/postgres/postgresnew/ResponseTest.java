package com.postgres.postgresnew;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = SpringbootBackendApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResponseTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDatabaseConnection() {

        String endpoint = "http://localhost:" + port + "/api/v1/getBeauties";

        ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String responseBody = response.getBody();
        assertNotNull(response);
    }
}