package com.postgres.postgresnew;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class ShortTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            assertTrue(true, "Pomyślnie połączono z bazą danych");
        } catch (Exception e) {
            fail("Nie można połączyć się z bazą danych: " + e.getMessage());
        }
    }
}