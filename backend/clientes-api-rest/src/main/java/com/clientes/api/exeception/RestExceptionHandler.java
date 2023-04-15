package com.clientes.api.exeception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.clientes.api.constants.ApplicationConstants.*;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> dataAccessExceptionHandler(DataAccessException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, DATA_ACCESS_EXCEPTION);
        response.put(ERROR, DATA_ACCESS_EXCEPTION_ERROR_MESSAGE);
        response.put(CAUSE, ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + " " + error.getDefaultMessage())
                .collect(Collectors.toList());
        response.put(ERRORS, errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<?> applicationExceptionHandler(ApplicationException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, ex.getMessageCategory());
        response.put(ERROR, ex.getMessage());
        return new ResponseEntity<>(response, ex.getHttpStatus());
    }

}
