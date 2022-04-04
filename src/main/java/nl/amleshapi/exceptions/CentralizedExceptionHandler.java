package nl.amleshapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static nl.amleshapi.util.Constants.MESSAGE;
import static nl.amleshapi.util.Constants.TIMESTAMP;

/**
 * Centralized Exception handler to catch and format error response
 */
@RestControllerAdvice
public class CentralizedExceptionHandler {

    // Custom exception to handle runtime exceptions
    @ExceptionHandler(InternalException.class)
    public ResponseEntity<Map<String,Object>> handleInternalException(InternalException ex){
        Map<String,Object> body = new HashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE,ex.getMessage());
        return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Custom exception to handle Not Found  exceptions
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotFoundException(NotFoundException ex){
        Map<String,Object> body = new HashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE,ex.getMessage());
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

}
