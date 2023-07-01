package br.com.raio.cozinhas.modules.app;

import br.com.raio.cozinhas.modules.app.helpers.ErrorHandler;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(Error.class)
    @ResponseBody
    public ResponseEntity<Object> handleError(ErrorHandler error) throws JSONException {

        JSONObject response = new JSONObject();

        response.put("message", error.getMessage());
        response.put("status", error.getStatus().value());

        return new ResponseEntity<>(response.toString(), error.getStatus());
    }
}
