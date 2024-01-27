package org.projeto.projetoweb.resource.exceptions;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.projeto.projetoweb.services.exceptions.DatabaseException;
import org.projeto.projetoweb.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String erro = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError val = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(val);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> resourceNotFound(DatabaseException e, HttpServletRequest request) {
        String erro = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError val = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(val);
    }
}
