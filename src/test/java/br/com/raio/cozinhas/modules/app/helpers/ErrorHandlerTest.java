package br.com.raio.cozinhas.modules.app.helpers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ErrorHandlerTest {

    @Test
    void getStatus() {
        ErrorHandler error = new ErrorHandler("Error message", HttpStatus.ACCEPTED);
        assertEquals(error.getStatus().value(), 202);
    }

    @Test
    void getMessage() {
        ErrorHandler error = new ErrorHandler("Error message", HttpStatus.ACCEPTED);
        assertEquals(error.getMessage(), "Error message");
    }
}