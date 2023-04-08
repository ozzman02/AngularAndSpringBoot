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

import static com.clientes.api.exeception.CustomExceptionMapper.APPLICATION_EXCEPTIONS;
import static com.clientes.api.exeception.ExceptionConstants.*;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> dataAccessExceptionHandler(DataAccessException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, APPLICATION_EXCEPTIONS.get(DATA_ACCESS_EXCEPTION));
        response.put(ERROR, ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<?> customNotFoundExceptionHandler(CustomNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
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

}
